package com.karansharma.tests;

import com.karansharma.base.BaseDriver;
import com.karansharma.pages.DashboardPage;
import com.karansharma.pages.LoginPage;
import com.karansharma.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseDriver {

    @Test(description = "Valid credentials should redirect to Products dashboard")
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );
        DashboardPage dashboard = new DashboardPage(driver);
        Assert.assertEquals(dashboard.getPageTitle(), "Products",
                "Page title should be Products after valid login");
    }

    @Test(description = "Invalid credentials should display error message")
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("invalid_user", "wrong_pass");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
                "Error message should be displayed for invalid credentials");
        Assert.assertTrue(
                loginPage.getErrorMessage().contains("Username and password do not match"),
                "Error text should mention username and password mismatch"
        );
    }

    @Test(description = "Empty credentials should display error message")
    public void testEmptyCredentialsLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
                "Error message should display for empty credentials");
        Assert.assertTrue(
                loginPage.getErrorMessage().contains("Epic sadface: Username is required"),
                "Error should mention username is required"
        );
    }
}