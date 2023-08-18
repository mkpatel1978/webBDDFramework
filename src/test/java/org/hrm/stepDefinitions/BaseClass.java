package org.hrm.stepDefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BaseClass {
    public WebDriver driver;
    public String URL;

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
//    public WebDriverWait wait;

    public WebDriver setupApplication() {
        WebDriverManager.chromedriver().setup();
        tlDriver.set(new ChromeDriver());
//        driver = new ChromeDriver();

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));// An implicit wait is to tell WebDriver to poll

//        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        System.out.println("baseopen" + getDriver());
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        URL = "https://opensource-demo.orangehrmlive.com/";

        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
//    public static WebDriver getDriver() {
        return tlDriver.get();
//        return driver;
    }

}
