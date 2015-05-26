package com.gl.hometask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.assertEquals;


public class SignUpTest {

    private static FirefoxDriver driver;
    WebElement submitForm;
    String numbers = "123456789";
    String letters = "abcdefg";
    String numChar = "Ab12c";
    String genEmail = "test%s@test.com";
    String genName = "test%s";
    String genPass = "pass%s";

    @BeforeClass
    public static void startUpBrowser() {
        driver = new FirefoxDriver();
    }

    @BeforeMethod
    public static void initPage() {
        driver.get("http://seltr-kbp1-1.synapse.com:8080/signup");
    }

    @AfterClass
    public static void sheetDownActivities() {
        driver.quit();
    }

    @Test
    public void differentPassword() {
        submitForm = driver.findElement(By.id("main-panel-content"));
        submitForm.findElement(By.id("username")).sendKeys("svetaTest");
        submitForm.findElement(By.name("password1")).sendKeys("1234");
        submitForm.findElement(By.name("password2")).sendKeys("2345");
        submitForm.findElement(By.name("email")).sendKeys("sveta@test.com");
        submitForm.findElement(By.id("yui-gen1-button")).click();
        assertEquals(driver.findElement(By.xpath("//*[@id='main-panel-content']/div/div")).getText(), "Password didnt match");

    }

    @Test
    public void submitLoginOnly() {

        submitForm = driver.findElement(By.id("main-panel-content"));

        submitForm.findElement(By.id("username")).sendKeys("abc");
        submitForm.findElement(By.id("yui-gen1-button")).click();
        assertEquals(driver.findElement(By.xpath(".//*[@id='main-panel-content']/div/div")).getText(), "Invalid e-mail address");

    }

    @Test
    public void submitPassOnly() {

        submitForm = driver.findElement(By.id("main-panel-content"));

        submitForm.findElement(By.name("password1")).sendKeys("123");
        submitForm.findElement(By.id("yui-gen1-button")).click();
        assertEquals(driver.findElement(By.xpath(".//*[@id='main-panel-content']/div/div")).getText(), "Invalid e-mail address");

    }

    @Test
    public void submitLogpass() {

        submitForm = driver.findElement(By.id("main-panel-content"));
        submitForm.findElement(By.id("username")).sendKeys("abc");
        submitForm.findElement(By.name("password1")).sendKeys("123");
        submitForm.findElement(By.id("yui-gen1-button")).click();
        assertEquals(driver.findElement(By.xpath(".//*[@id='main-panel-content']/div/div")).getText(), "Invalid e-mail address");

    }

    @Test
    public void submitzAll() {

        submitForm = driver.findElement(By.id("main-panel-content"));

        for (int i = 0; i < 1000; i++) {
            int random = new Random().nextInt(10000);
            genName = String.format(genName, random);
            genPass = String.format(genPass, random);
            genEmail = String.format(genEmail, random);
        }

        submitForm.findElement(By.id("username")).sendKeys(genName);
        submitForm.findElement(By.name("password1")).sendKeys(genPass);
        submitForm.findElement(By.name("password2")).sendKeys(genPass);
        submitForm.findElement(By.name("email")).sendKeys(genEmail);
        submitForm.findElement(By.id("yui-gen1-button")).click();
        assertEquals(driver.findElement(By.xpath(".//*[@id='main-panel-content']/h1")).getText().trim(), "Success");
    }

    @Test
    public void submitz1Numbers() {
        submitForm = driver.findElement(By.id("main-panel-content"));
    //    for (int i = 0; i < 1000; i++) {
            int random = new Random().nextInt(10000);
            genName = String.format(genName, random);
            genEmail = String.format(genEmail, random);
      //  }
        submitForm.findElement(By.id("username")).sendKeys(genName + numbers);
        submitForm.findElement(By.name("password1")).sendKeys(numbers);
        submitForm.findElement(By.name("password2")).sendKeys(numbers);
        submitForm.findElement(By.name("email")).sendKeys(genEmail);
        submitForm.findElement(By.id("yui-gen1-button")).click();
        assertEquals(driver.findElement(By.xpath(".//*[@id='main-panel-content']/h1")).getText(), "Success");
    }


}
