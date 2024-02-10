import org.testng.annotations.Test;

public class TestUnSignInUser extends TestBase {
    @Test(priority = 1)
    public void checkUserNavigatedTOLoginPageUserIsNotSignINOpenOrderList(){
       softAssert.assertTrue(homePage.checkUserIsNotSignIN());
      homePage.openOrderList();
       softAssert.assertEquals(homePage.getPageTitle()
               ,"Amazon Sign In");
       softAssert.assertAll();
    }

    @Test(priority = 2)
    public void checkUserNavigatedTOLoginPageUserIsNotSignINOpenAddressList(){
        softAssert.assertTrue(homePage.checkUserIsNotSignIN());
        homePage.openAddressList();
        softAssert.assertEquals(homePage.getPageTitle()
                ,"Amazon Sign In");
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void checkUserCanSeeUserList(){
        softAssert.assertTrue(homePage.checkUserIsNotSignIN());
        homePage.openUserList();
        softAssert.assertTrue(homePage.isListDisplayed());
        softAssert.assertAll();
    }
}
