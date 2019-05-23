package com.seleniumTests.tests;

import com.seleniumTests.pageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Test_LogOut {

    private WebDriver driver;

    public Test_LogOut(WebDriver driver) {
        this.driver = driver;
    }

    public void logOut(){

        boolean result;
        HomePage homePage = new HomePage(driver);
        result = homePage.logOut();
        Assert.assertTrue(result);
    }

}
