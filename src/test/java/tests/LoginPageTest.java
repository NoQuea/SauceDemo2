package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginPageTest extends BaseTest {

    @Test
    public void validUserAndPassword() {
        loginPage.loginToTheSystem();
        Assert.assertEquals(inventoryPage.getTitleText(), "PRODUCTS", "Тайтл не соответствует ожидаемому");

    }
    @Test
    public void noUserName(){
        loginPage.openLoginPage();
        loginPage.login("","secret_sauce");
        Assert.assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Username is required",
                "Error Massage is invalid");
    }
    @Test
    public void noPassword(){
        loginPage.openLoginPage();
        loginPage.login("standard_user","");
        Assert.assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Password is required",
                "Error Massage is invalid");
    }

    @Test
    public void noEverything(){
        loginPage.openLoginPage();
        loginPage.login("","");
        Assert.assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Username is required",
                "Error Massage is invalid");
    }

    @Test
    public void lockedUser(){
        loginPage.openLoginPage();
        loginPage.login("locked_out_user","secret_sauce");
        Assert.assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Sorry, this user has been locked out.",
                "User is not blocked");
    }
}
