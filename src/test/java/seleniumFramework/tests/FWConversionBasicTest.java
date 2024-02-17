package seleniumFramework.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import seleniumFramework.pageObject.*;
import seleniumFramework.testComponents.BaseTest;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class FWConversionBasicTest extends BaseTest {

    String prodName="Laptop";
    @Test(dataProvider = "getData")
    public void placeE2eOrder() throws IOException {
//        LandingPage1st landingPage = launchApp(); Commented this as we are already triggring this launchapp method using testng @BeforeMethod

        //page login
        ProductCatelog2ndPage prodCatelog = landingPage.loginToApp("guptaranjanasahu@gmail.com","Ranjana555");

    //take all the items in a list and select any to add to cart
//        List<WebElement> products = prodCatelog.getProductsList();

        prodCatelog.getProductByName(prodName);
        prodCatelog.addProductToCart(prodName); //product id is stored in prod and here clicking on addtocart of that product

        CartPage3rd cartPage = prodCatelog.goToCartPage(); //child class objects can access parent class methods due to which its not necessary to create parent class object to call its function

        boolean isMatchSuccessfull = cartPage.checkMatch(prodName);//Matching the added product to the product available in the cart
        Assert.assertTrue(isMatchSuccessfull);
        CheckoutPage4th checkoutpage = cartPage.clickOnCheckoutButton();

        checkoutpage.addCountryInSearchInput("India");//for country search input, sending India
        checkoutpage.selectCountryFromDropdown();//selecting India from dynamic dropdown 2nd option
        OrderPlacedPage5th orderPlaced = checkoutpage.clickOnSubmit();//click on place order button
        orderPlaced.getConfirmationMessage();
        Assert.assertTrue(orderPlaced.getConfirmationMessage().equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }

    //Method to validate the prodName="Laptop" for which order has been placed is visible in orders sections or not
    //Using TestNG Data provider method i.e "dependsOnMethods"
    @Test(dependsOnMethods ={"placeE2eOrder"})
    public void validatePlacedOrder(String prodName) throws IOException {

        ProductCatelog2ndPage prodCatelog = landingPage.loginToApp("guptaranjanasahu@gmail.com","Ranjana555");
        OrdersPage6th ordersobj= prodCatelog.goToOrdersPage();
        boolean matchOrder = ordersobj.lookForProduct(prodName);
        Assert.assertTrue(matchOrder);
    }

    /*Test to use DataProvider which takes input from json file and uses in the code
    //Scenario: want to execute the method with two different test data
        @Test(dataProvider = "getData")  //this method needs test data from getData()
    public void placeE2eOrder(String email,String password,String prodName) throws IOException {
    //same code as above method

    @DataProvider
    public Object[][] getData(){

        //creating obj of two dimentional arrray data i.e 1st is id and 2nd is pass
        return new Object[][] {{"guptaranjanasahu@gmail.com","Ranjana555","Laptop"},{"userId@gmailcom","password@gmailcom","ZARA COAT 3"}}; //placeE2eOrder() will be executed three times with 3 diffrent test data
    }
*/

}
