import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRestaurant {
    @Test
    public void restaurant_has_menus() {
        Restaurant restaurant = new Restaurant("Chez Kerry", "www.ChezKerry.com");
        assertEquals("Chez Kerry" + "www.ChezKerry.com", restaurant.getName() + restaurant.getImageUrl());
        restaurant.getMenus().add(new Menu("Dinner"));
        assertEquals("Dinner", restaurant.getMenus().get(0).getTitle());
    }
}
