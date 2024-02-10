import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TestBase {
  public static WebDriver driver ;
    public static HomePage homePage;
    SoftAssert softAssert = new SoftAssert();
    String url = "https://www.amazon.eg/-/en/";
    @BeforeTest
    public void openBrowser()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        homePage =new HomePage(driver);
    }
    @BeforeMethod
    public void goToUrl(){
        driver.get(url);
    }


    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
         driver.quit();
    }

    @AfterMethod
    public void takeScreenShotRecordFailure(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenShot = camera.getScreenshotAs(OutputType.FILE);
            Files.move(screenShot, new File("resources/screenShots/" + result.id() + ".png"));

        }

    }}
