package com.seleniumTests.tests;

import com.seleniumTests.pageObjects.HomePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Test_LogOut {

    private WebDriver driver;
    private final static Logger logger = Logger.getLogger(Test_LogOut.class);

    public Test_LogOut(WebDriver driver) {
        this.driver = driver;
    }

    public void logOut(){

        logger.info("Test Logout ----------->>>>>>");

        boolean result;
        HomePage homePage = new HomePage(driver);
        result = homePage.logOut();
        Assert.assertTrue(result);
        logger.info("Test Logout done");
    }

}
