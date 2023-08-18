package hrmHooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.hrm.stepDefinitions.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.hrm.pages.*;

import java.time.Duration;

public class hook {

    private BaseClass base;
    private WebDriver driver;

    @Before
    public void setup(Scenario scenario) {
        System.out.println("hookstart");
        System.out.println(scenario.getName() + " : " + scenario.getStatus());

        base = new BaseClass();
        driver = base.setupApplication();
    }

    @After
    public void tearDown() {
        System.out.println("hookstop");
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

}

