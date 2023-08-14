package org.example.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.example.pages.loginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class loginPageStepDef {

    private WebDriver driver;
    private loginPage loginPage;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));// An implicit wait is to tell WebDriver to poll
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }


    @Given("Go to the webpage")
    public void go_to_the_webpage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new loginPage(driver);
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

}
