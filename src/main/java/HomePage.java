import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
private WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
  private  By loginTab =By.id("nav-link-accountList");
    private By allTab = By.cssSelector("i[class=\"hm-icon nav-sprite\"]");
    private By toDaysDealsSection =By.xpath("//li/a[contains(text(),\"Today's Deals\")]");
   private By cartButton = By.id("nav-cart-count");
   private By orderListLink =By.id("nav_prefetch_yourorders");
    private By addressListLink =By.id("nav_prefetch_youraddresses");
    private By userListLink =By.cssSelector("a[href=\"/-/en/hz/wishlist/ls?requiresSignIn=1&ref_=nav_AccountFlyout_top_flyout_wishlist\"]");
  private By list = By.id("wishlist-page");

    public LoginPage clickOnLoginTab()
    {
      driver.findElement(loginTab).click();
      return new LoginPage(driver);
    }
    public String getURL(){
        return driver.getCurrentUrl();
    }
    public void clickOnAllTab()
    {
        driver.findElement(allTab).click();

    }
    public ToDaysDealsPage goToDaysSection(){
        String script ="arguments[0].scrollIntoView()";
        WebElement element = driver.findElement(toDaysDealsSection);
        ((JavascriptExecutor)driver).executeScript(script, element);
       driver.findElement(toDaysDealsSection).click();
        return new ToDaysDealsPage(driver);
    }
    public CartPage openCartPage(){
        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }
    public boolean checkUserIsNotSignIN(){
        Actions actions =new Actions(driver);
        actions.moveToElement(driver.findElement(loginTab)).perform();
        return driver.findElement(loginTab).isDisplayed();
    }
    public void openOrderList(){
        driver.findElement(orderListLink).click();
    }
    public void openAddressList(){
        driver.findElement(addressListLink).click();
    }
    public void openUserList(){
        driver.findElement(userListLink).click();
    }
    public String getPageTitle(){
        return driver.getTitle();
    }
    public boolean isListDisplayed(){
        return driver.findElement(list).isDisplayed();
    }
}
