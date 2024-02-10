import org.testng.annotations.Test;

public class TestNegativeLogin extends TestBase{

    @Test
    public void loginWithUnregisteredEmail()
    {
        softAssert.assertEquals(homePage.getURL(),url);
     LoginPage loginPage= homePage.clickOnLoginTab();
      loginPage.enterEmailAddress("doaamohmed1997@gmail.com");
      loginPage.clickOnContinueButton();
        softAssert.assertTrue(loginPage.isErrorBoxDisplayed());
        softAssert.assertEquals(loginPage.getMessageText(),
             "We cannot find an account with that email address");
        softAssert.assertAll();
    }
}
