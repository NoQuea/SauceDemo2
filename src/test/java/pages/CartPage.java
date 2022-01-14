package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

    public static final By SHOPPING_CART_LINK = By.xpath("//a[@class='shopping_cart_link']");
    public static final By CHECKOUT_BUTTON = By.xpath("//button[@data-test='checkout']");
    public static final By CONTINUE_SHOPPING_BUTTON = By.xpath("//button[@data-test='continue-shopping']");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open cart")
    public void openCart(){
        driver.get("https://www.saucedemo.com/cart.html");
    }


}
