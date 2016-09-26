package br.com.ruballo;

import org.junit.Test;

import java.sql.SQLException;

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

    public void selectFromRegionTest() throws SQLException{
        SQLiteDB.executeQuery(Queries.INSERT_BASIC_DATA.getValue());
    }
}
