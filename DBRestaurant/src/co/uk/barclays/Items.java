package co.uk.barclays;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Items {
    private String item_name;
    private double price;
    private int id;
    
    public static void init() {
        try {
            Statement createTable = DB.conn.createStatement();
            createTable.execute("CREATE TABLE IF NOT EXISTS items (id INTEGER PRIMARY KEY, item_name TEXT, price DOUBLE);");
            Statement getItems = DB.conn.createStatement();
            ResultSet items = getItems.executeQuery("SELECT * FROM items;");
            while (items.next()) {
                int id = items.getInt(1);
                String item_name = items.getString(2);
                double price = items.getDouble(3);
                new Items(id, item_name, price);
            }
        } catch (SQLException error) {
            System.out.println("£" + error.getMessage());
        }
    }

    public Items(String item_name, double price) {
        this.item_name = item_name;
        this.price = price;
        try {
            PreparedStatement insertItems = DB.conn.prepareStatement("INSERT INTO items (item_name, price) VALUES (?, ?);");
            insertItems.setString(1, this.item_name);
            insertItems.setDouble(2, this.price);
            insertItems.executeUpdate();
            this.id = insertItems.getGeneratedKeys().getInt(1);
        } catch (SQLException error) {
            System.out.println("%" + error.getMessage());

        }
    }

    public Items(int id, String item_name, double price) {
        this.id = id;
        this.item_name = item_name;
        this.price = price;
    }

	public String getItem_name() {
        return this.item_name;
    }

    public double getPrice() {
        return this.price;
    }
    
    
}
