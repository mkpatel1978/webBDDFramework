package org.hrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class adminPage {
    WebDriver driver;
    By adminLink = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a");
    By verifyAdminSection = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");

    public adminPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAdminSection() {
        WebElement adminPage = driver.findElement(adminLink);
        adminPage.click();
    }

    public String verifyAdminPage() {
        WebElement adminSection = driver.findElement(verifyAdminSection);
        return adminSection.getText();
    }
}
