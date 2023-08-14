package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {

    private WebDriver driver;

    private By userName = By.id("userName");
    private By password = By.id("password");
    private By loginBtn = By.id("login");
    private By logoutBtn = By.id("submit");

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
        WebElement checkLogout = driver.findElement(logoutBtn);
        return checkLogout.isDisplayed();
    }

    public void login(String user, String pwd) {
        inputUserName(user);
        inputPassword(pwd);
        clickLogin();
    }

    public void logout() {
        clickLogout();
    }


}
