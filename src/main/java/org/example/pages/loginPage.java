package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginPage {

    private WebDriver driver;

    private By userName = By.xpath("//input[@placeholder='Username']");
    private By password = By.xpath("//input[@placeholder='Password']");
    private By loginBtn = By.xpath("//button[@type='submit']");

    private By verifyLogin = By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");
    private By logoutBtn = By.linkText("Logout");

    private By verifyFailLogin = By.cssSelector(".oxd-text.oxd-text--p.oxd-alert-content-text");

    public loginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputUserName(String user) {
        WebElement userNameInput = driver.findElement(userName);
        userNameInput.sendKeys(user);
    }

    public void inputPassword(String pwd) {
        WebElement passwordInput = driver.findElement(password);
        passwordInput.sendKeys(pwd);
    }

    public void clickLogin() {
        WebElement clickLogin = driver.findElement(loginBtn);
        clickLogin.click();
    }

    public void clickLogout() {
        WebElement clickLogout = driver.findElement(logoutBtn);
        clickLogout.click();
    }

    public boolean checkLogoutBtn() {
        WebElement loginverify = driver.findElement(verifyLogin);
        loginverify.click();

        WebElement checkLogout = driver.findElement(logoutBtn);
        return checkLogout.isDisplayed();
    }

    public void login(String user, String pwd) {
        inputUserName(user);
        inputPassword(pwd);
        clickLogin();
    }

    public String checkLoginFailMessage() {
        WebElement verifyLoginMsg = driver.findElement(verifyFailLogin);
        verifyLoginMsg.getText();

        return verifyLoginMsg.getText();
    }
}
