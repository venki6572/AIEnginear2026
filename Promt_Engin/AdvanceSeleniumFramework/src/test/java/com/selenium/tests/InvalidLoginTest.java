package com.selenium.tests;

import com.selenium.framework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidLoginTest extends BaseTest {
    private static final String LOGIN_URL = "https://login.salesforce.com/?locale=in";

    @Test(description = "Verify that invalid Salesforce login credentials display an error message")
    public void verifyInvalidLoginShowsError() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage(LOGIN_URL);
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page must be displayed before attempting invalid login.");

        loginPage.performLogin("invalid.user@example.com", "InvalidPassword123!");
        String errorMessage = loginPage.getLoginErrorMessage();

        Assert.assertFalse(errorMessage.isBlank(), "An error message must be displayed for invalid login credentials.");
    }
}
