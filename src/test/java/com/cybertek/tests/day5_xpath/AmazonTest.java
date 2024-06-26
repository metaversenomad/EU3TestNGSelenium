package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.amazon.com/");

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='captchacharacters']"));
        searchBox.sendKeys("Selenium");

        driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();

        WebElement result = driver.findElement(By.xpath("//span[contains(text(),'results for')]"));

        String resultText = result.getText();

        System.out.println("resultText = " + resultText);
        
        String expectedResult = "1-48 of over 3,000 results for";
        
        if (expectedResult.equals(resultText)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("expectedResult = " + expectedResult);
            System.out.println("resultText = " + resultText);
        }
            

    }
}
