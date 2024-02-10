import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductCatalog {
    private By addToCartButton = By.cssSelector("span[class=\"a-button-inner\"] input[id=\"add-to-cart-button\"]");
    private By productQTY = By.id("quantity");

    private By productSize= By.id("native_dropdown_selected_size_name");
    private By productName =By.id("productTitle");
    private By productPrice =By.cssSelector("div[id=\"corePriceDisplay_desktop_feature_div\"] span[class=\"a-price-whole\"]");

    private WebDriver driver;

    public ProductCatalog(WebDriver driver) {
        this.driver=driver;
    }
    public void SelectSize(){
        Select selectQTY = new Select(driver.findElement(productSize));
        selectQTY.selectByIndex(2);
    }
    public int getSize(){
        return driver.findElements(productSize).size();
    }
    public void chooseProductQTY(String i){
        Select selectQTY = new Select(driver.findElement(productQTY));
        selectQTY.selectByVisibleText(i);
    }
    public void clickOnAddToCartButton(){
        driver.findElement(addToCartButton).click();
    }

   public String getProductName(){
      return   driver.findElement(productName).getText();
   }
   public String getProductPrice(){
      return   driver.findElement(productPrice).getText();
   }

}
