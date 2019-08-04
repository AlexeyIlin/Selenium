package com.seleniumTests.tests;

import com.seleniumTests.pageObjects.UsersPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Test_DeleteUser {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    private final static Logger logger = Logger.getLogger(Test_DeleteUser.class);

    public Test_DeleteUser(WebDriver driver, WebDriverWait webDriverWait) {
        this.driver = driver;
        this.webDriverWait = webDriverWait;
    }

    public void deleteUser(String userLogin){

        try {
            UsersPage usersPage = new UsersPage(driver, webDriverWait);

            logger.info("Test Delete user ----------->>>>>>");

            usersPage.searchUser(userLogin);
            logger.info("User found");
            boolean deleteUser = usersPage.deleteUser();
            Assert.assertTrue(deleteUser);
            logger.info("User deleted");
            logger.info("Test Delete user done!");

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
