package com.basic.seleniumtraining;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Assignments {


    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Software\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);


        //--------------------------------------------------------------------------------------------------Assignment7
        //Dropdown Questions
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXT")).click();

        //fetch all the options from the dynamic dropdown
        List<WebElement> li=driver.findElements(By.cssSelector("#dropdownGroup1 div ul li"));
        List<String> option1=li.stream().map(m->m.getText()).collect(Collectors.toList());
        System.out.println(option1);

        //Print all dropdown options except Adampur (AIP)
        List<String> option2=li.stream().filter(f->!f.getText().equalsIgnoreCase("Adampur (AIP)")).map(m->m.getText()).toList();
        System.out.println(option2);

        //click on option Ahmedabad
        WebElement option3=li.stream().filter(f->f.getText().equalsIgnoreCase("Ahmedabad (AMD)")).findAny().get();
        option3.click();



/*
        //--------------------------------------------------------------------------------------------------Assignment6
        //Q-Select any checkbox and print the name of selected checkbox
        //Q- Select the option from drodown and the name should be name as of checkbox-dont hard code
        //Q-Enter the same selection name over the edit box i.e enter yr name box
        //Q-Check alert and verify if same name is displaying over the alert

        driver.get("http://qaclickacademy.com/practice.php");
        driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]/input")).click();
        String opt=driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();
        WebElement dropdown=driver.findElement(By.id("dropdown-class-example"));
        Select s=new Select(dropdown);
        s.selectByVisibleText(opt);
        driver.findElement(By.name("enter-name")).sendKeys(opt);
        System.out.println(driver.findElement(By.name("enter-name")).getAttribute("value"));//this will fetch the entered value from the text field

        driver.findElement(By.id("alertbtn")).click();
        String text=  driver.switchTo().alert().getText();
        if(text.contains(opt))
        {
            System.out.println("Alert message success");
        }else
            System.out.println("Something wrong with execution");
    //  System.out.println( driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText());



        //---------------------------------------------------------------------------------------------------------------Assignment5
        //Q-Nested Frames Handling

        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Nested Frames")).click();
        //getting count of frames available
        int frameCount = driver.findElements(By.tagName("frame")).size();
        System.out.println(frameCount);
        //switching to top frame
        driver.switchTo().frame("frame-top");
        //switching to middle frame as it is child of top frame
        driver.switchTo().frame("frame-middle");
        //getting teh text printed in the middle frame
        String name = driver.findElement(By.id("content")).getText();
        System.out.println(name);


        //-----------------------------------------------------------------------------------------------------------------------------------------Assignment4
        //Q-Window Handles

        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
        driver.findElement(By.xpath("//a[@target='_blank' and text()='Click Here']")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> itr = windows.iterator();
        String parentId = itr.next();
        String childId = itr.next();
        driver.switchTo().window(childId);
        System.out.println("Child Window - "+driver.findElement(By.className("example")).getText());
        driver.switchTo().window(parentId);
        System.out.println("Parent Window - "+ driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText());

        driver.quit();

        //-----------------------------------------------------------------------------------------------------------------------------------------Assignment3
        //Q---Automate login, explicit wait, dropdown

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        driver.findElement(By.name("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");
        driver.findElement(By.cssSelector(".customradio:nth-child(2)")).click();

         //Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(7000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        driver.findElement(By.id("okayBtn")).click();
        WebElement option = driver.findElement(By.xpath("//select[@class='form-control']"));
        Select dropdown = new Select(option);
        dropdown.selectByValue("consult");
        driver.findElement(By.id("signInBtn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout")));
        List<WebElement> products = driver.findElements(By.cssSelector(".card-footer .btn-info"));

        for (int i = 0; i < products.size(); i++) {
            products.get(i).click();
        }
        driver.findElement(By.partialLinkText("Checkout")).click();


        //-----------------------------------------------------------------------------------------------------------------------------------------Assignment2
        //Q-In the form(https://rahulshettyacademy.com/angularpractice/), enter the details, check the checkbox,radio button, select dob from calendar and submit the form.
        // Post that capture the text for succesfully submitted

        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.findElement(By.name("name")).sendKeys("Ranjana Gupta");
//        driver.findElement(By.xpath("//div[@class='form-group']/input[@name='name'][1]")).sendKeys("Ranjana Gupta");
        driver.findElement(By.cssSelector("div[class='form-group'] input[name='email']")).sendKeys("gupta@gmail.com");
        driver.findElement(By.cssSelector("div[class='form-group'] input[placeholder='Password']")).sendKeys("Abc123");
        driver.findElement(By.id("exampleCheck1")).click();
        WebElement locatedropdown = driver.findElement(By.id("exampleFormControlSelect1"));
        Select dropdown=new Select(locatedropdown);
        dropdown.selectByVisibleText("Female");
        driver.findElement(By.xpath("//label[text()='Employed']")).click();
        driver.findElement(By.name("bday")).sendKeys("20/09/1995");
        driver.findElement(By.className("btn-success")).click();
        System.out.println(driver.findElement(By.className("alert-success")).getText());
        Thread.sleep(4000);
        driver.close();

        //----------------------------------------------------------------------------------------------------------------------------------------Assignment1
        //Q-Check the first  Checkbox and verify if it is successfully checked and Uncheck it again to verify if it is successfully Unchecked

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("checkBoxOption1")).click();
        Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
        driver.findElement(By.id("checkBoxOption1")).click();
        Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());

        //How to get the Count of number of check boxes present in the page
        int checkboxCount = driver.findElements(By.xpath("//input[@type='checkbox']")).size();
        System.out.println(checkboxCount);

        //scroll the page vertically
        Actions scroll=new Actions(driver);
        scroll.moveToElement(driver.findElement(By.cssSelector("#courses-iframe"))).perform();
        scroll.keyDown(Keys.PAGE_DOWN).sendKeys(Keys.END).build().perform();
 */














    }
}
