package com.orangehrm.tests;
import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.AdminPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminSearchTest extends BaseTest {

    @Test
    public void searchExistingUser() {

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        // Navigate to Admin
        AdminPage adminPage = new AdminPage(driver);
        adminPage.clickAdminMenu();

        // Search for existing user
        adminPage.searchUser("Admin");

        // Verify search result
        Assert.assertTrue(
                adminPage.isUserDisplayed("Admin"),
                "Admin user was not found!"
        );
    }
}

