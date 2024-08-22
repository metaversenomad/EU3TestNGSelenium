package com.cybertek.tests;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YouTubeSearch {
    public static void main(String[] args) throws InterruptedException {

        // Set the path to your ChromeDriver executable
        WebDriverManager.chromedriver().setup();
        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.youtube.com");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        // Çerezleri kabul et
        WebElement cookies = driver.findElement(By.xpath("//button[@class='yt-spec-button-shape-next yt-spec-button-shape-next--filled yt-spec-button-shape-next--mono yt-spec-button-shape-next--size-m']"));
        cookies.click();

        WebElement inputBox = driver.findElement(By.xpath("//input[@placeholder='Search']"));

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));

        wait.until(ExpectedConditions.elementToBeClickable(inputBox));

        inputBox.click();

        inputBox.sendKeys("bailar contigo");
        Thread.sleep(3000);


        driver.findElement(By.id("search-icon-legacy")).click();

        Thread.sleep(3000);
    }
}
