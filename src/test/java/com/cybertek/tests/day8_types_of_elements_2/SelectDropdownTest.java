package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropdownTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() {
        driver.get("https://practice.cydeo.com/dropdown");

        WebElement dropdownElement = driver.findElement(By.id("state"));

        Select stateDropdown = new Select(dropdownElement);

        List<WebElement> options = stateDropdown.getOptions();
        System.out.println("options.size() = " + options.size());

        for (WebElement option : options) {
            System.out.println(option.getText());
        }
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://practice.cydeo.com/dropdown");
        WebElement dropdownElement = driver.findElement(By.id("state"));

        Select stateDropdown = new Select(dropdownElement);

        String expectedOption = "Select a State";
        String actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, expectedOption,"verify first selection");

        Thread.sleep(2000);
        stateDropdown.selectByVisibleText("Virginia");

        expectedOption = "Virginia";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, expectedOption,"verify first selection");

        Thread.sleep(2000);
        stateDropdown.selectByIndex(51);

        expectedOption = "Wyoming";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, expectedOption,"verify first selection");

        Thread.sleep(2000);
        stateDropdown.selectByValue("TX");

        expectedOption = "Texas";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, expectedOption,"verify first selection");
    }

}
