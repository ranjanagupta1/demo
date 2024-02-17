package seleniumFramework.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumFramework.resources.Utils;

import java.time.Duration;
import java.util.List;

public class ProductCatelog2ndPage extends Utils {

    WebDriver driver;
    WebElement prod;
    public ProductCatelog2ndPage(WebDriver driver){
        super(driver); //sending driver life from child class to parent class
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
/*
We use @FindBy only when we are locating via driver. example-
    @FindBy(css = ".mb-3")
    List<WebElement> products;
If we are locating without driver then we use By. example- By productsBy = By.cssSelector(".mb-3");
 */
    @FindBy(css = ".mb-3")
    List<WebElement> products;

    By productsBy = By.cssSelector(".mb-3");
    By prodBy = By.cssSelector("b");
    By addToCart=By.cssSelector(".card-body button:last-of-type");
    By waitForToastAppear= By.id("toast-container");
    By waitForPopupDisappear= By.id("toast-container");
    public List<WebElement> getProductsList(){
        waitForElementToAppear(productsBy);
        return products;
    }
    /*
    Below stream() is used to iterate like a FOR loop.
    So each product will be sent to filter() having conditions where
    we are doing findElement using product not driver and it will look for tag b only in the 1st product section.
     */
    public WebElement getProductByName(String name){
        prod =getProductsList().stream().filter(product->product.findElement(prodBy).getText().equalsIgnoreCase(name)).findFirst().orElse(null);
        return prod;
    }
    public void addProductToCart(String name){
        WebElement prod=getProductByName(name);
        prod.findElement(addToCart).click();
        waitForElementToAppear(waitForToastAppear); //waiting for pop up to appear
        waitForInvisibilityOfElement(waitForPopupDisappear);//waiting for pop up to disappear

    }

}
