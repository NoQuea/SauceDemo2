package tests;


import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest {

    @Test(description = "Cart login")
    public void entryToCart(){
        loginPage.loginToTheSystem();
        cartPage.openCart();
        assertEquals(cartPage.getTitleText(),"YOUR CART", "Title is not as expected");
    }

    @Test(description = "Exit the shopping cart by pressing the 'Continue Shopping' button")
    public void escapeFromCartWithTheContinueShoppingButton(){
        loginPage.loginToTheSystem();
        cartPage.openCart()
                .clickOnTheContinueShoppingButton();
        assertEquals(inventoryPage.getTitleText(), "PRODUCTS", "Navigation to Inventory page failed");
    }


    @Test(description = "Checking if an item has been added to the cart")
    public void сheckingIfAnItemHasBeenAddedToTheCart(){
        loginPage.loginToTheSystem();
        inventoryPage.addToCart("backpack");
        cartPage.openCart();
        assertEquals(inventoryPage.getRemoveButtonText("backpack"),"REMOVE","The product is not found");
    }

}
