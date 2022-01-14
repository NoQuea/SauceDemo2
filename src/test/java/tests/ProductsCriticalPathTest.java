package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class ProductsCriticalPathTest extends BaseTest {

    @Test (description = "Продукт должен быть добавлен в корзину и удален")
    public void productShouldAddedIntoCartAndRemove(){
        loginPage.loginToTheSystem();
        inventoryPage.addToCart("Sauce Labs Onesie");
        Assert.assertEquals(inventoryPage.getRemoveButtonText(),"REMOVE","The button is not found");

        inventoryPage.removeFromCart("Sauce Labs Onesie");
        Assert.assertEquals(inventoryPage.getAddButtonText(),"ADD TO CART","The button is not found");

    }
}
