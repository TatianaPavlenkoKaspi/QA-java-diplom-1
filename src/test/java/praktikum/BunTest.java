package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BunTest {
    String name = "black bun";
    float price = 15.5f;

    @Test
    public void getPriceCorrectResultTest(){
        Bun bun = new Bun(name, price);
        float actualPrice = bun.getPrice();
        assertEquals("Incorrect price", price, actualPrice, 0.0f);
    }

    @Test
    public void getNameCorrectResultTest(){
        Bun bun = new Bun(name, price);
        String actualName = bun.getName();
        assertEquals("Incorrect name", name, actualName);
    }
}