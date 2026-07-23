package com.AndroidTest.HSmartBotChatFlow;

import Base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ALoginPage extends BasePage {

    //=========================================================
    // Constructor
    //=========================================================

    public ALoginPage(AndroidDriver driver) {

        super(driver);
    }

    //=========================================================
    // Locators
    //=========================================================

    private final By loginHomeButton =
            AppiumBy.accessibilityId("Log in");

    private final By mobileNumber =
            By.xpath("(//android.widget.EditText)[1]");

    private final By password =
            By.xpath("(//android.widget.EditText)[2]");

    private final By loginButton =
            AppiumBy.accessibilityId("LOGIN");

    //=========================================================
    // Login Method
    //=========================================================

    public void login(String mobileNo, String passwordText) {

        log("========== LOGIN STARTED ==========");

        // Click Login
        click(loginHomeButton);
        log("Clicked Log In button");

        // Mobile Number
        sendKeys(mobileNumber, mobileNo);
        log("Entered Mobile Number : " + mobileNo);

        // Password
        sendKeys(password, passwordText);
        log("Entered Password");

        // Hide Keyboard
        hideKeyboard();

        // Click Login
        click(loginButton);
        log("Clicked LOGIN button");

        // Wait for Home Page
        delay(5);

        log("Login Successful");
    }

}