package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    public static final By SHOPPING_CART_LINK = By.xpath("//a[@class='shopping_cart_link']");

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitleText() {
        return driver.findElement(By.cssSelector(".title")).getText();
    }


}
