package com.cybertek.tests.review.week01;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class T02_CybertekUrlTask {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://practice.cydeo.com/");

        driver.manage().window().maximize();

        String expectedUrlText = "cydeo";
        String actualUrlText = driver.getCurrentUrl();

        System.out.println("verify if the URL contains \"cydeo\" : "+actualUrlText.contains(expectedUrlText));

        System.out.println("Title verify : "+driver.getTitle().equalsIgnoreCase("Practice"));

        driver.close();

    }
}
