package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class CartTest extends BaseTest {

    @Test(description = "Вход в корзину")
    public void entryToCart(){
        loginPage.loginToTheSystem();
        cartPage.openCart();
        Assert.assertEquals(cartPage.getTitleText(),"YOUR CART", "Title is not as expected");
    }

}
