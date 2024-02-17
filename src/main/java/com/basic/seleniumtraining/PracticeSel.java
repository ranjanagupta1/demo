package com.basic.seleniumtraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class PracticeSel {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Software\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //---------------------------------------------------Basic
 /*
//        driver.get("https://opensource-demo.orangehrmlive.com");
//        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
//        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
//        driver.findElement(By.xpath("//button[contains(@class,'orangehrm-login')]")).click();
//        driver.manage().window().minimize();
//        driver.manage().window().maximize();
//        String CEOName = driver.findElement(By.cssSelector("p[class='oxd-userdropdown-name']")).getText();
//        System.out.println(CEOName);
//
//        driver.findElement(By.cssSelector("i[class*='oxd-userdropdown-icon']")).click();
//        driver.findElement(By.xpath("//a[text()='About']")).click();
        //--------------------------------------------------------------Static and Dynamic Dropdown

        driver.get("https://rahulshettyacademy.com/dropdownsPractise");

        //Static
        WebElement selectCurrency = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(selectCurrency);
        dropdown.selectByIndex(1);
        String option= dropdown.getFirstSelectedOption().getText();
        System.out.println(option);
        //Static with adult and child count selection
        driver.findElement(By.id("divpaxinfo")).click();
        for(int i=1;i<5;i++){
            driver.findElement(By.xpath("//div/div/div[2]/span[@id='hrefIncAdt']")).click(); //here selecting multiple adults
        }
        driver.findElement(By.xpath("//input[@value='Done' and @type='button']")).click();

        driver.manage().window().maximize();
        //Dynamic
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
        driver.findElement(By.xpath("//a[@value='GAU'][1]")).click();
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).click();
        driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click();

        //auto-suggestion dynamic dropdown
        driver.findElement(By.id("autosuggest")).sendKeys("IND");
        List<WebElement> listOptions = driver.findElements(By.cssSelector("li[class='ui-menu-item']"));
        for(WebElement i:listOptions){
            if(i.getText().equalsIgnoreCase("India")){
                i.click();
                break;
            }
        }
        driver.findElement(By.xpath("//input[@name='ctl00$mainContent$view_date1']")).click();
        //Calender
        driver.findElement(By.cssSelector(".ui-datepicker-days-cell-over.ui-datepicker-today")).click();
        //Checkbox
        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
*/
    //------Add To Cart--------------------








    }
}
