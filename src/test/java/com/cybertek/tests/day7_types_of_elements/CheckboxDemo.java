package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxDemo {

    @Test
    public void CheckboxDemo() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("//input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[2]"));

        System.out.println("checkbox1.isSelected() = " + checkbox1.isSelected());
        System.out.println("checkbox2.isSelected() = " + checkbox2.isSelected());

        Assert.assertFalse(checkbox1.isSelected(),"verify checkbox1 is not selected");
        Assert.assertTrue(checkbox2.isSelected(),"verify checkbox2 is selected");

        checkbox1.click();

        Assert.assertTrue(checkbox1.isSelected(),"verify checkbox1 is selected");
        Assert.assertTrue(checkbox2.isSelected(), "verify checkbox2 is selected");

        driver.quit();
    }
}
