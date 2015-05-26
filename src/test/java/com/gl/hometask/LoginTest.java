package com.gl.hometask;

import org.openqa.selenium.By;
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


/*    By usernameLocator = By.xpath("//*[@id='j_username']");
    By passwordLocator = By.xpath("//*[@name='j_password']");
    By submitLocator = By.id("yui-gen1-button");

*/  @BeforeClass
    public static  void  startUpBrowser(){
        driver = new FirefoxDriver();
    }

    @BeforeMethod
    public static  void  initPage(){
         driver.get("http://seltr-kbp1-1.synapse.com:8080/login?from=%2F");
}


    @Test
    public void myInputLogin (){

        loginForm = driver.findElement(By.name("login"));

        loginForm.findElement(By.name("j_username")).sendKeys("123");
        //findLoginForm.
        loginForm.submit();
        assertTrue(driver.getCurrentUrl().equalsIgnoreCase("http://seltr-kbp1-1.synapse.com:8080/loginError"), "Invalid login information");

    }

    @Test
    public void myInputPass (){

        loginForm = driver.findElement(By.name("login"));

        loginForm.findElement(By.name("j_password")).sendKeys("123");
        //findLoginForm.
        loginForm.submit();
        assertTrue("http://seltr-kbp1-1.synapse.com:8080/loginError".equalsIgnoreCase(driver.getCurrentUrl()),"Invalid login information");

    }

    @Test
    public void myWrongLogpass () {

        loginForm = driver.findElement(By.name("login"));
        loginForm.findElement(By.name("j_username")).sendKeys("test");
        loginForm.findElement(By.name("j_password")).sendKeys("test");
        loginForm.submit();
        assertTrue(driver.getCurrentUrl().equalsIgnoreCase("http://seltr-kbp1-1.synapse.com:8080/loginError"), "Invalid login information");
    }

    @Test
    public void myzCorrectLogpass (){

        loginForm = driver.findElement(By.name("login"));
        loginForm.findElement(By.name("j_username")).sendKeys(username);
        loginForm.findElement(By.name("j_password")).sendKeys(userpass);
        loginForm.submit();

   /*     try {
            driver.findElement(By.xpath("./*//*[@id='header']/div[2]/span/a[2]/b")).getText().equalsIgnoreCase("log out");
        }
        catch (Exception ex) {

        }*/

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
