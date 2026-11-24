
package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddEmployeePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Employee information fields
    private By firstNameField = By.name("firstName");
    private By middleNameField = By.name("middleName");
    private By lastNameField = By.name("lastName");

    // Employee ID
    private By employeeIdField =
            By.xpath("//label[text()='Employee Id']/following::input[1]");

    // Create Login Details checkbox
    private By createLoginDetailsCheckbox =
            By.xpath("//p[text()='Create Login Details']/following::span[contains(@class,'oxd-switch-input')][1]");

    // Save button
    private By saveButton =
            By.xpath("//button[@type='submit']");

    // Required field validation messages
    private By requiredMessages =
            By.xpath("//span[contains(@class,'oxd-input-field-error-message')]");

    // Success message
    private By successMessage =
            By.xpath("//div[contains(@class,'oxd-toast-content')]");


    // Constructor
    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    // Enter first name
    public void enterFirstName(String firstName) {
        WebElement field = wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstNameField)
        );
        field.clear();
        field.sendKeys(firstName);
    }


    // Enter middle name
    public void enterMiddleName(String middleName) {
        WebElement field = wait.until(
                ExpectedConditions.visibilityOfElementLocated(middleNameField)
        );
        field.clear();
        field.sendKeys(middleName);
    }


    // Enter last name
    public void enterLastName(String lastName) {
        WebElement field = wait.until(
                ExpectedConditions.visibilityOfElementLocated(lastNameField)
        );
        field.clear();
        field.sendKeys(lastName);
    }


    // Enter employee ID
    public void enterEmployeeId(String employeeId) {
        WebElement field = wait.until(
                ExpectedConditions.visibilityOfElementLocated(employeeIdField)
        );
        field.clear();
        field.sendKeys(employeeId);
    }


    // Click Save
    public void clickSave() {
        wait.until(
                ExpectedConditions.elementToBeClickable(saveButton)
        ).click();
    }


    // Add employee
    public void addEmployee(
            String firstName,
            String middleName,
            String lastName) {

        enterFirstName(firstName);
        enterMiddleName(middleName);
        enterLastName(lastName);

        clickSave();
    }


    // Get required validation messages count
    public int getRequiredMessagesCount() {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(requiredMessages)
        );

        return driver.findElements(requiredMessages).size();
    }


    // Check whether success message is displayed
    public boolean isSuccessMessageDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(successMessage)
        ).isDisplayed();
    }

}
