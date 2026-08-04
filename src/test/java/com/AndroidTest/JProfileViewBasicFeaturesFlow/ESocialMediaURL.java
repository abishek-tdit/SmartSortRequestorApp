package com.AndroidTest.JProfileViewBasicFeaturesFlow;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ESocialMediaURL extends BaseClassMobile {

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

    //=========================================================
    // Open View Profile
    //=========================================================

    public void openProfile() throws InterruptedException {

        // Profile
        wait.until(ExpectedConditions.elementToBeClickable(profileIcon)).click();
        ExtentTestListener.logStep("Profile Icon Clicked");

        // View Profile
        wait.until(ExpectedConditions.elementToBeClickable(viewProfile)).click();
        ExtentTestListener.logStep("View Profile Clicked");


        // Click LinkedIn (In)
        By linkedIn = AppiumBy.xpath("//android.widget.ScrollView/android.widget.Button[1]");

        wait.until(ExpectedConditions.elementToBeClickable(linkedIn)).click();
        ExtentTestListener.logStep("LinkedIn Icon Clicked");


        // Wait for browser to open
        Thread.sleep(2000);


        // Navigate Back
        driver.navigate().back();
        ExtentTestListener.logStep("Returned from LinkedIn");


        // Click Facebook (F)
        By facebook = AppiumBy.xpath("//android.widget.ScrollView/android.widget.Button[2]");

        wait.until(ExpectedConditions.elementToBeClickable(facebook)).click();
        ExtentTestListener.logStep("Facebook Icon Clicked");

        // Wait for browser to open
        Thread.sleep(2000);

        // Navigate Back
        driver.navigate().back();
        ExtentTestListener.logStep("Returned from Facebook");
    }
}