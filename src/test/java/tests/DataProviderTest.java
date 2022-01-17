package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class DataProviderTest extends BaseTest {
    @DataProvider(name = "loginData")
    public Object[][] inputForITechTask() {
        return new Object[][]{
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"adasd", "avsdv", "Epic sadface: Username and password do not match any user in this service"},
                {"", "", "Epic sadface: Username is required"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."}
        };
    }

    @Test(dataProvider = "loginData", description = "Running all negative checks with DataProvider")
    public void negativeLoginTest(String userName, String password, String errorMessage) {
        loginPage.openLoginPage();
        loginPage.login(userName, password);
        Assert.assertEquals(loginPage.getErrorMassage(), errorMessage,
                "Error Massage is invalid");
    }
}
