package org.hrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginPage {

    WebDriver driver;
    WebDriverWait wait;

    By userName = By.xpath("//input[@placeholder='Username']");
    By password = By.xpath("//input[@placeholder='Password']");
    By loginBtn = By.xpath("//button[@type='submit']");
    By verifyLogin = By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");
    By logoutBtn = By.linkText("Logout");
    By verifyFailLogin = By.cssSelector(".oxd-text.oxd-text--p.oxd-alert-content-text");
    By forgotPasswordLink = By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']");
    By resetPwdMsg = By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-forgot-password-title']");

    public loginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void inputUserName(String user) {
        wait.until(ExpectedConditions.presenceOfElementLocated(userName));
        WebElement userNameInput = driver.findElement(userName);

        userNameInput.clear();
        userNameInput.sendKeys(user);
    }

    public void inputPassword(String pwd) {
        wait.until(ExpectedConditions.presenceOfElementLocated(password));
        WebElement passwordInput = driver.findElement(password);

        passwordInput.clear();
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
        wait.until(ExpectedConditions.presenceOfElementLocated(verifyLogin));
        WebElement loginverify = driver.findElement(verifyLogin);

        loginverify.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(logoutBtn));
        WebElement checkLogout = driver.findElement(logoutBtn);

        return checkLogout.isDisplayed();
    }

    public void login(String user, String pwd) {
        inputUserName(user);
        inputPassword(pwd);
        clickLogin();
    }

    public String checkLoginFailMessage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(verifyFailLogin));
        WebElement verifyLoginMsg = driver.findElement(verifyFailLogin);

        return verifyLoginMsg.getText();
    }

    public void clickForgotPassword() {
        wait.until(ExpectedConditions.presenceOfElementLocated(forgotPasswordLink));
        WebElement forgotPwdLink = driver.findElement(forgotPasswordLink);

        forgotPwdLink.click();
    }

    public String verifyResetPasswordMsg() {
        wait.until(ExpectedConditions.presenceOfElementLocated(resetPwdMsg));
        WebElement resetMsg = driver.findElement(resetPwdMsg);

        return resetMsg.getText();
    }
}
