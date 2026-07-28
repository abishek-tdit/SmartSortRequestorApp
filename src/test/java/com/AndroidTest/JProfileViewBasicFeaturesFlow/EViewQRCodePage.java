package com.AndroidTest.JProfileViewBasicFeaturesFlow;

import Base.BasePage;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EViewQRCodePage extends BasePage {

    //=========================================================
    // Constructor
    //=========================================================

    public EViewQRCodePage(AndroidDriver driver) {
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

    private final By viewQRCode =
            AppiumBy.accessibilityId("View QR Code");

    private final By downloadQRButton =
            AppiumBy.xpath("//android.widget.Button");

    //=========================================================
    // Verify QR Code Feature
    //=========================================================

    public void verifyQRCodeFeature() throws InterruptedException {

        // Profile
        wait.until(ExpectedConditions.elementToBeClickable(profileIcon)).click();
        ExtentTestListener.logStep("Profile Icon Clicked");

        // View Profile
        wait.until(ExpectedConditions.elementToBeClickable(viewProfile)).click();
        ExtentTestListener.logStep("View Profile Clicked");

        // Click View QR Code
        wait.until(ExpectedConditions.elementToBeClickable(viewQRCode))
                .click();

        ExtentTestListener.logStep("View QR Code Clicked");
        Thread.sleep(2000);

        // Click Download QR
        wait.until(ExpectedConditions.elementToBeClickable(downloadQRButton))
                .click();

        ExtentTestListener.logStep("Download QR Clicked");
        Thread.sleep(2000);

        // Navigate Back
        driver.navigate().back();

        ExtentTestListener.logStep("Navigated Back");

        if (ExtentTestListener.getTest() != null) {
            ExtentTestListener.getTest().pass("QR Code Feature Verified Successfully");
        }
    }
}