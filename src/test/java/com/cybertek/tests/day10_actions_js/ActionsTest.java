package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
    @Test
    public void testActions() throws InterruptedException {
        driver.get("https://practice.cydeo.com/hovers");
        WebElement img1 = driver.findElement(By.tagName("img"));

        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.moveToElement(img1).perform();

        WebElement viewLink = driver.findElement(By.linkText("View profile"));
        Assert.assertTrue(viewLink.isDisplayed(), "verify view link is displayed");
    }
    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        List<WebElement> acceptAndClose = driver.findElements(By.xpath("//*[.='Accept and Close']"));
        List<WebElement> acceptCookies = driver.findElements(By.xpath("//*[.='Accept Cookies']"));
        if (acceptAndClose.size()>0){
            acceptAndClose.get(0).click();
        }else if (acceptCookies.size()>0){
            acceptCookies.get(0).click();
        }
        Thread.sleep(2000);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

//        driver.findElement(By.xpath("//*[.='Reject All']")).click();
        Thread.sleep(2000);
        actions.dragAndDrop(source, target).perform();
    }
    @Test
    public void dragAndDrop2() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        List<WebElement> acceptAndClose = driver.findElements(By.xpath("//*[.='Accept and Close']"));
        List<WebElement> acceptCookies = driver.findElements(By.xpath("//*[.='Accept Cookies']"));
        if (acceptAndClose.size()>0){
            acceptAndClose.get(0).click();
        }else if (acceptCookies.size()>0){
            acceptCookies.get(0).click();
        }
        Thread.sleep(2000);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

//        driver.findElement(By.xpath("//*[.='Reject All']")).click();
        Thread.sleep(2000);
        actions.dragAndDrop(source, target).perform();

        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().perform();
    }
}
