import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCRUD {
    @Before
    public void setup() {
        new DB("jdbc:sqlite::memory:");
    }
    @Test
    public void can_connect_ok() {
        assertTrue(DB.conn instanceof Connection);
    }
    @Test(expected = Test.None.class)
    public void db_is_provisioned() throws SQLException {
        Statement checkSelect = DB.conn.createStatement();
        checkSelect.execute("SELECT * FROM restaurants"); 
    }
    @Test
    public void create() throws SQLException {
        PreparedStatement insert = DB.conn.prepareStatement("INSERT INTO restaurants (name) VALUES (?);");
        insert.setString(1, "Silk Road");
        insert.executeUpdate();
        Statement getRestaurant = DB.conn.createStatement();
        ResultSet results = getRestaurant.executeQuery("SELECT * FROM restaurants;");
        while(results.next()) {
            assertEquals(results.getString(2), "Silk Road");
        }
    }

    @After
    public void teardown() throws SQLException {
        DB.conn.close();
        // close connection to database to prevent memory leak
    }
}
