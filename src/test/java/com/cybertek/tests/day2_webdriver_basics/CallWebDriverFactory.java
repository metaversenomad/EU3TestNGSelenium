package com.cybertek.tests.day2_webdriver_basics;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CallWebDriverFactory {

    public static void main(String[] args) {

//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.google.com");

        String title = driver.getTitle();
        System.out.println("title = " + title);

    }
}
