package com.cybertek.tests.reviews.week02;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.demoblaze.com/index.html");

        driver.findElement(By.linkText("Laptops")).click();

        Thread.sleep(2000);

        driver.findElement(By.partialLinkText("Sony vaio i7")).click();

        Thread.sleep(2000);

        int expectedPrice = 790;

        WebElement priceTextElement = driver.findElement(By.tagName("h3"));

        String priceText = priceTextElement.getText();

        System.out.println("priceText = " + priceText);

        String []   arr = priceText.split(" ");

        int actualPrice = Integer.parseInt(arr[0].substring(1));

        System.out.println("Actual and Expected Prise is same :"+(expectedPrice==actualPrice));

        if(expectedPrice == actualPrice){
            System.out.println("Actual and Expected Prise is same");
        }else {
            System.out.println("Test Failed. price is not same");
        }

        driver.close();

    }

}
