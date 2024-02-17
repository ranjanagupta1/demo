package seleniumFramework.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumFramework.resources.Utils;

import java.util.List;

public class OrdersPage6th extends Utils {
    WebDriver driver;
    public OrdersPage6th(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//tr/td[2]")
    List<WebElement> ordersList;

    public boolean lookForProduct(String prodName){
        boolean orderMatched = ordersList.stream().anyMatch(order->order.getText().equalsIgnoreCase(prodName));
//        boolean orderMatched = ordersList.stream().anyMatch(order->order.getText().equalsIgnoreCase(prodName));//instead of filter() using anyMatch which returns boolean value as we dont required webelemet

        return orderMatched;
    }

}
