package org.example.stepDefinitions;

//import io.cucumber.java.After;
//import io.cucumber.java.AfterAll;
//import io.cucumber.java.Before;
//import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hrm.pages.adminPage;
import org.hrm.pages.loginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class adminPageStepDef extends BaseClass {

    //    private WebDriver driver;
    private loginPage loginPage;
    private adminPage adminPage;

//    @Before
//    public void setup() {
//        System.out.println("MK:Admin");
//        setupApplication();
//
//        loginPage = new loginPage(driver);
//        adminPage = new adminPage(driver);
//    }

//    @After
//    public void tearDown() {
//        System.out.println("aftermkadmin:" + driver);
//        closeApplication();
//    }

    @Given("Go to the webpage for admin")
    public void go_to_the_webpage_for_admin() {
        setupApplication();
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new loginPage(driver);
        adminPage = new adminPage(driver);
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

    @Then("Ensure Application is closed Admin")
    public void Ensure_Application_is_closed_Admin() {
        closeApplication();
    }

}
