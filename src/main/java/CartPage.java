import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;
    private By cartItemName =By.className("a-truncate-full");
    private By cartItemPrice =By.className("sc-product-price");
    private By cartItemQTY =By.className("a-dropdown-prompt");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public  String getItemName(){
        return driver.findElement(cartItemName).getText();
    }
    public  String getItemPrice(){
        return driver.findElement(cartItemPrice).getText();
    }
    public  String getItemQTY(){
        return driver.findElement(cartItemQTY).getText();
    }
}
