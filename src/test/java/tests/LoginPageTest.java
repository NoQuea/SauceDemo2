package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;


public class LoginPageTest extends BaseTest {

    @Test(priority = 1, description = "The user fills in the Login and Password fields with valid values\n")
    public void validUserAndPassword() {
        loginPage.loginToTheSystem();
        Assert.assertEquals(inventoryPage.getTitleText(), "PRODUCTS", "Title is not as expected");

    }
    @Test(priority = 1, description = "The user does not fill in the Login field")
    public void noUserName(){
        loginPage.openLoginPage();
        loginPage.login("","secret_sauce");
        Assert.assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Username is required",
                "Error Massage is invalid");
    }
    @Test(priority = 2, description = "The user does not fill in the Password field")
    public void noPassword(){
        loginPage.openLoginPage();
        loginPage.login("standard_user","");
        Assert.assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Password is required",
                "Error Massage is invalid");
    }

    @Test(priority = 2, description = "User enters invalid Login and Password")
    public void noValidLoginAndPassword(){
        loginPage.openLoginPage();
        loginPage.login("adasd","avsdv");
        Assert.assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Error Massage is valid");
    }

    @Test(priority = 3, dependsOnMethods = "noPassword", description = "The user does not fill in the Login and Password fields")
    public void noLoginAndPassword(){
        loginPage.openLoginPage();
        loginPage.login("","");
        Assert.assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Username is required",
                "Error Massage is invalid");
    }

    @Test(priority = 3, description = "The user fills in the fields with a blocked Login")
    public void lockedUser(){
        loginPage.openLoginPage();
        loginPage.login("locked_out_user","secret_sauce");
        Assert.assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Sorry, this user has been locked out.",
                "User is not blocked");
    }


}
