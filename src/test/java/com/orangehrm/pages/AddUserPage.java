package com.orangehrm.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddUserPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By userRole = By.xpath(
            "//label[text()='User Role']/../following-sibling::div"
    );

    private By employeeName = By.xpath(
            "//input[@placeholder='Type for hints...']"
    );

    private By status = By.xpath(
            "//label[text()='Status']/../following-sibling::div"
    );

    private By username = By.xpath(
            "//label[text()='Username']/../following-sibling::div//input"
    );

    private By password = By.xpath(
            "//label[text()='Password']/../following-sibling::div//input"
    );

    private By confirmPassword = By.xpath(
            "//label[text()='Confirm Password']/../following-sibling::div//input"
    );

    private By saveButton = By.xpath(
            "//button[@type='submit']"
    );

    public AddUserPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectUserRole(String role) {
        wait.until(ExpectedConditions.elementToBeClickable(userRole)).click();

        By option = By.xpath(
                "//div[@role='option']//span[normalize-space()='" + role + "']"
        );

        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
    }

    public void enterEmployeeName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(employeeName))
                .sendKeys(name);
    }

    public void selectEmployeeSuggestion(String name) {
        By suggestion = By.xpath(
                "//div[@role='option']//span[contains(text(),'" + name + "')]"
        );

        wait.until(ExpectedConditions.elementToBeClickable(suggestion)).click();
    }

    public void selectStatus(String statusValue) {
        wait.until(ExpectedConditions.elementToBeClickable(status)).click();

        By option = By.xpath(
                "//div[@role='option']//span[normalize-space()='" + statusValue + "']"
        );

        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
    }

    public void enterUsername(String user) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username))
                .sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void enterConfirmPassword(String pass) {
        driver.findElement(confirmPassword).sendKeys(pass);
    }

    public void clickSave() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }
    public boolean isSuccessMessageDisplayed() {
        By successMessage = By.xpath(
                "//div[contains(@class,'oxd-toast-content')]"
        );

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(successMessage)
        ).isDisplayed();
    }

    public String getUsername() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(username)
        ).getAttribute("value");
    }

}

