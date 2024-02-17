package com.basic.seleniumtraining;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DynamicDropdown {
    @Test
    public void method() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.makemytrip.com/");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//label[@for='fromCity']/input[@id='fromCity']")).click();
        driver.findElement(By.xpath("//*[@placeholder='From']")).sendKeys("mu");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> dropdown= driver.findElements(By.xpath("//*[@class='react-autosuggest__suggestions-list']/li"));//here we should get the cound of all the options
        for(WebElement w:dropdown){
            String name = w.findElement(By.xpath("//li[@class='react-autosuggest__suggestion']/div/div[2]")).getText();
            System.out.println(name);
            if(name.equalsIgnoreCase("MUC")){
                w.click();
                break;
            }
        }


    }
}
