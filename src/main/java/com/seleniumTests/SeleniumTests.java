package com.seleniumTests;


import com.seleniumTests.tests.Test_CreateUser;
import com.seleniumTests.tests.Test_DeleteUser;
import com.seleniumTests.tests.Test_LogIn;
import com.seleniumTests.tests.Test_LogOut;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumTests {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

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

    @DataProvider(name = "userDetails")
    public Object[][] userDetails(){
        return new Object[][]{
                {"testSeleniumUser", "pass", "-", "Name", "LastName"},
        };
    }

    @BeforeTest
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver, 10);
        driver.get("http://192.168.0.250/proftrading");

    }

    @Test(dataProvider = "credentials")
    public void testLogIn(String login, String password) {
        Test_LogIn test_logIn = new Test_LogIn(driver);
        test_logIn.test_LogInCorrectCredentials(login, password);

    }

    @Test(dataProvider = "userDetails", dependsOnMethods = {"testLogIn"})
    public void testCreateUser(String login, String pass, String email, String name, String lastName) {

        Test_CreateUser test_createUser = new Test_CreateUser(driver, webDriverWait);
        test_createUser.createUser(login, pass, email, name, lastName);

    }

    @Test(dataProvider = "userDetails", dependsOnMethods = {"testCreateUser"})
    public void testDeleteUser(String login, String pass, String email, String name, String lastName){

        Test_DeleteUser test_deleteUser = new Test_DeleteUser(driver, webDriverWait);
        test_deleteUser.deleteUser(login);

    }

    @Test(dependsOnMethods = {"testDeleteUser"})
    public void testLogOut(){
        Test_LogOut test_logOut = new Test_LogOut(driver);
        test_logOut.logOut();
    }

    @Test(dataProvider = "wrongCredentials", dependsOnMethods = {"testLogOut"})
    public void testWrongLogIN(String wrongLogin, String wrongPassword){
        Test_LogIn test_logIn = new Test_LogIn(driver);
        test_logIn.test_LogInWrongCredentials(wrongLogin, wrongPassword);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }


}
