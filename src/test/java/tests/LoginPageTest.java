package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.base.Retry;


public class LoginPageTest extends BaseTest {

    @Test(groups = "smoke")
    public void validUserAndPassword() {
        loginPage.loginToTheSystem();
        Assert.assertEquals(inventoryPage.getTitleText(), "PRODUCTS", "Тайтл не соответствует ожидаемому");

    }
    @Test(priority = 1, description = "Пользователь не заполняет поле Login")
    public void noUserName(){
        loginPage.openLoginPage();
        loginPage.login("","secret_sauce");
        Assert.assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Username is required",
                "Error Massage is invalid");
    }
    @Test(priority = 2, description = "Пользователь не заполняет поле Password")
    public void noPassword(){
        loginPage.openLoginPage();
        loginPage.login("standard_user","");
        Assert.assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Password is required",
                "Error Massage is invalid");
    }

    @Test(priority = 2, description = "Пользователь вводит не валидные Login и Password")
    public void noValidLoginAndPassword(){
        loginPage.openLoginPage();
        loginPage.login("adasd","avsdv");
        Assert.assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Error Massage is valid");
    }

    @Test(priority = 3, dependsOnMethods = "noPassword", description = "Пользователь не заполняет поля Login и Password")
    public void noLoginAndPassword(){
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
