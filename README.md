
# OrangeHRM Automation Testing Project

## Project Overview
This project automates key functionalities of the OrangeHRM web application using Selenium WebDriver and Java.

## Technologies Used
- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- Allure Reporting
- IntelliJ IDEA

## Application Under Test
https://opensource-demo.orangehrmlive.com/web/index.php/auth/login

## Automated Test Scenarios

### Login
- Verify successful login
- Verify invalid login
- Verify empty login fields

### PIM
- Add a new employee
- Validate employee creation

### Admin
- Add a new system user
- Search for an existing user

## Test Execution
Run the test suite using Maven:

```bash
mvn clean test
```

## Allure Report
Generate and open the Allure report:

```bash
mvn allure:serve
```

## Framework Structure
- Base: WebDriver setup and teardown
- Pages: Page Object Model classes
- Tests: TestNG test classes
- Resources: Test data and configuration

## Test Results
Latest execution:
- Total tests: 10
- Passed: 10
- Failed: 0
- Skipped: 0
