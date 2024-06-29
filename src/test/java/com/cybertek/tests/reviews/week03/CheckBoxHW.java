package com.cybertek.tests.reviews.week03;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class CheckBoxHW {

    public WebDriver driver;

    @BeforeMethod
    public void openPage() {
        //http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.manage().window().maximize();

//        Login to WebPage
        WebElement userNameBox = driver.findElement(By.id("ctl00_MainContent_username"));
        userNameBox.sendKeys("Tester");
        WebElement passwordBox = driver.findElement(By.id("ctl00_MainContent_password"));
        passwordBox.sendKeys("test");
        WebElement submitButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        submitButton.click();
    }
    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }
    @Test (priority = 1)
    public void CheckBoxAll() {
        WebElement checkAllButton = driver.findElement(By.linkText("Check All"));
        checkAllButton.click();

        for (int i = 1; i < 8; i++) {
             String rowLocator = "(//input[@type='checkbox'])[" + i + "]";
             WebElement rowCheckBox = driver.findElement(By.xpath(rowLocator));
             Assert.assertTrue(rowCheckBox.isSelected(),"The CheckBox IS NOT selected");
        }
        WebElement uncheckAllButton = driver.findElement(By.linkText("Uncheck All"));
        uncheckAllButton.click();
        for (int i = 1; i < 8; i++) {
            String rowCheckBoxLocator = "(//input[@type='checkbox'])[" + i + "]";
            WebElement rowCheckBox = driver.findElement(By.xpath(rowCheckBoxLocator));
            Assert.assertFalse(rowCheckBox.isSelected(),"The CheckBox IS STILL selected");
        }
    }
    @Test (priority = 2)
    public void deletePersonTest() {
       /* Assert.assertTrue(driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("(//input[@type='checkbox'])[4]")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("(//input[@type='checkbox'])[5]")).isSelected());
*/
        String name = "Mark Smith";
        String locatorCheckBoxOfPerson = "//*[contains(text(),'"+name+"')]/preceding-sibling::*/input";
        WebElement checkBoxOfPerson = driver.findElement(By.xpath(locatorCheckBoxOfPerson));

        checkBoxOfPerson.click();
        WebElement deleteButton = driver.findElement(By.id("ctl00_MainContent_btnDelete"));
        deleteButton.click();

        ArrayList<String> names = new ArrayList<>();

        for (int i = 1; i < 7; i++) {
            String eachNameLocator = "(//input[@type='checkbox'])[" + i + "]/../../td[2]";
            WebElement eachNameElement = driver.findElement(By.xpath(eachNameLocator));
            String eachNameText = eachNameElement.getText();
            names.add(eachNameText);
        }
        System.out.println("names = " + names);
    }
}
