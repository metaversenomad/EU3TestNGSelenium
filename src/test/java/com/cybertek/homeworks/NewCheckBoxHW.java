package com.cybertek.homeworks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewCheckBoxHW {

//    üç gün uğraştım bunu yapmmaya!..

    @Test
    public void webOrdersTest() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

//        1.	Go to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.manage().window().maximize();

//        2.	Login with-----Username: Tester, password: test
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

//        3.	Click on check all button verify all the checkboxes are checked
        WebElement checkAll = driver.findElement(By.id("ctl00_MainContent_btnCheckAll"));
        checkAll.click();

        WebElement checkbox1 = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl02_OrderSelector"));
        System.out.println("checkbox1.isSelected() = " + checkbox1.isSelected());
        Assert.assertTrue(checkbox1.isSelected(),"checkbox1 is selected");

        WebElement checkbox2 = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl03_OrderSelector"));
        System.out.println("checkbox2.isSelected() = " + checkbox2.isSelected());
        Assert.assertTrue(checkbox2.isSelected(),"checkbox2 is selected");

        WebElement checkbox3 = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl04_OrderSelector"));
        System.out.println("checkbox3.isSelected() = " + checkbox3.isSelected());
        Assert.assertTrue(checkbox3.isSelected(),"checkbox3 is selected");

        WebElement checkbox4 = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl05_OrderSelector"));
        System.out.println("checkbox4.isSelected() = " + checkbox4.isSelected());
        Assert.assertTrue(checkbox4.isSelected(),"checkbox4 is selected");

        WebElement checkbox5 = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl06_OrderSelector"));
        System.out.println("checkbox5.isSelected() = " + checkbox5.isSelected());
        Assert.assertTrue(checkbox5.isSelected(),"checkbox5 is selected");

        WebElement checkbox6 = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl07_OrderSelector"));
        System.out.println("checkbox6.isSelected() = " + checkbox6.isSelected());
        Assert.assertTrue(checkbox6.isSelected(),"checkbox6 is selected");

        WebElement checkbox7 = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl08_OrderSelector"));
        System.out.println("checkbox7.isSelected() = " + checkbox7.isSelected());
        Assert.assertTrue(checkbox7.isSelected(),"checkbox7 is selected");

        WebElement checkbox8 = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl09_OrderSelector"));
        System.out.println("checkbox8.isSelected() = " + checkbox8.isSelected());
        Assert.assertTrue(checkbox8.isSelected(),"checkbox8 is selected");

//        4.	Click on uncheck all button verify that all the checkboxes are unchecked
        WebElement unCheckAll = driver.findElement(By.cssSelector("#ctl00_MainContent_btnUncheckAll"));
        unCheckAll.click();

        WebElement checkbox11 = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl02_OrderSelector"));
        System.out.println("checkbox11.isSelected() = " + checkbox11.isSelected());
        Assert.assertFalse(checkbox11.isSelected(),"checkbox11 is NOT selected");

        WebElement checkbox12 = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl03_OrderSelector"));
        System.out.println("checkbox12.isSelected() = " + checkbox12.isSelected());
        Assert.assertFalse(checkbox12.isSelected(),"checkbox12 is NOT selected");

        WebElement checkbox13 = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl04_OrderSelector"));
        System.out.println("checkbox13.isSelected() = " + checkbox13.isSelected());
        Assert.assertFalse(checkbox13.isSelected(),"checkbox13 is NOT selected");

        WebElement checkbox14 = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl05_OrderSelector"));
        System.out.println("checkbox14.isSelected() = " + checkbox14.isSelected());
        Assert.assertFalse(checkbox14.isSelected(),"checkbox14 is NOT selected");

        WebElement checkbox15 = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl06_OrderSelector"));
        System.out.println("checkbox15.isSelected() = " + checkbox15.isSelected());
        Assert.assertFalse(checkbox15.isSelected(),"checkbox15 is NOT selected");

        WebElement checkbox16 = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl07_OrderSelector"));
        System.out.println("checkbox16.isSelected() = " + checkbox16.isSelected());
        Assert.assertFalse(checkbox16.isSelected(),"checkbox16 is NOT selected");

        WebElement checkbox17 = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl08_OrderSelector"));
        System.out.println("checkbox17.isSelected() = " + checkbox17.isSelected());
        Assert.assertFalse(checkbox17.isSelected(),"checkbox17 is NOT selected");

        WebElement checkbox18 = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl09_OrderSelector"));
        System.out.println("checkbox18.isSelected() = " + checkbox18.isSelected());
        Assert.assertFalse(checkbox18.isSelected(),"checkbox18 is NOT selected");

//        5.	Select one of the checkbox and delete one person
        driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl06_OrderSelector")).click();
        driver.findElement(By.cssSelector("#ctl00_MainContent_btnDelete")).click();

//        6.	Then verify that deleted item is no longer exists
        WebElement checkbox = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl06_OrderSelector"));
        checkbox.getAttribute("value");
        Assert.assertTrue(checkbox.isDisplayed(),"verify checkbox is enabled");
        System.out.println("checkbox.isDisplayed() = " + checkbox.isDisplayed());

        Thread.sleep(3000);

        driver.quit();

    }
}
