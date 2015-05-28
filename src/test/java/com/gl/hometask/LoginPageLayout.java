package com.gl.hometask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by svitlana.masanovets on 5/27/2015.
 */
public class LoginPageLayout {

    private WebDriver driver;

    public LoginPageLayout(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

   /* public LoginPageLayout getPage() {
        driver.get("http://127.0.0.1:8080");
        return this;
    }
*/
/*    By username = By.id("j_username");
    By password = By.xpath("//*[@name='j_password']");
    By submit = By.id("yui-gen1-button");
*/
   @FindBy(xpath = "//*[@id='j_username']")
    private WebElement username;

    @FindBy(xpath="//*[@name='j_password']")
    private  WebElement password;

    @FindBy(id="yui-gen1-button")
    private WebElement submit;

    public LoginPageLayout usernameInput(String name) {
        username.sendKeys(name);
        return this;
    }

    public LoginPageLayout passwordInput(String pass) {
        password.sendKeys(pass);
        return this;
    }

    public void submitForm(){
        submit.click();
        return;
    }


}
