package com.seleniumTests.tests;

import com.seleniumTests.pageObjects.HomePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Test_LogIn {

    private WebDriver driver;
    private Boolean logged;

    private final static Logger logger = Logger.getLogger(Test_LogIn.class);

    public Test_LogIn(WebDriver driver) {
        this.driver = driver;
    }

    public void test_LogInCorrectCredentials(String login, String password){

        logger.info("Test Login ----------->>>>>>");

        HomePage homePage = new HomePage(driver);
        homePage.setLogin(login);
        homePage.setPassword(password);
        logged = homePage.submit();

       Assert.assertTrue(logged);
       logger.info("Logged in");
       logger.info("Test Login done!");
    }

    public void test_LogInWrongCredentials(String login, String password){

        logger.info("Test Wrong Login ----------->>>>>>");

        HomePage homePage = new HomePage(driver);
        homePage.setLogin(login);
        homePage.setPassword(password);
        logged = homePage.invalidSubmit();
        Assert.assertTrue(logged);
        logger.info("Test Wrong Login done!");

    }

}
