package seleniumFramework.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumFramework.pageObject.CartPage3rd;
import seleniumFramework.pageObject.OrdersPage6th;

import java.time.Duration;

public class Utils {
    WebDriver driver;

    public Utils(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "[routerlink*='cart']")
    WebElement clickOnCart;

    @FindBy(css = "[routerlink*='myorders']")
    WebElement ordersButton;
    public void waitForElementToAppear(By findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }
    //We are using type "By" and var "findBy" because we are not checking driver.findElement,
    // instead we are just checking wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("toast-container")));
    //if we are using driver.findElement then the type must be "WebElement"
    public  void waitForInvisibilityOfElement(By findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
    }

    public CartPage3rd goToCartPage(){ //cart icon is visible from all the pages, so adding this method at parent level
        clickOnCart.click();
        //creating cart page object here itself, as we are aware that goToCartPage() will definitly land on cart page so no need to create carpage obj in test file
        CartPage3rd cartPage = new CartPage3rd(driver);
        return cartPage;
    }
    public OrdersPage6th goToOrdersPage(){
        ordersButton.click();
        OrdersPage6th ordersPageObj = new OrdersPage6th(driver);
        return ordersPageObj;
    }



}
