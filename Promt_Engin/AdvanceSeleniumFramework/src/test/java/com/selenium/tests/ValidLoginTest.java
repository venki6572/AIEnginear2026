package com.selenium.tests;

import com.selenium.framework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidLoginTest extends BaseTest {
    private static final String LOGIN_URL = "https://login.salesforce.com/?locale=in";

    @Test(description = "Verify that valid Salesforce login credentials navigate away from the login page")
    public void verifyValidLogin() {
        String validUsername = System.getProperty("valid.username", "");
        String validPassword = System.getProperty("valid.password", "");

        Assert.assertFalse(validUsername.isBlank(), "Valid username must be provided using -Dvalid.username");
        Assert.assertFalse(validPassword.isBlank(), "Valid password must be provided using -Dvalid.password");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage(LOGIN_URL);
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page must be displayed before attempting valid login.");

        loginPage.performLogin(validUsername, validPassword);
        Assert.assertNotEquals(driver.getCurrentUrl(), LOGIN_URL, "Successful login should redirect away from the login page.");
    }
}
