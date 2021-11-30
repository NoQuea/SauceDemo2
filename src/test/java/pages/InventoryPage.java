package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage{

    public static final String ADD_PRODUCT_BUTTON = "//div[div[div[a[div[@class='inventory_item_name'][text()='%s']]]]]//button[@data-test='add-to-cart-sauce-labs-onesie']";
    public static final String REMOVE_PRODUCT_BUTTON = "//div[div[div[a[div[@class='inventory_item_name'][text()='%s']]]]]//button[@data-test='remove-sauce-labs-onesie']";
    public static final By SHOPPING_CART_LINK = By.xpath("//a[@class='shopping_cart_link']");

    public InventoryPage(WebDriver driver){
        super(driver);
    }

    public void openCart(){
        cartPage.openCart();
    }

    public void addToCart(String nameProduct) {
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_BUTTON, nameProduct))).click();
    }

    public void removeFromCart(String nameProduct){
        driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_BUTTON, nameProduct))).click();
    }
}
