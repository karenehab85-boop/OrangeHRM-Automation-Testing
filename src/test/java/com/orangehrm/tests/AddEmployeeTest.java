
package com.orangehrm.tests;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.PIMPage;
import com.orangehrm.pages.AddEmployeePage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddEmployeeTest extends BaseTest {

    // Reusable login method
    public void loginAsAdmin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");
    }

    // Open Add Employee page
    public AddEmployeePage navigateToAddEmployeePage() {

        PIMPage pimPage = new PIMPage(driver);

        pimPage.openPIM();
        pimPage.openAddEmployeePage();

        return new AddEmployeePage(driver);
    }

    // Test 7: Validate required fields
    @Test
    public void emptyEmployeeFormValidationTest() {

        loginAsAdmin();

        AddEmployeePage addEmployeePage =
                navigateToAddEmployeePage();

        addEmployeePage.clickSave();

        Assert.assertEquals(
                addEmployeePage.getRequiredMessagesCount(),
                2,
                "First name and last name should be required"
        );
    }

    // Test 8: Add a new employee successfully
    @Test
    public void addNewEmployeeTest() {

        loginAsAdmin();

        AddEmployeePage addEmployeePage =
                navigateToAddEmployeePage();

        addEmployeePage.addEmployee(
                "Karen",
                "Automation",
                "Tester"
        );

        Assert.assertTrue(
                addEmployeePage.isSuccessMessageDisplayed(),
                "Employee should be added successfully"
        );
    }
}

