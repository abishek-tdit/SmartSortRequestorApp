package com.AndroidTest.O3VerifyReferralPointsFlow;

import Base.BasePage;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ARequestorLoginPage extends BasePage {

    public ARequestorLoginPage(AndroidDriver driver) {
        super(driver);
    }

    //=========================================================
    // Logout Locators
    //=========================================================

    private final By profileIcon = AppiumBy.xpath(
            "//android.widget.FrameLayout[@resource-id='android:id/content']" +
                    "/android.widget.FrameLayout/android.widget.FrameLayout" +
                    "/android.view.View/android.view.View/android.view.View" +
                    "/android.view.View/android.view.View[1]" +
                    "/android.view.View/android.widget.ImageView[1]"
    );

    private final By logoutButton =
            AppiumBy.accessibilityId("log out");

    private final By yesButton =
            AppiumBy.accessibilityId("Yes");

    //=========================================================
    // Login Locators
    //=========================================================

    private final By MOBILE =
            By.xpath("(//android.widget.EditText)[1]");

    private final By PASSWORD =
            By.xpath("(//android.widget.EditText)[2]");

    private final By LOGIN =
            AppiumBy.accessibilityId("LOGIN");

    //=========================================================
    // Logout + Login
    //=========================================================

    public void logoutAndLogin(String mobileNo, String passwordText) {

        // Click Profile Icon
        wait.until(ExpectedConditions.elementToBeClickable(profileIcon)).click();
        ExtentTestListener.logStep("Profile Icon Clicked");

        // Click Logout
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
        ExtentTestListener.logStep("Logout Clicked");

        // Click Yes Popup
        wait.until(ExpectedConditions.elementToBeClickable(yesButton)).click();
        ExtentTestListener.logStep("Yes Popup Clicked");

        ExtentTestListener.getTest().pass("Logout Completed Successfully");

        //=========================================================
        // Login
        //=========================================================
        sendKeys(MOBILE, mobileNo);
        ExtentTestListener.logStep("Mobile Number Entered");

        sendKeys(PASSWORD, passwordText);
        ExtentTestListener.logStep("Password Entered");

        hideKeyboard();

        click(LOGIN);
        ExtentTestListener.logStep("Login Button Clicked");

        ExtentTestListener.getTest().pass("Login Completed Successfully");
    }
}