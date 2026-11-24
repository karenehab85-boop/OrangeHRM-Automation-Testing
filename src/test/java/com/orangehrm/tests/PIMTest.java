
package com.orangehrm.tests;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.PIMPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PIMTest extends BaseTest {

    // Reusable login method
    public void loginAsAdmin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");
    }

    // Test 4: Search for an existing employee
    @Test
    public void searchExistingEmployeeTest() {

        loginAsAdmin();

        PIMPage pimPage = new PIMPage(driver);

        pimPage.openPIM();

        Assert.assertTrue(
                pimPage.isEmployeeListDisplayed(),
                "Employee list page should be displayed"
        );

        pimPage.searchEmployeeByName("a");

        Assert.assertTrue(
                pimPage.getEmployeeRowsCount() > 0,
                "At least one employee should appear in search results"
        );
    }

    // Test 5: Search for a non-existing employee
    @Test
    public void searchNonExistingEmployeeTest() {

        loginAsAdmin();

        PIMPage pimPage = new PIMPage(driver);

        pimPage.openPIM();

        Assert.assertTrue(pimPage.isEmployeeListDisplayed());

        pimPage.searchEmployeeByName("KarenNonExisting999");

        Assert.assertEquals(
                pimPage.getEmployeeRowsCount(),
                0,
                "No employees should appear for a non-existing name"
        );
    }

    // Test 6: Open Add Employee page
    @Test
    public void openAddEmployeePageTest() {

        loginAsAdmin();

        PIMPage pimPage = new PIMPage(driver);

        pimPage.openPIM();

        pimPage.openAddEmployeePage();

        Assert.assertTrue(
                pimPage.isAddEmployeePageDisplayed(),
                "Add Employee page should be displayed"
        );
    }
}
