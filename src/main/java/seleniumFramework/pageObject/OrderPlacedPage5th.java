package seleniumFramework.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import seleniumFramework.resources.Utils;

public class OrderPlacedPage5th extends Utils {
    WebDriver driver;
    public OrderPlacedPage5th(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
@FindBy(css = ".hero-primary")
WebElement confirmationMessage;
    public String getConfirmationMessage(){
        return confirmationMessage.getText();
    }

}
