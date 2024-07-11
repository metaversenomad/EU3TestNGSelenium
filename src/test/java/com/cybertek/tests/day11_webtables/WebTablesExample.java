package com.cybertek.tests.day11_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExample {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/tables");
    }
    @AfterMethod
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void printTable() {
        WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));

        System.out.println(table.getText());
        Assert.assertTrue(table.getText().contains("jdoe@hotmail.com"));

    }
    @Test
    public void getAllHeaders() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());

        for (WebElement header : headers) {
            System.out.println(header.getText());
        }
    }
    @Test
    public void printTableSize() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());

        List<WebElement> allRowsWithHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println(allRowsWithHeader.size());

        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']//tbody"));
        System.out.println(allRowsWithoutHeader.size());
    }
    @Test
    public void getRow() {
        WebElement row2 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));
        System.out.println(row2.getText());

        List<WebElement> numRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        for (int i = 1; i <= numRows.size() ; i++) {
            WebElement row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]"));
            System.out.println(i+"-"+row.getText());
        }
//        *** loop shortcuts iter and itar

    }
    @Test
    public void getAllCellInOneRow() {
        List<WebElement> allcellsInOneRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));
        for (WebElement element : allcellsInOneRow) {
            System.out.println(element.getText());
        }
    }
    @Test
    public void getASingleCellInOneRow() {}
}
