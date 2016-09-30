package br.com.ruballo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by marcosarruda on 9/24/16.
 */
public class SQLiteDB {

    private static String URI_DB = "jdbc:sqlite:ruballo.db";

    public static ResultSet executeQuery(String query) throws SQLException{

        Statement stmt = createStatement();
        if(stmt == null) {
            throw new SQLException("Falha ao executar a query: " + query);

        }
        ResultSet r = stmt.executeQuery(query);
        System.out.println("executeQuery() executed! - Query: " + query);
        //closeConnection(stmt);
        return r;
    }

    public static void executeUpdate(String query) throws SQLException{
        Statement stmt = createStatement();
        if(stmt == null) {
            throw new SQLException("Falha ao executar a query: " + query);

        }
        stmt.executeUpdate(query);
        //stmt.getConnection().commit();
        System.out.println("update '"+query+"' executed sucessfully!" );
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
        stmt.getConnection().commit();
        System.out.println("update '"+query.substring(0,20)+"(...)' executed sucessfully!" );
        closeConnection(stmt);
    }

    public static ArrayList<Office> getOfficesSelects() throws SQLException{
        //"SELECT OFFICE_ID, OFFICE_NAME FROM OFFICE;"
        ResultSet rs = executeQuery(Queries.GET_ALL_OFFICES.getValue());
        ArrayList<Office> offices = new ArrayList<Office>();
        while(rs.next()){
            Office o = new Office(rs.getInt("OFFICE_ID"), rs.getString("OFFICE_NAME"));
            offices.add(o);
        }
        System.out.println("Existem " + offices.size() + " offices!");
        closeConnection(rs.getStatement());

        return offices;
    }

    public static ArrayList<Service> getServiceSelects(int officeId) throws SQLException{

        //"SELECT OFFICE_ID, OFFICE_NAME FROM OFFICE;"
        ResultSet rs = SQLiteDB.executeQuery(Queries.GET_SERVICE_BY_OFFICE.getValue() + officeId + ";");
        ArrayList<Service> services = new ArrayList<Service>();
        while(rs.next()){
            Service s = new Service(rs.getInt("SERVICE_ID"), rs.getInt("OFFICE_ID"), rs.getString("SERVICE_NAME"));
            services.add(s);
        }
        System.out.println("Existem " + services.size() + " services!");
        closeConnection(rs.getStatement());
        return services;
    }

    //------------------------------------------------------------------------------------------
    // Auxiliary methods
    //------------------------------------------------------------------------------------------
    private static Statement createStatement(){
        Connection c = null;
        Statement s = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(URI_DB);
            System.out.println("o caminho(URL é): "+c.getMetaData().getURL());
            System.out.println("Created the statement!!");

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
            c = DriverManager.getConnection(URI_DB);
            s = c.prepareStatement(query);
            System.out.println("Created Prepared Statement!");
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
}
