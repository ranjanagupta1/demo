package seleniumFramework.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumFramework.resources.Utils;

import java.util.List;

public class CartPage3rd extends Utils {

    WebDriver driver;
    public CartPage3rd(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".cartSection h3")
    List<WebElement> cartProducts;
    @FindBy(css = ".totalRow button")
    WebElement checkoutButton;

//    public List<WebElement> fetchCartProducts(){
//        return cartProducts;
//    }
    public boolean checkMatch(String prodName){
        Boolean checkMatch = cartProducts.stream().anyMatch(item->item.getText().equalsIgnoreCase(prodName));//instead of filter() using anyMatch which returns boolean value as we dont required webelemet
        return checkMatch;
    }
    public CheckoutPage4th clickOnCheckoutButton(){

        checkoutButton.click(); //clicking on checkout button
        //creating checkout page object here itself as we are aware that clickOnCheckoutButton() will definitly land on checkout page so no need to create checkout obj in test file
        CheckoutPage4th checkoutpage = new CheckoutPage4th(driver);
        return checkoutpage;
    }

}
