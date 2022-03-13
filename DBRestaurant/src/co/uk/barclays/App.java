package co.uk.barclays;

public class App {
    public static void main(String[] args) throws Exception {
        new DB("jdbc:sqlite:./database.sqlite"); // can have relative or absolute address
        // Restaurant.init();
        // Restaurant restaurant = new Restaurant("Yet Another Pub", "http://image.jpg");
        // Menu.init();
        // Menu menu = new Menu("Desserts");
        // Items.init();
        // Items items = new Items("Steak", 12.99);
        DB.conn.close();
    }
}
