package com.gl.hometask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.testng.Assert.*;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.security.auth.login.FailedLoginException;


public class LoginTest {

    private  static FirefoxDriver driver;
    WebElement loginForm;
    private String numbers="123456789";
    String letters="abcdefg";
    String numChar="Ab12c";
    String username = "abc";
    String userpass = "123";
    String errorURL = "http://seltr-kbp1-1.synapse.com:8080/loginError";
    String testErrorMessage = "Invalid login information";




    @BeforeClass
    public static  void  startUpBrowser(){
        driver = new FirefoxDriver();
    }

    LoginPageLayout testLoginPage = new LoginPageLayout(driver);


    @BeforeMethod
    public static  void  initPage(){
         driver.get("http://127.0.0.1:8080/login?from=%2F");
        return;
}


    @Test
    public void myLoginOnly (){

        testLoginPage.usernameInput("123");
        testLoginPage.submitForm();
        assertTrue(errorURL.equalsIgnoreCase(driver.getCurrentUrl()),testErrorMessage);

    }

    @Test
    public void myPassOnly (){

        testLoginPage.passwordInput("123");
        testLoginPage.submitForm();
        assertTrue(errorURL.equalsIgnoreCase(driver.getCurrentUrl()),testErrorMessage);

    }

    @Test
    public void myInvalidLoginPassword() {

        testLoginPage.usernameInput("test");
        testLoginPage.passwordInput("test");
        testLoginPage.submitForm();
        assertTrue(errorURL.equalsIgnoreCase(driver.getCurrentUrl()),testErrorMessage);

    }

    @Test
    public void myzCorrectLogpass(){

        testLoginPage.usernameInput(username);
        testLoginPage.passwordInput(userpass);
        testLoginPage.submitForm();

        if( driver.findElements(By.xpath(".//*[@id='header']/div[2]/span/a[2]/b")).size() == 0){
            Assert.fail("Failed test. Couldn't login");
        }

        //Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='header']/div[2]/span/a[1]/b")).getText(), usname, "Login name on UI does not match username");
    }



    @AfterClass
    public  static  void sheetDownActivities(){
        driver.quit();
    }

}
