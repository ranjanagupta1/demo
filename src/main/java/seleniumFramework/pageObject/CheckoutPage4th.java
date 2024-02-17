package seleniumFramework.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumFramework.resources.Utils;

public class CheckoutPage4th extends Utils {
    WebDriver driver;
    public CheckoutPage4th(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    /*
We use @FindBy only when we are locating via driver. example-
    @FindBy(css = ".mb-3")
    List<WebElement> products;
If we are locating without driver then we use By. example- By productsBy = By.cssSelector(".mb-3");
 */
    @FindBy(css = "[placeholder='Select Country']")
    WebElement locateCountry;
    By resultVisible = By.cssSelector(".ta-results");
    @FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
    WebElement selectCountry;
    @FindBy(css = ".action__submit")
    WebElement submit;

    public void addCountryInSearchInput(String country){
        Actions act = new Actions(driver);
        act.sendKeys(locateCountry,country).build().perform();//for country search input, sending India
        waitForElementToAppear(resultVisible);
    }
    public void selectCountryFromDropdown(){
        selectCountry.click();//selecting India from dynamic dropdown 2nd option
    }
    public OrderPlacedPage5th clickOnSubmit(){
        submit.click();
        //creating orderPlaced object here itself, as we are aware that clickOnSubmit() will definitly land on prodCatelog page so no need to create orderPlaced obj in test file
        OrderPlacedPage5th orderPlaced = new OrderPlacedPage5th(driver);
        return orderPlaced;
    }
}
