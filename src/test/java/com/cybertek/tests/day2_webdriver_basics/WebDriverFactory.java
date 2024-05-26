package com.cybertek.tests.day2_webdriver_basics;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

    public static void main(String[] args) {

//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();

        WebDriver driver = com.cybertek.utilities.WebDriverFactory.getDriver("chrome");

        driver.get("https://www.google.com");

        String title = driver.getTitle();

        System.out.println("Title: " + title);


    }

}
