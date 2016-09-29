package br.com.ruballo;

import java.sql.*;
import java.util.Map;

/**
 * Created by marcosarruda on 9/24/16.
 */
public class SQLiteDB {

    public static ResultSet executeQuery(String query) throws SQLException{

        Statement stmt = createStatement();
        if(stmt == null) {
            throw new SQLException("Falha ao executar a query: " + query);

        }
        ResultSet r = stmt.executeQuery(query);
        closeConnection(stmt);
        return r;
    }

    public static void executeUpdate(String query) throws SQLException{
        Statement stmt = createStatement();
        if(stmt == null) {
            throw new SQLException("Falha ao executar a query: " + query);

        }
        stmt.executeUpdate(query);
        System.out.println("update '"+query.substring(0,20)+"(...)' executed sucessfully!" );
        closeConnection(stmt);
    }

    public static void executeUpdate(String query, Object[] params) throws SQLException{
        PreparedStatement stmt = createPreparedStatement(query);
        if(stmt == null) {
            throw new SQLException("Falha ao executar a query: " + query);

        }
        for(int i=0; i < params.length; i++){
            stmt.setObject(i+1, params[i]);
        }
        stmt.executeUpdate();
        System.out.println("update '"+query.substring(0,20)+"(...)' executed sucessfully!" );
        closeConnection(stmt);
    }

    public static String getOfficesSelects() throws SQLException{
        //"SELECT OFFICE_ID, OFFICE_NAME FROM OFFICE;"
        ResultSet rs = executeQuery(Queries.GET_ALL_OFFICES.getValue());
        StringBuffer officeSelects = new StringBuffer();
        while(rs.next()){
            officeSelects.append("<option value=\"")
                    .append(rs.getInt("OFFICE_ID"))
                    .append("\">")
                    .append(rs.getString("OFFICE_NAME"))
                    .append("</option>");
        }

        return officeSelects.toString();
    }

    public static String getServiceSelects() throws SQLException{
        //"SELECT OFFICE_ID, OFFICE_NAME FROM OFFICE;"
        ResultSet rs = executeQuery(Queries.GET_SERVICE_NAMES_ONLY.getValue());
        StringBuffer serviceSelects = new StringBuffer();
        while(rs.next()){
            serviceSelects.append("<option value=\"")
                    .append(rs.getString("SERVICE_NAME"))
                    .append("\">")
                    .append(rs.getString("SERVICE_NAME"))
                    .append("</option>");
        }

        return serviceSelects.toString();
    }

    //------------------------------------------------------------------------------------------
    // Auxiliary methods
    //------------------------------------------------------------------------------------------
    private static Statement createStatement(){
        Connection c = null;
        Statement s = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:ruballo.db");
            System.out.println("Opened database successfully");

            s = c.createStatement();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            s = null;
            //System.exit(0);
        }
        return s;
    }

    private static PreparedStatement createPreparedStatement(String query){
        Connection c = null;
        PreparedStatement s = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:ruballo.db");
            System.out.println("Opened database successfully");

            s = c.prepareStatement(query);
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            s = null;
            //System.exit(0);
        }
        return s;
    }



    private static void closeConnection(Statement s) throws SQLException{
        Connection c = s.getConnection();
        s.close();
        c.close();
    }

    public static void main( String args[] )
    {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String sql = "CREATE TABLE COMPANY " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " AGE            INT     NOT NULL, " +
                    " ADDRESS        CHAR(50), " +
                    " SALARY         REAL)";
            //TEXT = A date in a format like "YYYY-MM-DD HH:MM:SS.SSS"
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
}
