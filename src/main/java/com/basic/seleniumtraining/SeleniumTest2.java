package com.basic.seleniumtraining;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest2 {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Software\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
/*
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

//        WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")); //locating the dropdown location over the webpage
//        Select dropdown = new Select(staticDropDown); //handle static dropdown and it expects <select element in the argument so that it can directly locate that dropdown location
//        dropdown.selectByIndex(2);
//        dropdown.selectByValue("INR");
//        dropdown.getFirstSelectedOption().getText(); //Initially we selected INR, so this line will return the text written over it
//        dropdown.selectByVisibleText("AED");

        //----Handling static dropdown when we need to select count of type of passenger from the dropdown(like 2 adult,1 child)
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("hrefIncChd")).click(); //selecting 1 child
//        int i=0;
//        while(i<3){
//            driver.findElement(By.id("hrefIncAdt")).click(); //selecting 2 adults and +1 as 1 adult is already there on page by default
//            i++;
//        } OR can use for as below
        for(int i=1;i<3;i++){
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click(); //closing the dropdown by clicking on done
        driver.findElement(By.id("divpaxinfo")).getText();

        //-----Handling dynamic dropdown
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='DEL']")).click(); //here selenium will select the 1st option only as it searched from left to right even though there will be two elements found with the xpath search
        driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
        driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click(); //as dropdown is dynamic, using //a[@value='DEL'] will get 2 elements so adding [2] to select the 2nd search i.e left to right
//        driver.findElement(By.xpath("(////div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='DEL']")).click(); //without index way can locate using parent-child way

        //auto-suggestion dropdown

        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

        for(WebElement option : DropdownOptions){
            if(option.getText().equalsIgnoreCase("India")){
                option.click();
                break;
            }
        }
        //Checkbox Handling
        driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).click(); //id="ctl00_mainContent_chk_StudentDiscount"
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).isSelected()); //will be true if selected
//        List<WebElement> checkboxList= driver.findElements(By.xpath("//input[@type='checkbox']"));
//        int checkboxTotalCount = checkboxList.size();
//        System.out.println(checkboxTotalCount);
        System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size()); //Calculating total no of checkboxes present in the webpage and same thing is happening above but in 3 lines


        //Calendar Handling
        //Select the current date from the calendar
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click(); //added dot '.' as space was there in b/w class names i.e <a class="ui-state-default ui-state-highlight" href="#">24</a>

        //Know if webelement(calendar) is enabled/disabled
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click(); //this will click on option "round way" and the calendar will be enabled once we click
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")){ //HTML code is style="display: block; opacity: 1;" is when calendar enabled & style="display: block; opacity: 0.5;" when calendar is disabled
          System.out.println("Calendar is enabled");
          Assert.assertTrue(true); //this will PASS the script
        }
        else{
            System.out.println("Calendar is disabled");
            Assert.assertTrue(false); //this will FAIL the script
        }

        //Popup/Alerts handling
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("Ranjana");
        driver.findElement(By.id("alertbtn")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept(); //asking selenium to switch to window pop up from driver browser; this will accept the only button on the pop up
        driver.findElement(By.id("confirmbtn")).click();
        driver.switchTo().alert().getText();
        driver.switchTo().alert().dismiss(); //used to close the pop up
*/



    }
}
