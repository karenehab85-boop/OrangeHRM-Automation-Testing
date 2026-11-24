
package com.orangehrm.tests;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.LoginPage;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureTestNg.class)
public class LoginTest extends BaseTest {

    @Test(priority = 1, description = "Verify successful login")
    public void verifySuccessfulLogin() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("dashboard"),
                "Dashboard was not displayed"
        );
    }

    @Test(priority = 2, description = "Verify invalid login")
    public void verifyInvalidLogin() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("InvalidUser");
        loginPage.enterPassword("WrongPassword");
        loginPage.clickLogin();

        Assert.assertTrue(
                loginPage.getErrorMessage().contains("Invalid credentials"),
                "Invalid credentials message was not displayed"
        );
    }

    @Test(priority = 3, description = "Verify empty login")
    public void verifyEmptyLogin() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickLogin();

        Assert.assertEquals(
                loginPage.getRequiredMessagesCount(),
                2,
                "Required field validation was not displayed"
        );
    }
}
