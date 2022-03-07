import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestMenu {
    @Test
    public void menu_has_name_and_items() {
        Menu menu = new Menu("Dinner");
        assertEquals("Dinner", menu.getTitle());
        // from left: create new item, using method .add(), add to ArrayList in menu
        menu.getItems().add(new Item("Steak", 14.99));
        // check item is there in menu array: 
        // open up menu created on line 8, look at ArrayList using getItems(), use get(0) to locate
        // first item of ArrayList using index (0), use method getName() to get the name of that item.
        assertEquals("Steak", menu.getItems().get(0).getName());

    }
}
