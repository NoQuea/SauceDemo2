package pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage{

    public static final String ADD_PRODUCT_BUTTON = "//button[@id='add-to-cart-sauce-labs-%s']";
    public static final String REMOVE_PRODUCT_BUTTON = "//button[@id='remove-sauce-labs-%s']";

    public InventoryPage(WebDriver driver){
        super(driver);
    }

    @Attachment(value = "screenshot", type = "image/png")
    @Step("Add to cart")
    public void addToCart(String nameProduct) {
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_BUTTON, nameProduct))).click();
    }

    @Attachment(value = "screenshot", type = "image/png")
    @Step("Remove from cart")
    public void removeFromCart(String nameProduct){
        driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_BUTTON, nameProduct))).click();
    }

    @Step("Getting the Remove button text")
    public String getRemoveButtonText(String nameProduct ) {
        return driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_BUTTON, nameProduct))).getText();
    }

    @Step("Getting the Add button text")
    public String getAddButtonText(String nameProduct) {
        return driver.findElement(By.xpath(String.format(ADD_PRODUCT_BUTTON, nameProduct))).getText();
    }

    @Step("Click on shopping cart link")
    public void clickOnShoppingCartLink() {
        driver.findElement(SHOPPING_CART_LINK).click();
    }
}
