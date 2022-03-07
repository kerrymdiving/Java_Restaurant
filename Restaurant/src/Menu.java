import java.util.ArrayList;

public class Menu {
    private String title;
    private ArrayList<Item> items;
    public Menu(String title) {
        this.title = title;
        this.items = new ArrayList<Item>();
    }
    public String getTitle() {
        return this.title;
    }
    public ArrayList<Item> getItems() {
        return this.items;
    }
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    
}
