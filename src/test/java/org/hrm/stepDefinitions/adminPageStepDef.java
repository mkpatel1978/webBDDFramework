package org.hrm.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;

import java.time.Duration;

import org.hrm.pages.adminPage;
import org.hrm.pages.loginPage;

public class adminPageStepDef {

    private loginPage loginPage = new loginPage(BaseClass.getDriver());
    private adminPage adminPage = new adminPage(BaseClass.getDriver());

    @Given("Go to the webpage for admin")
    public void go_to_the_webpage_for_admin() {
        System.out.println("Admindriver" + loginPage.getPageTitle());
        BaseClass.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Given("Login to website")
    public void Login_to_website() {
        loginPage.inputUserName("Admin");
        loginPage.inputPassword("admin123");

        loginPage.clickLogin();
    }

    @When("Click on Admin section")
    public void click_on_admin_section() {
        adminPage.clickAdminSection();
    }

    @Then("I should able to browse Admin section")
    public void i_should_able_to_browse_admin_section() {
        String verifyAdminPage = adminPage.verifyAdminPage();
        Assert.assertEquals(verifyAdminPage, "Admin");
    }

    @Then("I should able to logout successfully from adminpage")
    public void i_should_able_to_logout_successfully_from_adminpage() {
        if (loginPage.checkLogoutBtn() == true) {
            loginPage.clickLogout();
        } else System.out.println("Element Not Found!!!");
    }

}
