package co.uk.barclays;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Restaurant {
    private int id;
    private String name;
    private String imageURL;

    public static ArrayList<Restaurant> all = new ArrayList<>();

    public static void init() {
        // this method ensures the table has been created in the database
        try {
            Statement createTable = DB.conn.createStatement();
            createTable.execute(
                    "CREATE TABLE IF NOT EXISTS restaurants (id INTEGER PRIMARY KEY, name TEXT, imageURL TEXT);");
            Statement getRestaurants = DB.conn.createStatement();
            ResultSet restaurants = getRestaurants.executeQuery("SELECT * FROM restaurants;");
            while (restaurants.next()) {
                int id = restaurants.getInt(1);
                String name = restaurants.getString(2);
                String imageURL = restaurants.getString(3);
                new Restaurant(id, name, imageURL);
            }
        } catch (SQLException err) {
            System.out.println("*" + err.getMessage());
        }
    }

    public Restaurant(String name, String imageURL) {
        this.name = name;
        this.imageURL = imageURL;
        try {
            // when we use constructor we insert a restaurant into the database
            PreparedStatement insertRestaurant = DB.conn.prepareStatement("INSERT INTO restaurants (name, imageURL) VALUES (?, ?);");
            insertRestaurant.setString(1, this.name);
            insertRestaurant.setString(2, this.imageURL);
            insertRestaurant.executeUpdate();
            this.id = insertRestaurant.getGeneratedKeys().getInt(1);
        } catch (SQLException err) {
            System.out.println("&" + err.getMessage());
        }
        Restaurant.all.add(this);
    }

    public Restaurant(int id, String name, String imageURL) {
        // this constructor is for restaurant that already have an id
        this.id = id;
        this.name = name;
        this.imageURL = imageURL;
        Restaurant.all.add(this);
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public String getImageURL() {
        return imageURL;
    }

}
