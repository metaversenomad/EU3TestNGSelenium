package com.cybertek.tests.reviews.week02;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorHWTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.ebay.com");

        WebElement searchBox = driver.findElement(By.id("qh-ac"));

        String expectedSearchBox = "Selenium";

        searchBox.sendKeys(expectedSearchBox);

        driver.findElement(By.id("gh-btn")).click();

        WebElement searchResultElement = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']"));

        String searchResultText = searchResultElement.getText();

        System.out.println("searchResultText = " + searchResultText);

        Thread.sleep(2000);

        driver.quit();

    }
}
