import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage  {
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private By emailField = By.id("ap_email");
    private By continueButton = By.id("continue");
    private By errorMessageBox = By.id("auth-error-message-box");
    private By errorText = By.cssSelector("span[class=\"a-list-item\"]");
    public void enterEmailAddress(String email)
    {
        driver.findElement(emailField).sendKeys(email);
    }
    public void clickOnContinueButton(){
        driver.findElement(continueButton).click();
    }
    public boolean isErrorBoxDisplayed(){
        return driver.findElement(errorMessageBox).isDisplayed();
    }
    public String getMessageText(){
        return driver.findElement(errorText).getText();
    }



}
