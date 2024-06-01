package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/dynamic_loading/1");

        WebElement usernameInput = driver.findElement(By.id("username"));

        System.out.println("usernameInput.isDisplayed() = " + usernameInput.isDisplayed());

        Assert.assertFalse(usernameInput.isDisplayed(),"verify inputbox is not displayed");

        driver.findElement(By.cssSelector("#start>button")).click();

        Thread.sleep(6000);

        Assert.assertTrue(usernameInput.isDisplayed(),"verify username inputbox is displayed");


    }
}
