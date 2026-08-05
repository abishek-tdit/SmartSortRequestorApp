package com.AndroidTest.IProfileViewBasicFeaturesFlow;

import Base.BasePage;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DProfileUserDetailsPage extends BasePage {

    //=========================================================
    // Constructor
    //=========================================================

    public DProfileUserDetailsPage(AndroidDriver driver) {
        super(driver);
    }

    //=========================================================
    // Locators
    //=========================================================

    private final By profileIcon = AppiumBy.xpath(
            "//android.widget.FrameLayout[@resource-id='android:id/content']" +
                    "/android.widget.FrameLayout/android.widget.FrameLayout" +
                    "/android.view.View/android.view.View/android.view.View" +
                    "/android.view.View/android.view.View[1]" +
                    "/android.view.View/android.widget.ImageView[1]"
    );

    private final By viewProfile =
            AppiumBy.accessibilityId("View Profile");

    private final By userNameEditIcon =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().className(\"android.view.View\").instance(8)");

    private final By editText =
            AppiumBy.className("android.widget.EditText");

    private final By updateButton =
            AppiumBy.accessibilityId("Update");

    private final By emailEditIcon =
            AppiumBy.xpath("//android.widget.ScrollView/android.view.View[7]");

    private final By sendOtpButton =
            AppiumBy.accessibilityId("Send OTP");

    private final By okButton =
            AppiumBy.accessibilityId("OK");

    private final By verifyOtpButton =
            AppiumBy.accessibilityId("Verify OTP");

    //=========================================================
    // Update User Details
    //=========================================================

    public void updateUserDetails() throws Exception {

        // Profile
        wait.until(ExpectedConditions.elementToBeClickable(profileIcon)).click();
        ExtentTestListener.logStep("Profile Icon Clicked");

        // View Profile
        wait.until(ExpectedConditions.elementToBeClickable(viewProfile)).click();
        ExtentTestListener.logStep("View Profile Clicked");

        // Username Edit
        WebElement editIcon = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath(
                                "//android.view.View[@bounds='[588,453][620,485]']")
                )
        );

        editIcon.click();
        ExtentTestListener.logStep("Username Edit Icon Clicked");

        List<WebElement> fields =
                wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(editText, 1));

        ExtentTestListener.logStep("Total Fields : " + fields.size());

        // First Name
        fields.getFirst().clear();
        fields.get(0).sendKeys("Abiram");
        ExtentTestListener.logStep("First Name Updated");

        // Last Name
        fields.get(1).clear();
        fields.get(1).sendKeys("abi");
        ExtentTestListener.logStep("Last Name Updated");

        // Update
        wait.until(ExpectedConditions.elementToBeClickable(updateButton)).click();
        ExtentTestListener.logStep("Update Button Clicked");

        // Email Edit
        wait.until(ExpectedConditions.elementToBeClickable(emailEditIcon)).click();

        ExtentTestListener.logStep("Email Edit Icon Clicked");


        // Wait for email input field
        WebElement emailField = wait.until(
                ExpectedConditions.elementToBeClickable(editText)
        );

        emailField.click();
        emailField.clear();
        emailField.sendKeys("abishek251295@gmail.com");

        ExtentTestListener.logStep("Email Updated");


        // Send OTP
        wait.until(
                ExpectedConditions.elementToBeClickable(sendOtpButton)
        ).click();

        ExtentTestListener.logStep("Send OTP Clicked");


        // OTP Sent Popup OK
        wait.until(
                ExpectedConditions.elementToBeClickable(okButton)
        ).click();

        ExtentTestListener.logStep("OTP Sent Popup OK Clicked");


        // Manual OTP Entry
        ExtentTestListener.logStep("Please enter OTP manually...");
        Thread.sleep(15000);

        // Verify OTP
        wait.until(ExpectedConditions.elementToBeClickable(verifyOtpButton)).click();
        ExtentTestListener.logStep("Verify OTP Clicked");

        // Success Popup
        wait.until(ExpectedConditions.elementToBeClickable(okButton)).click();
        ExtentTestListener.logStep("Success Popup OK Clicked");

        ExtentTestListener.logStep("User Details Updated Successfully");

        if (ExtentTestListener.getTest() != null) {
            ExtentTestListener.getTest().pass("User Details Updated Successfully");
        }
    }
}