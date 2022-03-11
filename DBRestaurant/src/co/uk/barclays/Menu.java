package co.uk.barclays;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Menu {
    private String menu_title;
    private ArrayList<Items> items;
    
    public static void init() {
        try {
            Statement createTable = DB.conn.createStatement();
            createTable.execute("CREATE TABLE IF NOT EXISTS menus (id INTEGER PRIMARY KEY, menu_title TEXT);");
            Statement getMenus = DB.conn.createStatement();
            ResultSet menus = getMenus.executeQuery("SELECT * FROM menus;");
            while (menus.next()) {
                int id = menus.getInt(1);
                String menu_title = menus.getString(2);
                new Menu(id, menu_title);
            }
        } catch (SQLException error) {
            System.out.println("^" + error.getMessage());
        }
    }

    public Menu(int id, String menu_title) {
        this.menu_title = menu_title;
        this.items = new ArrayList<Items>();
    }

    public String getMenu_title() {
        return this.menu_title;
    }

    public ArrayList<Items> getItems() {
        return this.items;
    }

    
    
}
