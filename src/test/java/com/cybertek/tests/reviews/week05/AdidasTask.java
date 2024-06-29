package com.cybertek.tests.reviews.week05;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AdidasTask {
    WebDriver driver;
    @BeforeMethod
    public void setUp() throws Exception {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.demoblaze.com/index.html");
    }
    @AfterMethod
    public void tearDown() throws Exception {
        driver.close();
    }
    public void navigateTo(String str){
        driver.findElement(By.partialLinkText(str)).click();
    }
    public int productAdder(String category, String product){
        navigateTo(category);
        navigateTo(product);
        WebElement priceElement = driver.findElement(By.tagName("h3"));
        String priceWholeText = priceElement.getText();
        System.out.println("priceWholeText = " + priceWholeText);
        String[] arr = priceWholeText.split(" ");
        int listPrice = Integer.parseInt(arr[0].substring(1)    );

//        handle pop up
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10 ));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        navigateTo("Home");
        return listPrice;
    }
    @Test
    public void Test(){
        productAdder("Laptop", "Sony vaio i5");
        productAdder("Laptop", "Dell i7 8gb");
    }
}
