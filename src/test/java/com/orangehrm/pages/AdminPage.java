
package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By adminMenu = By.xpath("//span[text()='Admin']");

    private By addButton = By.xpath(
            "//button[normalize-space()='Add']"
    );

    private By usernameSearch = By.xpath(
            "(//label[text()='Username']/../following-sibling::div//input)"
    );

    private By searchButton = By.xpath(
            "//button[@type='submit']"
    );

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickAdminMenu() {
        wait.until(
                ExpectedConditions.elementToBeClickable(adminMenu)
        ).click();
    }

    public void clickAddButton() {
        wait.until(
                ExpectedConditions.elementToBeClickable(addButton)
        ).click();
    }

    public void searchUser(String username) {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(usernameSearch)
        ).sendKeys(username);

        wait.until(
                ExpectedConditions.elementToBeClickable(searchButton)
        ).click();
    }

    public boolean isUserDisplayed(String username) {

        By userRow = By.xpath(
                "//div[@class='oxd-table-body']//div[@role='row']" +
                        "[contains(.,'" + username + "')]"
        );

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(userRow)
        ).isDisplayed();
    }

}
