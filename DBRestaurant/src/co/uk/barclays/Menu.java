package co.uk.barclays;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Menu {
    private int restaurant_id;
    private String menu_title;
    private ArrayList<Items> items;
    private int id;

    public static void init() {
        try {
            Statement createTable = DB.conn.createStatement();
            createTable.execute("CREATE TABLE IF NOT EXISTS menus (id INTEGER PRIMARY KEY, restaurant_id INTEGER, menu_title TEXT);");
            Statement getMenus = DB.conn.createStatement();
            ResultSet menus = getMenus.executeQuery("SELECT * FROM menus;");
            while (menus.next()) {
                int id = menus.getInt(1);
                int restaurant_id = menus.getInt(2);
                String menu_title = menus.getString(3);
                new Menu(id, restaurant_id, menu_title);
            }
        } catch (SQLException error) {
            System.out.println("^" + error.getMessage());
        }
    }

    public Menu(int restaurant_id, String menu_title) {
        this.restaurant_id = restaurant_id;
        this.menu_title = menu_title;
        this.items = new ArrayList<Items>();
        try {
            PreparedStatement insertMenu = DB.conn
                    .prepareStatement("INSERT INTO menus (restaurant_id, menu_title) VALUES (?, ?);");
            insertMenu.setInt(1, restaurant_id);
            insertMenu.setString(2, menu_title);
            insertMenu.executeUpdate();
            this.id = insertMenu.getGeneratedKeys().getInt(1);
        } catch (SQLException err) {
            System.out.println("&" + err.getMessage());
        }
    }

    public Menu(int id, int restaurant_id, String menu_title) {
        this.id = id;
        this.restaurant_id = restaurant_id;
        this.menu_title = menu_title;
    }

    public String getMenu_title() {
        return this.menu_title;
    }

    public ArrayList<Items> getItems() {
        return this.items;
    }

}
