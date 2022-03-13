package co.uk.barclays;

public class App {
    public static void main(String[] args) throws Exception {
        new DB("jdbc:sqlite:./database.sqlite"); // can have relative or absolute address
        // Restaurant.init();
        // Restaurant restaurant = new Restaurant("The Pub", "http://image.jpg");
        // Menu.init();
        // Menu menu = new Menu(1, "Desserts");
        // Items.init();
        // Items items = new Items(1, "Steak", 12.99);
        DB.conn.close();
    }
}
