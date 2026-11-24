

package com.orangehrm.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initializeDriver() {

        System.out.println("STEP 1: Starting Chrome initialization");

        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\HP\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe"
        );

        ChromeOptions options = new ChromeOptions();

        options.setBinary(
                "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"
        );

        options.addArguments("--start-maximized");

        System.out.println("STEP 2: Creating ChromeDriver");

        WebDriver webDriver = new ChromeDriver(options);

        System.out.println("STEP 3: ChromeDriver created successfully");

        driver.set(webDriver);

        System.out.println("STEP 4: WebDriver stored successfully");
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}

