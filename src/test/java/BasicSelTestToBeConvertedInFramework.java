import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class BasicSelTestToBeConvertedInFramework {
    public static void main(String[] args) {


        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Software\\chromedriver-win64\\chromedriver.exe");
        options.addArguments("--remote-allow-origins=*");
//        WebDriverManager.chromedriver().setup(); Currently not working without proxy(need port and localhosted server)
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://rahulshettyacademy.com/client");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //page login
        driver.findElement(By.id("userEmail")).sendKeys("guptaranjanasahu@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Ranjana555");
        driver.findElement(By.id("login")).click();

        String prodName="Laptop";
        //take all the items in a list and select any to add to cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
        /*
        Below stream() is used to iterate like a FOR loop.
        So each product will be sent to filter() having conditions where
        we are doing findElement using product not driver and it will look for tag b only in the 1st product section.
         */
       WebElement prod = products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(prodName)).findFirst().orElse(null);
       prod.findElement(By.cssSelector(".card-body button:last-of-type")).click(); //product id is stored in prod and here clicking on addtocart of that product


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));//waiting for pop up to appear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("toast-container")));//waiting for pop up to disappear
        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

        List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
        Boolean checkMatch = cartProducts.stream().anyMatch(item->item.getText().equalsIgnoreCase(prodName));//instead of filter() using anyMatch which returns boolean value as we dont required webelemet
        Assert.assertTrue(checkMatch);
        driver.findElement(By.cssSelector(".totalRow button")).click(); //clicking on checkout button

        Actions act = new Actions(driver);
        act.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"India").build().perform();//for country search input, sending India
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();//selecting India from dynamic dropdown 2nd option
        driver.findElement(By.cssSelector(".action__submit")).click();
        String confirmMsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
        Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        driver.close();






    }
}
