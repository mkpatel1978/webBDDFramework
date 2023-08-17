package org.hrm.stepDefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BaseClass {
    public WebDriver driver;
    public String URL;

//    public WebDriverWait wait;

    public void setupApplication() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));// An implicit wait is to tell WebDriver to poll

//        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        URL = "https://opensource-demo.orangehrmlive.com/";
    }

    public void closeApplication() {
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        if (driver != null) {
//            driver.close();
            driver.quit();
        }
    }

//    public WebDriver getDriver(){
//         return driver;
//    }

}
