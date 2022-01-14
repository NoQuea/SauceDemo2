package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    WebDriver driver;
    LoginPage loginPage;
    CartPage cartPage;


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitleText() {
        return driver.findElement(By.cssSelector(".title")).getText();
    }

    public String getRemoveButtonText() {
        return driver.findElement(By.xpath("//*[@data-test='remove-sauce-labs-onesie']")).getText();
    }
    public String getAddButtonText() {
        return driver.findElement(By.xpath("//*[@data-test='add-to-cart-sauce-labs-onesie']")).getText();
    }
}
