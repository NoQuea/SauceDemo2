package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {


    public static final By USERNAME_INPUT = By.xpath("//input[@placeholder='Username']");
    public static final By PASSWORD_INPUT = By.xpath("//input[@placeholder='Password']");
    public static final By LOGIN_BUTTON_INPUT = By.xpath("//input[@type='submit']");
    public static final By ERROR_MASSAGE = By.cssSelector(".error-message-container");



    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open site")
    public void openLoginPage() {
        driver.get("https://www.saucedemo.com");
    }

    @Step("Login as user '{userName}' use password '{password}'")
    public void login(String userName, String password) {

        driver.findElement(USERNAME_INPUT).sendKeys(userName);

        driver.findElement(PASSWORD_INPUT).sendKeys(password);

        driver.findElement(LOGIN_BUTTON_INPUT).click();
    }

    @Step("Get error massage")
    public String getErrorMassage() {
        return driver.findElement(ERROR_MASSAGE).getText();
    }

    public void loginToTheSystem(){
        openLoginPage();
        login("standard_user", "secret_sauce");

    }

}
