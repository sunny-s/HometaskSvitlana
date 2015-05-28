package com.gl.hometask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by svitlana.masanovets on 5/27/2015.
 */
public class LoginPageLayout {

    private WebDriver driver;

    public LoginPageLayout(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPageLayout getPage() {
        driver.get("http://127.0.0.1:8080");
        return this;
    }

    By username = By.id("j_username");
    By password = By.xpath("//*[@name='j_password']");
    By submit = By.id("yui-gen1-button");


 /*   @FindBy(xpath="//*[@name='j_password']")
    private  WebElement password;

    @FindBy(id="yui-gen1-button")
    private WebElement submit;

*/

    public LoginPageLayout usernameInput(String name) {
        driver.findElement(username).sendKeys(name);
        return this;
    }

    public LoginPageLayout passwordInput(String pass) {
        driver.findElement(password).sendKeys(pass);
        return this;
    }

    public void submitForm(){
        driver.findElement(submit).click();
        return;
    }


}
