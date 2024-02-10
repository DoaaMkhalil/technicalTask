import org.testng.annotations.Test;

public class TestAddToCard extends TestBase{
    String productQuantity="2";
    String productName, productPrice;

    @Test
    public void verifyAddedItem()
    {
       softAssert.assertEquals(homePage.getURL(),url);
       homePage.clickOnAllTab();
       ToDaysDealsPage toDaysDealsPage=  homePage.goToDaysSection();
       ProductCatalog productCatalog= toDaysDealsPage.openFirstProduct(1);


          if (productCatalog.getSize()>0)
          { productCatalog.SelectSize();}

       productCatalog.chooseProductQTY(productQuantity);
       productName =productCatalog.getProductName();
       productPrice=productCatalog.getProductPrice();
       productCatalog.clickOnAddToCartButton();
       CartPage cartPage=homePage.openCartPage();
        System.out.println(productName);
        System.out.println(cartPage.getItemName());
       softAssert.assertTrue(productName.contains(cartPage.getItemName()),"1");
       softAssert.assertTrue(cartPage.getItemPrice().contains(productPrice),"2");
       softAssert.assertEquals(cartPage.getItemQTY(),productQuantity);
       softAssert.assertAll();

    }
}
