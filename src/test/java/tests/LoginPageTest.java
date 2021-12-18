package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.base.Retry;


public class LoginPageTest extends BaseTest {

    @DataProvider(name = "Входящие данные для задачки iTechArt")
    public Object[][] inputForITechTask() {
        return new Object[][]{
                {"", "Epic sadface: Username is required", "Error Massage is invalid"},
                {"", "", ""},
                {"", "", ""},
                {"", "", ""}
        };
    }


    @Test(retryAnalyzer = Retry.class)
    public void validUserAndPassword() {
        loginPage.loginToTheSystem();
        Assert.assertEquals(inventoryPage.getTitleText(), "PRODUCTS", "Тайтл не соответствует ожидаемому");

    }
    @Test(priority = 1)
    public void noUserName(){
        loginPage.openLoginPage();
        loginPage.login("","secret_sauce");
        Assert.assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Username is required",
                "Error Massage is invalid");
    }
    @Test(description = "No Password")
    public void noPassword(){
        loginPage.openLoginPage();
        loginPage.login("standard_user","");
        Assert.assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Password is required",
                "Error Massage is invalid");
    }

    @Test(alwaysRun = true, dependsOnMethods = "noPassword")
    public void noEverything(){
        loginPage.openLoginPage();
        loginPage.login("","");
        Assert.assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Username is required",
                "Error Massage is invalid");
    }

    @Test(invocationCount = 100, threadPoolSize = 10)
    public void lockedUser(){
        loginPage.openLoginPage();
        loginPage.login("locked_out_user","secret_sauce");
        Assert.assertEquals(loginPage.getErrorMassage(),
                "Epic sadface: Sorry, this user has been locked out.",
                "User is not blocked");
    }


}
