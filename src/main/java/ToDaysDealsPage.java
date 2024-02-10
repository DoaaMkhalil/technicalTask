import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ToDaysDealsPage {
    private WebDriver driver;

    private By secondCategory = By.id("anonCarousel2");
    private By productList =By.cssSelector("ol  li");
    public ToDaysDealsPage(WebDriver driver) {
        this.driver = driver;
    }


    public ProductCatalog openFirstProduct(int productNum){
        System.out.println(driver.findElement(secondCategory).findElements(productList).size());
        driver.findElement(secondCategory).findElements(productList).get(productNum-1).click();
        return new ProductCatalog(driver);
    }


}
