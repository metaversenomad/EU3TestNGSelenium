package com.cybertek.tests.day7_types_of_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = (WebDriver) WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/radio_buttons");

        WebElement blueRadioBtn = driver.findElement(By.cssSelector("#blue"));
        WebElement redRadioBtn = driver.findElement(By.id("red"));

        System.out.println("blueRadioBtn.isSelected() = " + blueRadioBtn.isSelected());
        System.out.println("redRadioBtn.isSelected() = " + redRadioBtn.isSelected());

        Assert.assertTrue(blueRadioBtn.isSelected(), "verify that blue is selected");
        Assert.assertFalse(redRadioBtn.isSelected(), "verify that red is NOT selected");

        redRadioBtn.click();

        Assert.assertFalse(blueRadioBtn.isSelected(), "verify that blue is NOT selected");
        Assert.assertTrue(redRadioBtn.isSelected(), "verify that red is selected");

        Thread.sleep(3000);
        driver.quit();

    }
}
