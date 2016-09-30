package br.com.ruballo;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by marcosarruda on 9/25/16.
 */
public class QueriesTest {

    @Test
    public void createTablesTest() throws SQLException{
        SQLiteDB.executeUpdate(Queries.DROP_ALL_TABLES.getValue());
        SQLiteDB.executeUpdate(Queries.CREATE_TABLES.getValue());
        /*
        }catch (SQLException e){
            if(e.getMessage().endsWith("already exists"))
                System.out.println("result: " + e.getMessage());
        }
         */
    }

    @Test
    public void insertIntoTablesTest() throws SQLException{
        createTablesTest();
        SQLiteDB.executeUpdate(Queries.INSERT_BASIC_DATA.getValue());
    }

    @Test
    public void selectFromOfficesTest() throws SQLException{
        insertIntoTablesTest();
        ResultSet rs = SQLiteDB.executeQuery(Queries.GET_ALL_OFFICES.getValue());
        while(rs.next()){
            int id = rs.getInt("OFFICE_ID");
            String  name = rs.getString("OFFICE_NAME");
            System.out.println( "ID = " + id );
            System.out.println( "NAME = " + name );
            System.out.println();
        }
        Statement s = rs.getStatement();
        Connection c = s.getConnection();
        rs.close();
        s.close();
        c.close();
    }

    @Test
    public void selectFromServicesByOfficeTest() throws SQLException{
        int officeId = 1;
        insertIntoTablesTest();
        ResultSet rs = SQLiteDB.executeQuery(Queries.GET_SERVICE_BY_OFFICE.getValue() + officeId + ";" );
        while(rs.next()){
            int office_Id = rs.getInt("OFFICE_ID");
            int service_id = rs.getInt("SERVICE_ID");
            String name = rs.getString("SERVICE_NAME");
            String status = rs.getString("STATUS");
            System.out.println( "SERVICE_ID = " + service_id );
            System.out.println( "OFFICE_ID = " + office_Id );
            System.out.println( "SERVICE_NAME = " + name );
            System.out.println( "STATUS = " + status);
            System.out.println();
        }
        Statement s = rs.getStatement();
        Connection c = s.getConnection();
        rs.close();
        s.close();
        c.close();
    }
}
