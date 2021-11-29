package tests;

import org.testng.annotations.Test;

public class ProductsCriticalPathTest extends BaseTest{

    @Test
    public void productShouldAddedIntoCart(){
        loginToTheSystem();

        inventoryPage.addToCart("Sauce Labs Onesie");
        inventoryPage.removeFromCart("Sauce Labs Onesie");
//        Assert.assertEquals();
//        cartPage.
    }
}
