package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;

    @BeforeMethod
    public void setUp() {
        BasicConfigurator.configure();
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws InterruptedException {
        Thread.sleep(1500);
        driver.quit();
    }

    @Test
    public void loginToTheSystem(){
        loginPage.openLoginPage();
        loginPage.login("standard_user", "secret_sauce");
    }
}
