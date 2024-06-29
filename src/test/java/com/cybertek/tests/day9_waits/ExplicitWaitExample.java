package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWaitExample {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void testExplicitWait() throws InterruptedException {
        driver.get("https://practice.cydeo.com/dynamic_loading/1");

        driver.findElement(By.tagName("button")).click();


        WebElement usernameInput = driver.findElement(By.id("username"));

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(usernameInput));

        usernameInput.sendKeys("MikeSmith");
    }
    @Test
    public void test2() throws InterruptedException {
        driver.get("https://practice.cydeo.com/dynamic_controls");

        driver.findElement(By.xpath("//*[.='Enable']")).click();

        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(inputBox));
        inputBox.sendKeys("MikeSmith");

    }

}
