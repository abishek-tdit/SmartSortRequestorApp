package com.AndroidTest.O1ReferAndEarnFlow;

import Base.BasePage;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class DLoginPage extends BasePage {

    // Constructor
    public DLoginPage(AndroidDriver driver) {
        super(driver);
    }

    // Locators
    private final By MOBILE =
            By.xpath("(//android.widget.EditText)[1]");

    private final By PASSWORD =
            By.xpath("(//android.widget.EditText)[2]");

    private final By LOGIN =
            AppiumBy.accessibilityId("LOGIN");

    // Login
    public void login(String mobileNo, String passwordText) {

        sendKeys(MOBILE, mobileNo);

        ExtentTestListener.logStep("Mobile Number Entered");

        sendKeys(PASSWORD, passwordText);

        ExtentTestListener.logStep("Password Entered");

        hideKeyboard();

        click(LOGIN);

        ExtentTestListener.logStep("Login Button Clicked");
    }
}