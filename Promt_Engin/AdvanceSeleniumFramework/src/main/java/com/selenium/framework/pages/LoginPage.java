package com.selenium.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//input[@id='username' or @name='username' or contains(@placeholder, 'Email')]")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id='password' or @name='password' or contains(@placeholder, 'Password')]")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='Login' or @type='submit' or @name='Login']|//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@type='checkbox' and (contains(@name, 'remember') or contains(@id, 'remember'))]")
    private WebElement rememberMeCheckbox;

    @FindBy(xpath = "//div[contains(@class,'error') or contains(@class,'alert') or contains(text(),'invalid') or contains(text(),'Incorrect')]")
    private WebElement loginErrorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void openLoginPage(String url) {
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOf(usernameField));
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    public void toggleRememberMe() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(rememberMeCheckbox));
            if (!rememberMeCheckbox.isSelected()) {
                rememberMeCheckbox.click();
            }
        } catch (Exception ignore) {
            // Remember me may not be present for every login page variation.
        }
    }

    public String getLoginErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOf(loginErrorMessage));
            return loginErrorMessage.getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isLoginPageDisplayed() {
        try {
            return usernameField.isDisplayed() && passwordField.isDisplayed() && loginButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void performLogin(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
