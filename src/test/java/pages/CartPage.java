package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

    public static final By CHECKOUT_BUTTON = By.xpath("//button[@data-test='checkout']");
    public static final By CONTINUE_SHOPPING_BUTTON = By.xpath("//button[@data-test='continue-shopping']");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open cart")
    public CartPage openCart(){
        driver.get("https://www.saucedemo.com/cart.html");
        return this;
    }

    @Step("Click on the Continue Shopping button")
    public CartPage clickOnTheContinueShoppingButton(){
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
        return new CartPage(driver);
    }

    @Step("Click on the Checkout button")
    public CartPage clickOnTheCheckoutButton(){
        driver.findElement(CHECKOUT_BUTTON).click();
        return new CartPage(driver);
    }

    @Step("Click on the Shopping Cart link")
    public CartPage clickOnTheShoppingCartLink(){
        driver.findElement(SHOPPING_CART_LINK).click();
        return new CartPage(driver);
    }

}
