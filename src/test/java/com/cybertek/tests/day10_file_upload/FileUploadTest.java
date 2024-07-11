package com.cybertek.tests.day10_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void test1() throws Exception {
        driver.get("https://practice.cydeo.com/upload");
        WebElement chooseFile = driver.findElement(By.name("file"));
        chooseFile.sendKeys("C:\\Users\\Mustafa\\Desktop\\EU7\\file.txt");
        driver.findElement(By.id("file-submit")).click();
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualFileName, "file.txt");
        
    }

}
