package com.basic.seleniumtraining;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;


public class SeleniumTest3 {

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Software\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        Wait<WebDriver> wait =new FluentWait<>(driver).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

        //-------------------------------------------------Que------------------------------------------------------------


/*
        //-------------------------------------------------Links Interview Que------------------------------------------------------------

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
          WebDriverWait exwait = new WebDriverWait(driver,Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.alertIsPresent());

        int linkCount = driver.findElements(By.tagName("a")).size();
        System.out.println("Total links over the webpage = "+linkCount);

        //count the links only on the footer of the web page
        WebElement footer = driver.findElement(By.id("gf-BIG"));
        int footerLinksCount = footer.findElements(By.tagName("a")).size(); //limiting driver scope from global web page to only footer
        System.out.println("Links count only in teh footer = "+footerLinksCount);

        //count links of only 1st column
        WebElement footer1stCol = footer.findElement(By.tagName("ul"));
        int footer1stColLinkCount = footer1stCol.findElements(By.tagName("a")).size();
        System.out.println("Total count of links available in the 1st column of footer = "+footer1stColLinkCount);

        //Click on each link of the 1st column and check if the pages are opening or not and get the title
        //Aproach1--basic and time taking
//        for(int i=1;i<footer1stColLinkCount;i++){
//            String clickOnLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
//            footer1stCol.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
//            Set<String> windowsId =  driver.getWindowHandles();
//            Iterator<String> itr = windowsId.iterator();
//            String parentWindow = itr.next();
//            String childWindow= itr.next();
//            driver.switchTo().window(childWindow);
//            System.out.println(driver.getTitle());;
//            driver.close();
//            driver.switchTo().window(parentWindow);
//            Thread.sleep(5000);
//        }
        //Approach2--improvement--reduced code
        for(int i=1;i<footer1stColLinkCount;i++){
            String clickOnLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
            footer1stCol.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
            Thread.sleep(5000);
        }
            Set<String> abc = driver.getWindowHandles();//here we are printing all the titles of the opened pages
            Iterator<String> itr = abc.iterator();
            while(itr.hasNext()){
                driver.switchTo().window(itr.next());
                System.out.println(driver.getTitle());
            }

        //------------------------------------------------------------Handling Mouse Hover and Keyboard inputs---------------------------------
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        //send input in txt box using action class
        Actions acn = new Actions(driver);
        WebElement aSearch=driver.findElement(By.xpath("//input[@placeholder='Search Amazon']"));
//        aSearch.sendKeys("gif");
        acn.moveToElement(aSearch).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform(); //this will click on search box and enter the text in caps and double click will select that text
        //Mouse Hover
        WebElement hoverElement =driver.findElement(By.xpath("//span[text()='Account & Lists']"));
        acn.moveToElement(hoverElement).build().perform();//Hover
        acn.moveToElement(hoverElement).contextClick().build().perform();//will do right click

        //----------------------------------------------------Check if any alert is present---------------------------------------------------
        try {
            if (exWait.until(ExpectedConditions.alertIsPresent()) == null) {
                System.out.println("No Alert is present");
            } else {
                driver.switchTo().alert().dismiss();
            }
        }
        catch (Exception e){
            System.out.println("No Alert is present");
        }

        //--------------------------------------------------------------------------Child Window Handling------------------------------------------------
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[text()='Free Access to InterviewQues/ResumeAssistance/Material']")).click();
        Set<String> windows = driver.getWindowHandles(); //will give all the opened windows id i.e parent and child
        Iterator<String> itr = windows.iterator();//this will iterate to all the windows ID
        //Doing next() will keep on going to next index
        String parentId = itr.next();//using next, it will go to 0th indexc window i.e parent window
        String childId = itr.next();//this will give the 1st index id i.e 1st child window
        driver.switchTo().window(childId);//pass the window id that u wanna switch



        String mailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
        String userName= mailId.split("@")[1].split("\\.")[0];
        System.out.println(userName);

          // String text1[] = text.split("\\s");//mentor@rahulshettyacademy.com
          // String mailId = text1[4].trim().;
          // System.out.println(mailId);

        driver.switchTo().window(parentId);//switching back to parent
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys(userName);
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("learning");
        driver.findElement(By.cssSelector("input[type='checkbox']")).click();
        driver.findElement(By.id("signInBtn")).click();
        driver.quit();

        //-------------------------------------------------Frames Handling-Drag and Drop------------------------------------------------------------

        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();

        //will get to know if any frame is available on the webpage
        int countOfFramesOnPage = driver.findElements(By.tagName("iframe")).size();
        System.out.println(countOfFramesOnPage);

        //switching to the frame with tag <iframe>
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
        Actions acn = new Actions(driver);
        WebElement sourceToDrag = driver.findElement(By.id("draggable"));
        WebElement targetToDrop = driver.findElement(By.id("droppable"));

        //Actions class is needed for drag and drop
        acn.dragAndDrop(sourceToDrag,targetToDrop).build().perform();

        //have to switch back to webpage from frames after performing action
        driver.switchTo().defaultContent();
*/
































    }
}
