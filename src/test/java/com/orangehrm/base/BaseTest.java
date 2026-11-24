
package com.orangehrm.base;

import com.orangehrm.driver.DriverManager;
import com.orangehrm.utils.ConfigReader;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        ConfigReader.loadProperties();

        DriverManager.initializeDriver();

        driver = DriverManager.getDriver();

        driver.get(ConfigReader.getProperty("base.url"));
    }

    @AfterMethod
    public void tearDown() {

        DriverManager.quitDriver();
    }
}
