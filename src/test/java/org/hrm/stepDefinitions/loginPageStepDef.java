package org.hrm.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;

import java.time.Duration;

import org.hrm.pages.loginPage;

public class loginPageStepDef {

    private loginPage loginPage = new loginPage(BaseClass.getDriver());

    @Given("Go to the webpage for login")
    public void go_to_the_webpage_for_login() {
        System.out.println("logindriver" + loginPage.getPageTitle());
        BaseClass.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Given("Enter the correct credential")
    public void enter_the_correct_credential() {
        loginPage.inputUserName("Admin");
        loginPage.inputPassword("admin123");
    }

    @Given("Enter the incorrect credential")
    public void enter_the_incorrect_credential() {
        loginPage.inputUserName("Adminmk");
        loginPage.inputPassword("admin123");
    }

    @When("Click on login button")
    public void click_on_login_button() {
        loginPage.clickLogin();
    }

    @Then("I should able to login successfully")
    public void i_should_able_to_login_successfully() {
        Assert.assertEquals(loginPage.checkLogoutBtn(), true);
    }

    @Then("I should able to logout successfully")
    public void i_should_able_to_logout_successfully() {
        if (loginPage.checkLogoutBtn() == true) {
            loginPage.clickLogout();
        } else System.out.println("Element Not Found!!!");
    }

    @Then("I should able to see failure login")
    public void i_should_able_to_see_failure_login() {
        String loginFailed = loginPage.checkLoginFailMessage();
        Assert.assertEquals(loginFailed, "Invalid credentials");
    }

    @Given("Click on Forgot your password link")
    public void click_on_forgot_your_password_link() {
        loginPage.clickForgotPassword();
    }

    @When("Enter username and click on reset password")
    public void enter_username_and_click_on_reset_password() {
        loginPage.inputUserName("mk");
        loginPage.clickLogin();
    }

    @Then("Password reset message should appear")
    public void password_reset_message_should_appear() {
        String resetMsg = loginPage.verifyResetPasswordMsg();
        Assert.assertEquals(resetMsg, "Reset Password link sent successfully");
    }

}
