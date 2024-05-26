package com.cybertek.tests.day6_ccs;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class cssLocator {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://practice.cydeo.com/multiple_buttons");


    }
}
