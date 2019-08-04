package com.seleniumTests.pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsersPage {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    public UsersPage(WebDriver driver, WebDriverWait webDriverWait){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.webDriverWait = webDriverWait;
    }

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[3]/div/a/span")
        private WebElement addUser;

    @FindBy(className = "selectArrow")
        private WebElement selectUserGroup;

    @CacheLookup
    @FindBy(id = "select~172911")
        private WebElement groupId;

    @CacheLookup
    @FindBy(id = "login")
        private WebElement userLogin;

    @CacheLookup
    @FindBy(name = "password")
        private WebElement userPassword;

    @CacheLookup
    @FindBy(id = "email")
        private WebElement userEmail;

    @CacheLookup
    @FindBy(id = "firstName")
        private WebElement firstName;

    @CacheLookup
    @FindBy(id = "lastName")
        private WebElement lastName;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div[1]/div/div/div[5]/div[3]/div[1]/div/a")
        private WebElement saveClose;

    @FindBy(xpath = "//*[@id=\"mf_crit_0_User_filter\"]")
        private WebElement searchInputLogin;


    @FindBy(xpath = "/html/body/div[2]/div[2]/div[2]/div[1]/div/div[7]/div/a/span")
        private WebElement mainFilterSearchButton;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[2]/div[2]/div[3]/div[2]/div/table/tbody/tr[1]/td[1]/div/span")
        private WebElement selectUser;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[2]/div[2]/div[3]/div[2]/div/table/tbody/tr[1]/td[15]/div/div/div[2]/span")
        private WebElement selectUsersOperation;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[2]/div[2]/div[3]/div[2]/div/table/tbody/tr[1]/td[15]/div/div/div[3]/a[1]")
        private WebElement deleteUserFull;

    @FindBy(xpath = "/html/body/div[2]/div[6]/div[4]")
        private WebElement userTooltip;

    public void setUserLogin(String userLogin){
        this.userLogin.click();
        this.userLogin.clear();
        this.userLogin.sendKeys(userLogin);
    }

    public void setUserPassword(String userPassword){
        this.userPassword.click();
        this.userPassword.clear();
        this.userPassword.sendKeys(userPassword);
    }

    public void setUserEmail(String userEmail){
        this.userEmail.click();
        this.userEmail.clear();
        this.userEmail.sendKeys(userEmail);
    }

    public void setFirstName(String firstName){
        this.firstName.click();
        this.firstName.clear();
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName){
        this.lastName.click();
        this.lastName.clear();
        this.lastName.sendKeys(lastName);
    }

    public void addUser() throws Exception{
        addUser.click();
        Thread.sleep(5000);
    }

    public boolean createUser() {

        saveClose.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(userTooltip));
        return userTooltip.getText().equals("User is created successfully. User login: testSeleniumUser.");

    }

    public boolean deleteUser() throws Exception{

        this.selectUser.click();
        this.selectUsersOperation.click();
        this.deleteUserFull.click();
        Thread.sleep(500);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(2000);
        //webDriverWait.until(ExpectedConditions.attributeToBe(userTooltip, "tooltip", "Deleting of 1 user(s) is executed successfully."));
        return userTooltip.getText().equals("Deleting of 1 user(s) is executed successfully.");


    }

    public void searchUser(String userLogin) {

        this.searchInputLogin.click();
        this.searchInputLogin.clear();
        this.searchInputLogin.sendKeys(userLogin);
        this.mainFilterSearchButton.click();

    }



}
