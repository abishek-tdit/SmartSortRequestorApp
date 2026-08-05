package com.AndroidTest.F2RequestorOrderCancellingFlow;

import Base.BasePage;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BLocationPage extends BasePage {

    //=========================================================
    // Constructor
    //=========================================================

    public BLocationPage(AndroidDriver driver) {
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

        // Wait until page loading completes
        waitForPageToBeStable();

        ExtentTestListener.logStep("Location loading completed");

        if (ExtentTestListener.getTest() != null) {
            ExtentTestListener.getTest().pass("Selected Location : Bqaiq");
        }
    }

    //=========================================================
    // Wait for Page to Become Stable
    //=========================================================

    private void waitForPageToBeStable() {

        String previousSource = "";
        int stableCount = 0;

        long endTime = System.currentTimeMillis() + 30000; // Max 30 sec

        while (System.currentTimeMillis() < endTime) {

            String currentSource = driver.getPageSource();

            if (currentSource.equals(previousSource)) {
                stableCount++;

                // Page source is unchanged for 5 consecutive checks
                if (stableCount >= 5) {
                    break;
                }
            } else {
                stableCount = 0;
                previousSource = currentSource;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}