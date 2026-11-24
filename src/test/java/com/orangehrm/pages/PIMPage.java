
package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PIMPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // PIM menu
    private By pimMenu =
            By.xpath("//a[contains(@href,'/pim/viewPimModule')]");

    // Employee List
    private By employeeListHeader =
            By.xpath("//h5[text()='Employee Information']");

    // Employee search fields
    private By employeeNameField =
            By.xpath("(//input[@placeholder='Type for hints...'])[1]");

    private By employeeIdField =
            By.xpath("//label[text()='Employee Id']/following::input[1]");

    private By searchButton =
            By.xpath("//button[@type='submit']");

    // Search results
    private By employeeRows =
            By.xpath("//div[@class='oxd-table-body']//div[@role='row']");

    // No records message
    private By noRecordsMessage =
            By.xpath("//span[text()='No Records Found']");

    // Add Employee
    private By addEmployeeButton =
            By.xpath("//a[text()='Add Employee']");

    private By addEmployeeHeader =
            By.xpath("//h6[text()='Add Employee']");


    // Constructor
    public PIMPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    // Open PIM module
    public void openPIM() {
        wait.until(
                ExpectedConditions.elementToBeClickable(pimMenu)
        ).click();
    }


    // Check Employee List page
    public boolean isEmployeeListDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        employeeListHeader
                )
        ).isDisplayed();
    }


    // Search employee by name
    public void searchEmployeeByName(String employeeName) {

        WebElement nameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        employeeNameField
                )
        );

        nameField.clear();
        nameField.sendKeys(employeeName);

        // Wait for autocomplete suggestion
        By suggestion = By.xpath("//div[@role='option']");

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(suggestion)
        ).click();

        // Click Search
        wait.until(
                ExpectedConditions.elementToBeClickable(searchButton)
        ).click();
    }


    // Search employee by ID
    public void searchEmployeeById(String employeeId) {

        WebElement idField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        employeeIdField
                )
        );

        idField.clear();
        idField.sendKeys(employeeId);

        wait.until(
                ExpectedConditions.elementToBeClickable(searchButton)
        ).click();
    }


    // Get number of employee rows
    public int getEmployeeRowsCount() {

        wait.until(
                ExpectedConditions.or(
                        ExpectedConditions.visibilityOfElementLocated(employeeRows),
                        ExpectedConditions.visibilityOfElementLocated(noRecordsMessage)
                )
        );

        return driver.findElements(employeeRows).size();
    }


    // Open Add Employee page
    public void openAddEmployeePage() {

        wait.until(
                ExpectedConditions.elementToBeClickable(addEmployeeButton)
        ).click();
    }


    // Check Add Employee page
    public boolean isAddEmployeePageDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        addEmployeeHeader
                )
        ).isDisplayed();
    }
}

