package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage{

    public static final String ADD_PRODUCT_BUTTON = "//div[div[div[a[div[@class='inventory_item_name'][text()='%s']]]]]//button[@data-test='add-to-cart-sauce-labs-onesie']";
    public static final String REMOVE_PRODUCT_BUTTON = "//div[div[div[a[div[@class='inventory_item_name'][text()='%s']]]]]//button[@data-test='remove-sauce-labs-onesie']";


    public InventoryPage(WebDriver driver){
        super(driver);
    }

    public void openCart(){
        driver.get("https://www.saucedemo.com/cart.html");
    }

    public void addToCart(String nameProduct) {
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_BUTTON, nameProduct))).click();
    }

    public void removeFromCart(String nameProduct){
        driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_BUTTON, nameProduct))).click();
    }
}
