package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;

    @Mock
    Bun bun;
    Ingredient ingredient1 = mock(Ingredient.class);
    Ingredient ingredient2 = mock(Ingredient.class);


    @Test
    public void addIngredientReturnCorrectResultTest(){
        burger = new Burger();
        burger.addIngredient(ingredient1);
        assertEquals("Error while adding ingredients", 1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientReturnCorrectResultTest(){
        burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(1, 0);
        assertEquals("Error while moving ingredients", "ingredient2", burger.ingredients.get(0).toString());
    }

    @Test
    public void removeIngredientReturnCorrectResultTest(){
        burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(1);
        assertEquals("Error while deleting ingredients", 1, burger.ingredients.size());
    }

    @Test
    public void getPriceReturnCorrectResultTest(){
        burger = new Burger();
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(200f);
        float actual = bun.getPrice();
        assertEquals("Error while price was counting", 200f, actual, 0);
    }

    @Test
    public void getReceiptReturnCorrectResultTest(){
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        Mockito.when(bun.getName()).thenReturn("bunName");
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1.getName()).thenReturn("ingredientName");
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getName()).thenReturn("secondIngredientName");
        Mockito.when(burger.getPrice()).thenReturn(188f);
        String result = burger.getReceipt();
        String expectedResult = String.format(
                "(==== %s ====)%n"
                        + "= %s %s =%n"
                        + "= %s %s =%n"
                        + "(==== %s ====)%n"
                        +  "%nPrice: %f%n",
                "bunName", "sauce","ingredientName", "filling","secondIngredientName", "bunName", 188f);
        assertEquals("Check error", expectedResult, result);

    }
}