package com.AndroidTest.IProfileViewBasicFeaturesFlow;

import Base.BasePage;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HLocationPage extends BasePage {

    //=========================================================
    // Constructor
    //=========================================================

    public HLocationPage(AndroidDriver driver) {
        super(driver);
    }

    //=========================================================
    // Locators
    //=========================================================

    private final By exploreOtherLocations =
            AppiumBy.accessibilityId("Explore Other Locations");

    private final By bqaiqLocation =
            AppiumBy.accessibilityId("Bqaiq");


    //=========================================================
    // Select Location
    //=========================================================

    public void selectLocation() {

        // Click Explore Other Locations
        wait.until(ExpectedConditions.elementToBeClickable(exploreOtherLocations))
                .click();

        ExtentTestListener.logStep("Clicked Explore Other Locations");

        // Select Bqaiq
        wait.until(ExpectedConditions.elementToBeClickable(bqaiqLocation))
                .click();

        ExtentTestListener.logStep("Location Selected : Bqaiq");

        if (ExtentTestListener.getTest() != null) {
            ExtentTestListener.getTest().pass("Selected Location : Bqaiq");

            wait.until(driver -> true);
        }
    }
}