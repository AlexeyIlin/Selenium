package com.seleniumTests.tests;

import com.seleniumTests.pageObjects.UsersPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class Test_CreateUser {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    private final static Logger logger = Logger.getLogger(Test_CreateUser.class);


    public Test_CreateUser(WebDriver driver, WebDriverWait webDriverWait){
        this.driver = driver;
        this.webDriverWait = webDriverWait;
    }


    public void createUser(String login, String password, String email, String firstName, String lastName){

    try {
        UsersPage usersPage = new UsersPage(driver, webDriverWait);

        logger.info("Test Create user ----------->>>>>>");
        usersPage.addUser();

        usersPage.setUserLogin(login);
        usersPage.setUserPassword(password);
        usersPage.setFirstName(firstName);
        usersPage.setLastName(lastName);
        usersPage.setUserEmail(email);
        logger.info("Users fields set");

        boolean userCreated = usersPage.createUser();
        Assert.assertTrue(userCreated);
        logger.info("User was created");
        logger.info("Test Create user done!");

    }catch (Exception e) {
        e.printStackTrace();
    }


    }

}
