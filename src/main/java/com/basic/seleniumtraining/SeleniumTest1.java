package com.basic.seleniumtraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class SeleniumTest1 {
    public static void main(String[] args) throws InterruptedException {

 //Selenium uses chromedriver.exe file and .exe(3rd party) launch browser(no work for selenium)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Software\\chromedriver-win64\\chromedriver.exe"); //setting chromedriver location so that selenium can find the same and invoke////for chrome version 120 or higher, use this to download same version chromedriver https://googlechromelabs.github.io/chrome-for-testing/#stable
        //------chromedriver has all the methods related to do any func over the same. Method name will always be same across all the browser types
//        ChromeDriver driver = new ChromeDriver(); //driver obj will be able to access all the chromedriver methods
        //----Webdriver interface has all the methods(abstract,no body) which will be followed by all the browsers i.e browser implements webdriver and define the methods respectively.
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //this implicit wait will be applicable globally ie for all the lines below and it will return the result the moment it gets means it will not wait for complete 5 sec if value is fetched before
        String password = getPassword(driver);
//        Thread.sleep(2000); //this we use when we just want the below line to wait(script pauses) for complete 2 sec(2000ms)
        driver.get("https://opensource-demo.orangehrmlive.com"); //get() used to open the given website/webpage
        driver.manage().window().maximize(); //this will maximize the window
        System.out.println(driver.getTitle()); //used to get the title of the website
        System.out.println(driver.getCurrentUrl()); //used to get the original url as sometimes redirection happens by default e.g in case of any hacking or virus

         //-- Find element on page(Locators use)..As inspected, got name="username" on html page
        driver.findElement(By.name("username")).sendKeys("Admin1");
//        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123"); //placeholder="Password"name="password"type="password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.className("orangehrm-login-button")).click(); //class="oxd-button oxd-button--medium oxd-button--main orangehrm-login-button"
        System.out.println(driver.findElement(By.cssSelector("p.oxd-alert-content-text")).getText()); //<p class="oxd-text oxd-text--p oxd-alert-content-text" data-v-7b563373="" data-v-87fcf455="">Invalid credentials</p>

//        driver.findElement(By.name("username")).sendKeys("Admin2");
        driver.findElement(By.name("username")).clear(); //this will delete whats written
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("div[class='oxd-form-actions orangehrm-login-action'] button")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='oxd-topbar-header-breadcrumb']/h6")).getText(), "Dashboard");


//        driver.findElement(By.xpath("//div[@class='orangehrm-login-forgot']/p[1]")).click(); //<p class="oxd-text oxd-text--p orangehrm-login-forgot-header" data-v-7b563373="" data-v-358db50f="" xpath="1">Forgot your password? </p>
//          or
//        driver.findElement(By.xpath("//p[text()='Forgot your password? ']")).click(); //can use start as well instead of tagname i.e //*[text()='Forgot your password? ']

        driver.close(); //closes only the current opened window
//        driver.quit(); //close all opened associated window/tab/webpage that was opened by automation;can use when we open multiple windows in a scenario

    }
    public static String getPassword(WebDriver driver){ //creating this method to get the dynamic password from the web url itself
        driver.get("https://opensource-demo.orangehrmlive.com");
       String wholePass = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p'][2]")).getText();
       //Password : admin123
        String[] arrayPass = wholePass.split(":");
        String actualPass = arrayPass[1];
        return actualPass;
    }
}
