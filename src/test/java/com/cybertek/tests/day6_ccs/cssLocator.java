package com.cybertek.tests.day6_ccs;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cssLocator {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://practice.cydeo.com/multiple_buttons");

        WebElement dontClick = driver.findElement(By.id("disappearing_buttonasdasd"));

        System.out.println(dontClick.getText());


    }
}
