package seleniumFramework.testComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import seleniumFramework.pageObject.LandingPage1st;
import seleniumFramework.pageObject.OrdersPage6th;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    public LandingPage1st landingPage;
//    public OrdersPage6th ordersPageObj;
    public WebDriver initializeDriver() throws IOException {

        //accessing data of .properties file by creating properties object which will read the file C:\Users\dell\IdeaProjects\demo\src\main\java\seleniumFramework\resources\GlobalData.properties
        Properties prop= new Properties();
        FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\seleniumFramework\\resources\\GlobalData.properties"); //converting properties file into input stream which is a mandate parameter for load()
        prop.load(fis);//this load() will automatically parse all the data from peoperties file and extract all key-value pairs here

        String browserName = prop.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Software\\chromedriver-win64\\chromedriver.exe");
            options.addArguments("--remote-allow-origins=*");
//            WebDriverManager.chromedriver().setup(); //Currently not working without proxy(need port and localhosted server)
            driver = new ChromeDriver(options);

        } else if (browserName.equalsIgnoreCase("firefox")) {
            //write code of webdriver to run on firebox
        } else if (browserName.equalsIgnoreCase("edge")) {
            //write code of webdriver to run on edge
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
    @BeforeMethod
    public LandingPage1st launchApp() throws IOException {
        driver = initializeDriver();
        //creating landingPage object here itself, as we are aware that launchApp() will definitly land on landingPage so no need to create landingPage obj in test file
        landingPage = new LandingPage1st(driver);
        landingPage.goToWebsite();
        return landingPage;
    }
    @AfterMethod
    public void closeDriver(){
        driver.close();
    }
//    public OrdersPage6th ordersPageObjCreation(){
//        if(ordersPageObj==null) {
//            ordersPageObj = new OrdersPage6th(driver);
//        }
//        return ordersPageObj;
//    }
}
