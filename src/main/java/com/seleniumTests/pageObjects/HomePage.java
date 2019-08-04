package com.seleniumTests.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {


    private WebDriver driver;

    @FindBy(id = "login")
            private WebElement login;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "submit")
    private WebElement submit;

    @FindBy(id = "pageTitle")
    private WebElement pageTitle;

    @FindBy(className = "nottext")
    private WebElement nottext;

    @FindBy(className = "logOut")
    private WebElement logOut;

    @FindBy(className = "btnIcon")
    private WebElement btnIcon;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public void setLogin(String login){

        this.login.sendKeys(login);
    }

    public void setPassword(String password){

        this.password.sendKeys(password);
    }

    public Boolean submit(){

        submit.click();
        return pageTitle.getText().equals("Users");

    }

    public boolean invalidSubmit(){
        submit.click();
        return nottext.getText().equals("Invalid login and/or password.");
    }

    public boolean logOut(){
        logOut.click();
        return btnIcon.isDisplayed();
    }
}
