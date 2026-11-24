package com.orangehrm.tests;
import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.AdminPage;
import com.orangehrm.pages.AddUserPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminTest extends BaseTest {

    @Test
    public void addNewAdminUser() {

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        // Navigate to Admin
        AdminPage adminPage = new AdminPage(driver);
        adminPage.clickAdminMenu();

        // Click Add
        adminPage.clickAddButton();

        // Fill Add User form
        AddUserPage addUserPage = new AddUserPage(driver);

        addUserPage.selectUserRole("Admin");

        addUserPage.enterEmployeeName("Karen Automation Tester");

        addUserPage.selectEmployeeSuggestion(
                "Karen Automation Tester"
        );

        addUserPage.selectStatus("Enabled");

        addUserPage.enterUsername(
                "KarenAdmin" + System.currentTimeMillis()
        );

        addUserPage.enterPassword("Test@12345");

        addUserPage.enterConfirmPassword("Test@12345");

        // Save
        addUserPage.clickSave();

        // Verify
        Assert.assertTrue(
                addUserPage.isSuccessMessageDisplayed(),
                "User was not created successfully!"
        );
    }
}

