import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestItem {
    @Test
    public void dish_has_a_price() {
        Item item = new Item("Steak", 14.99);
        assertEquals(item.getName() + item.getPrice(), "Steak" + 14.99);
    }
    
}
