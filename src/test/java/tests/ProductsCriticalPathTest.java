package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class ProductsCriticalPathTest extends BaseTest {

    @Test (description = "The product should be added into cart and removed")
    public void productShouldAddedIntoCartAndRemove(){
        loginPage.loginToTheSystem();
        inventoryPage.addToCart("backpack");
        Assert.assertEquals(inventoryPage.getRemoveButtonText("backpack"),"REMOVE","The button is not found");

        inventoryPage.removeFromCart("backpack");
        Assert.assertEquals(inventoryPage.getAddButtonText("backpack"),"ADD TO CART","The button is not found");
    }
}
