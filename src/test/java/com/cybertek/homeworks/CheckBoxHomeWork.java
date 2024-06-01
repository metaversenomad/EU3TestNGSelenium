package com.cybertek.homeworks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class CheckBoxHomeWork {

    @Test
    public void Test1() {

//            source: https://gist.github.com/erdemOre/69d4af244e0f15c928d6714c0109ca93

         /*

    DocViewer
    Pages
    Test Case Verify CheckBox CheckAll and UncheckAll Buttons
    1. Go to
    http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
    2. Login with-----Username: Tester, password: test
    3. Click on check all button verify all the checkboxes are checked
    4. Click on uncheck all button verify that all the checkboxes are unchecked
    5. Select one of the checkbox and delete one person
    6. Then verify that deleted item is no longer exists
    Annotations

     */

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

        //go to 1. Go to
        //http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");


        //2. Login with-----Username: Tester, password: test
        WebElement userNameBox = driver.findElement(By.id("ctl00_MainContent_username"));
        WebElement passwordBox = driver.findElement(By.id("ctl00_MainContent_password"));

        String userName = "Tester";
        String password = "test";

        userNameBox.sendKeys(userName);
        passwordBox.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.id("ctl00_MainContent_login_button"));
        loginBtn.click();


        //3. Click on check all button verify all the checkboxes are checked
        WebElement checkAllBtn = driver.findElement(By.id("ctl00_MainContent_btnCheckAll"));
        checkAllBtn.click();


        for (int i = 1; i <= 8; i++) {

            //There are 8 checkbox WebElement with unique attribute: type, and it's value 'checkbox'
            //we use this XPATH indexing feature to check all of them with a for loop
            String checkBoxXPath = "(//input[@type = 'checkbox'])[" + i + "]";
            String verifyText = "verify that checkBox: " + i + " selected";
            WebElement checkBox = driver.findElement(By.xpath(checkBoxXPath));


            //We verify if each checkBox selected
            // and pass a unique verifyText message for each checkbox in case it gives error
            Assert.assertTrue(checkBox.isSelected(), verifyText);
        }

        //4. Click on uncheck all button verify that all the checkboxes are unchecked

        //first uncheck all
        WebElement uncheckAllBtn = driver.findElement(By.id("ctl00_MainContent_btnUncheckAll"));
        uncheckAllBtn.click();

        //then verify
        for (int i = 1; i <= 8; i++) {

            //using same for loop above
            String checkBoxPath = "(//input[@type = 'checkbox'])[" + i + "]";

            //the message is slightly different this time we check if NOT selected.
            String verifyText = "verify that checkBox: " + i + " NOT selected";


            WebElement checkBox = driver.findElement(By.xpath(checkBoxPath));
            //this for loop uses AssertFalse unlike above for loop for the verification of each checkBox
            Assert.assertFalse(checkBox.isSelected(), verifyText);
        }

        // 5. Select one of the checkbox and delete one person

        Random rand = new Random();

        //to make the test case more successful
        // we randomly select out of 8 checkboxes with unique type attribute
        int randomNum = rand.nextInt(8) + 1;
        String checkBoxXPath = "(//input[@type = 'checkbox'])[" + randomNum + "]";

        WebElement checkBox = driver.findElement(By.xpath(checkBoxXPath));
        checkBox.click();


        //The names or other info might be duplicate,
        // so we locate card number as a unique verification point for a customer
        String cardNumXPath = "//tr[" + (randomNum + 1) + "]//td[11]";
        //the reason we increase by 1 (randomNum + 1) is checkBox is in the second row of the table
        //so relevant row has 1 more number as we count also table head row to reach relevant row

        WebElement cardNumber = driver.findElement(By.xpath(cardNumXPath));
        String expectedOutcome = cardNumber.getText();


        WebElement deleteSelectedBtn = driver.findElement(By.cssSelector("[type = 'submit']"));
        deleteSelectedBtn.click();


        //Then verify that deleted item is no longer exists
        WebElement actualTable = driver.findElement(By.cssSelector(".SampleTable"));

        //we recieve all the html of the table to search for the unique card number inside
        String actualOutcome = actualTable.getAttribute("outerHTML");


        //we verify that card number of the deleted person NO Longer exists with AssertFalse method
        Assert.assertFalse(actualOutcome.contains(expectedOutcome));

//        quit browser
        driver.quit();
    }
}
