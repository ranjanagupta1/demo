package seleniumFramework.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumFramework.resources.Utils;

public class LandingPage1st extends Utils {

    WebDriver driver;
    public LandingPage1st(WebDriver driver){
        super(driver); //sending driver life from child class to parent class
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "userEmail") //WebElement userEmail= driver.findElement(By.id("userEmail"));
    WebElement userEmail;
    @FindBy(id = "userPassword")//WebElement userPass = driver.findElement(By.id("userPassword"));
    WebElement userPass;

    /* below is done by using factory model which reduces code and resembles
     same as WebElement loginButton  = driver.findElement(By.id("login"));
     Hare we are not adding driver because we have initiated the driver above in the constructor itself.
     */
    @FindBy(id="login")
    WebElement loginButton;

    public void goToWebsite(){
        driver.get("https://rahulshettyacademy.com/client");
    }
    public ProductCatelog2ndPage loginToApp(String email,String pass){
        userEmail.sendKeys(email);
        userPass.sendKeys(pass);
        loginButton.click();
        //creating prodCatelog object here itself, as we are aware that loginToApp() will definitly land on prodCatelog page so no need to create prodCatelog obj in test file
        ProductCatelog2ndPage prodCatelog = new ProductCatelog2ndPage(driver);
        return prodCatelog;
    }
}
