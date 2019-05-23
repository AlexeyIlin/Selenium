package com.seleniumTests.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersPage {

    private WebDriver driver;


    @FindBy(className = "addBtn fluentButtons")
        private WebElement addUser;

    @FindBy(className = "selectArrow")
        private WebElement selectUserGroup;

    @FindBy(id = "select~172911")
        private WebElement groupId;

    @FindBy(id = "login")
        private WebElement userLogin;

    @FindBy(id = "password_newEditUser1")
        private WebElement userPassword;

    @FindBy(id = "email")
        private WebElement userEmail;

    @FindBy(id = "firstName")
        private WebElement firstName;

    @FindBy(id = "lastName")
        private WebElement lastName;

    @FindBy(className = "pocSave")
        private WebElement saveClose;

    @FindBy(id = "mf_crit_0_User_filter")
        private WebElement searchInputLogin;


    @FindBy(id = "mainFilterSearchBtn")
        private WebElement mainFilterSearchButton;

    @FindBy(className = "massCbxCol")
        private WebElement selectUser;

    @FindBy(className = "csListSelected")
        private WebElement selectUsersOperation;

    @FindBy(className = "csListItem")
        private WebElement deleteUserFull;

}
