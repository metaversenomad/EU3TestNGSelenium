package com.cybertek.homeworks;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverPracticeWebsite {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void testCase1() {
        System.out.println("Test case #1 \n");

        driver.get("https://practice.cydeo.com/");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[41]/a")).click();

        driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[8]/div/input")).sendKeys("wrong_dob");

        WebElement warningMessage = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[8]/div/small[2]"));
        System.out.println("warningMessage.getText() = " + warningMessage.getText());
        Assert.assertTrue(warningMessage.isDisplayed(),"verify Warning Message");

    }
    @Test
    public void testCase2() {
        System.out.println("Test case #2 \n");

        driver.get("https://practice.cydeo.com/");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[41]/a")).click();

        WebElement SelectProgrammingLanguages1 = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[11]/div/div[1]/label"));
        Assert.assertTrue(SelectProgrammingLanguages1.isDisplayed(),"verify SelectProgrammingLanguages1");
        System.out.println("SelectProgrammingLanguages1.getText() = " + SelectProgrammingLanguages1.getText());

        WebElement SelectProgrammingLanguages2 = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[11]/div/div[2]/label"));
        System.out.println("SelectProgrammingLanguages2.getText() = " + SelectProgrammingLanguages2.getText());
        Assert.assertTrue(SelectProgrammingLanguages2.isDisplayed(),"verify SelectProgrammingLanguages2");

        WebElement SelectProgrammingLanguages3 = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[11]/div/div[3]/label"));
        System.out.println("SelectProgrammingLanguages3.getText() = " + SelectProgrammingLanguages3.getText());
        Assert.assertTrue(SelectProgrammingLanguages3.isDisplayed(),"verify SelectProgrammingLanguages3");

    }
    @Test
    public void testCase3() throws InterruptedException {
        System.out.println("Test case #3 \n");

        driver.get("https://practice.cydeo.com/");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[41]/a")).click();

        driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/input")).sendKeys("X");
        WebElement warningMessage2 = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/small[2]"));
        System.out.println("warningMessage2.getText() = " + warningMessage2.getText());
        Assert.assertTrue(warningMessage2.isDisplayed(),"verify Warning Message");

    }
    @Test
    public void testCase4() throws InterruptedException {
        System.out.println("Test case #4 \n");
        driver.get("https://practice.cydeo.com/");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[41]/a")).click();

        driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[2]/div/input")).sendKeys("x");
        WebElement warningMessage3 = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[2]/div/small[2]"));
        System.out.println("warningMessage3.getText() = " + warningMessage3.getText());
        Assert.assertTrue(warningMessage3.isDisplayed(),"verify Warning Message");
    }
    @Test
    public void testCase5() throws InterruptedException {
        System.out.println("Test case #5 \n");
        driver.get("https://practice.cydeo.com/");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[41]/a")).click();

        Faker faker = new Faker();
        driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/input")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[2]/div/input")).sendKeys(faker.name().lastName());
        driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[3]/div/input")).sendKeys(faker.pokemon().name());
        driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[4]/div/input")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[5]/div/input")).sendKeys(faker.internet().password());
        driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[6]/div/input")).sendKeys("541-323-1342");
        driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[7]/div/div[1]/label/input")).click();
        driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[8]/div/input")).sendKeys("03/03/1999");
        WebElement dropdown = driver.findElement(By.name("department"));
        Select departmentSelect = new Select(dropdown);
        departmentSelect.selectByIndex(1);
        WebElement dropdown2 = driver.findElement(By.name("job_title"));
        Select jobTitleSelect = new Select(dropdown2);
        jobTitleSelect.selectByVisibleText("QA");
        driver.findElement(By.id("inlineCheckbox2")).click();
        driver.findElement(By.id("wooden_spoon")).click();

        Thread.sleep(3000);

        WebElement actualSuccessMessage = driver.findElement(By.cssSelector("#content>div>div>p"));
        System.out.println(actualSuccessMessage.getText());
        String expectedMessage = "You've successfully completed registration!";
        String actualMessage = actualSuccessMessage.getText();
//        Assert.assertTrue(actualSuccessMessage.getText().equals(expectedSuccessMessage),"verify Success Message");

        if (expectedMessage.equals(actualMessage)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
            System.out.println("expectedMessage = " + expectedMessage);
            System.out.println("actualMessage = " + actualMessage);
        }

    }
    @Test
    public void testCase6() throws InterruptedException {
        System.out.println("Test case #6 \n");
        driver.get("https://temp-mail.org/");
        Thread.sleep(2000);
        String email = driver.findElement(By.xpath("//input[@id='mail']")).getText();
        System.out.println(email);
        System.out.println("email = " + email);

        driver.get("https://practice.cydeo.com/");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[44]/a")).click();

        Faker faker = new Faker();
        driver.findElement(By.name("full_name")).sendKeys(faker.name().fullName());
        driver.findElement(By.name("email")).sendKeys(faker.internet().emailAddress());
        Thread.sleep(9000);
        driver.findElement(By.name("wooden_spoon")).click();

        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";
        Assert.assertEquals(driver.findElement(By.className("subheader")).getText(), expectedMessage);

        driver.navigate().to("https://temp-mail.org/");

        /*Sayfa hata verdigi icin devami yok...*/

    }
    @Test
    public void testCase7() throws InterruptedException {
        System.out.println("Test case #7 \n");
        driver.get("https://practice.cydeo.com/");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[19]/a")).click();

        driver.findElement(By.id("file-upload")).sendKeys();
        driver.findElement(By.id("file-submit")).click();
    }

}
