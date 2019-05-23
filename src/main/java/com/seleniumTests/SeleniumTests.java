package com.seleniumTests;


import com.seleniumTests.tests.Test_LogIn;
import com.seleniumTests.tests.Test_LogOut;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumTests {

    private WebDriver driver;

    @DataProvider(name = "credentials")
    public Object[][] credentials(){
        return new Object[][]{
                    {"admin", "admin"},

        };
    }

    @DataProvider(name = "wrongCredentials")
    public Object[][] wrongCredentials(){
        return new Object[][]{
                {"www", "www"},
        };
    }

    @BeforeTest
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get("http://192.168.0.250/proftrading");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(dataProvider = "credentials")
    public void testLogIn(String login, String password) {
        Test_LogIn test_logIn = new Test_LogIn(driver);
        test_logIn.test_LogInCorrectCredentials(login, password);
    }

    @Test
    public void testLogOut(){
        Test_LogOut test_logOut = new Test_LogOut(driver);
        test_logOut.logOut();
    }

    @Test(dataProvider = "wrongCredentials")
    public void testWrongLogIN(String wrongLogin, String wrongPassword){
        Test_LogIn test_logIn = new Test_LogIn(driver);
        test_logIn.test_LogInWrongCredentials(wrongLogin, wrongPassword);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }


}
