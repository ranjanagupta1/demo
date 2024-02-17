package com.basic.seleniumtraining;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class TablesHandling {

    @Test
    public void method(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/"); //Table with col Instructor,Course,Price
        driver.manage().window().maximize();

        List<WebElement> col= driver.findElements(By.xpath("//table[@name='courses']/tbody/tr[1]/th"));
        int colCount=col.size();
        System.out.println(colCount);
        List<WebElement> row= driver.findElements(By.xpath("//table[@name='courses']/tbody/tr"));
        int rowCount=row.size();
        System.out.println(rowCount);

        //fetch all the header names
        List<String> headerNames=col.stream().map(m-> m.getText()).collect(Collectors.toList());
        System.out.println(headerNames);

        //fetch all the values from 2nd column i.e Course
        String before="//table[@name='courses']/tbody/tr[";
        String after="]/td[2]";
        for(int i=2;i<=rowCount;i++){
            String xPath=before+i+after;
            WebElement element=driver.findElement(By.xpath(xPath));
            System.out.println(element.getText());
        }

        //print course name whose price is 25
        String after1="]/td[3]";
        String after2="]/td[2]";
        for(int i=2;i<=rowCount;i++){
            String xPath=before+i+after1;
            WebElement element=driver.findElement(By.xpath(xPath));
            if(element.getText().equals("25")) {
                String course=driver.findElement(By.xpath(before+i+after2)).getText();
                System.out.println(course);
            }
        }
        driver.quit();
    }
    @Test
    public void method2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        String path1="//table[@id='customers']/tbody/tr[";
        String path2="]/td[2]";
        List<WebElement> table= driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
        int rows= table.size();
        System.out.println(rows);//print row size
        List<WebElement> column= driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th"));
        int col=column.size();
        System.out.println(col);//print col size
        column.stream().forEach(f-> System.out.println(f.getText()));//print col names
        for(int i=2;i< table.size();i++){
            String name= driver.findElement(By.xpath(path1+i+path2)).getText();
            System.out.println(name);//print all 2nd col values
        }
        driver.quit();
    }

}
