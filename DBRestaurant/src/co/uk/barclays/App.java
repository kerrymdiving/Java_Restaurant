package co.uk.barclays;

public class App {
    public static void main(String[] args) throws Exception {
        new DB("jdbc:sqlite:./database.sqlite"); // can have relative or absolute address
        Restaurant.init();
        Menu.init();
        Items.init();
        // create new restaurant, menu or item.....
        DB.conn.close();
    }
}
