package com.basic.seleniumtraining;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class AddToCart {
    public static void addToCartMethod(WebDriver driver,String[] VegArray){

        List<WebElement> allItemsList = driver.findElements(By.cssSelector(".product-name"));
        List vegList = Arrays.asList(VegArray); //converting string array to arraylist to make the search easier as arrayist has method contains()
        int j=0;

        for(int i=0; i<allItemsList.size();i++){

            String[] name = allItemsList.get(i).getText().split("-"); //here we are getting text=Cucumber - 1 Kg, so we are trimming this to compare with string array objs
            String trimmedName = name[0].trim(); //After split, it get divided into 2 i.e name[0]=Cucmber  and  name[1]= 1 Kg, so this line will trim the space
            if(vegList.contains(trimmedName)){
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click(); //we are clicking add to cart when i=cucumber;Should not use "//button[text()='ADD TO CART']" because text might vary or dynamic
                if(j==VegArray.length){ //using this to stop the loop once control will enter this if block 3 times as we have total 3 veggies to add to cart, we have declared j above and increamented as well
                    break;
                }
                //here we cant use break; directly with for loop because once we get the 1st veg then the loop itself will get exit and we wont get the next veg
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Software\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //Implicit wait is applicable for all the code lines
        WebDriverWait explicitWaitObj = new WebDriverWait(driver,Duration.ofSeconds(5)); //Created explicit wait obj and this obj can be used specifically whereever required
        //ADD To Cart scenario for multiple veggies
        String[] VegArray ={"Cucumber","Tomato","Brinjal"}; //making the code generic and creating string array

        driver.get("https://rahulshettyacademy.com/seleniumPractise");
        //need sometime to get loaded and is handld by implicit wait
        addToCartMethod(driver,VegArray);

        //After adding to card->Proceed for checkout and apply coupon
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        //wait should be there as the sendkeys is not wrking because its taking few millisecs to load which cant be visible directly
//        explicitWaitObj.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode"))); //explit wait will work until this locator gets located
        //Above wait can be achieved using fluent wait as well
        Wait<WebDriver> fluentWaitObj = new FluentWait(driver).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);//driver will look for msg every 5 sec until 15sec means 3 times
        WebElement foo = fluentWaitObj.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                if(driver.findElement(By.cssSelector(".promoCode")).isDisplayed()){
                    return driver.findElement(By.cssSelector(".promoCode"));
                }
                else {
                    return null;
                }
            }
        });
        System.out.println(driver.findElement(By.cssSelector(".promoCode")).isDisplayed());



        driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector(".promoBtn")).click();

        explicitWaitObj.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo"))); //Explicit wait is handling here

        Assert.assertEquals(driver.findElement(By.cssSelector(".promoInfo")).getText(),"Invalid code ..!");
        driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();





    }
}
