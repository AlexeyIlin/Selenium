package com.seleniumTests.tests;

import com.seleniumTests.pageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class Test_LogIn {

    private WebDriver driver;
    private String result;



    public Test_LogIn(WebDriver driver) {
        this.driver = driver;
    }

    public void test_LogInCorrectCredentials(String login, String password){

            HomePage homePage = new HomePage(driver);
            homePage.setLogin(login);
            homePage.setPassword(password);
            result = homePage.submit();

        Assert.assertEquals(result, "Users");
    }

    public void test_LogInWrongCredentials(String login, String password){

        HomePage homePage = new HomePage(driver);
        homePage.setLogin(login);
        homePage.setPassword(password);
        result = homePage.invalidSubmit();

        Assert.assertEquals(result, "Invalid login and/or password.");
    }

}
