package com.cybertek.tests.day7_types_of_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElements {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/radio_buttons");

        WebElement greenRadioBtn = driver.findElement(By.id("green"));
        greenRadioBtn.click();

        System.out.println("greenRadioBtn.isEnabled() = " + greenRadioBtn.isEnabled());

        Assert.assertFalse(greenRadioBtn.isEnabled(),"verify green radio button NOT enabled(disabled)");

        Thread.sleep(3000);

        driver.quit();

    }

    @Test
    public void test2() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));
        inputBox.sendKeys("some message");



    }
}
