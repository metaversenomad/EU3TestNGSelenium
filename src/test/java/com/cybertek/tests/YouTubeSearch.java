package com.cybertek.tests;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YouTubeSearch {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.youtube.com/");
        driver.manage().deleteAllCookies();

        WebElement searchBox = driver.findElement(By.id("search-input"));
        searchBox.sendKeys("Java");
    }
}
