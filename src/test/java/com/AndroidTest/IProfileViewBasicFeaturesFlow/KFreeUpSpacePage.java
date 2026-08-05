package com.AndroidTest.IProfileViewBasicFeaturesFlow;

import Base.BasePage;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class KFreeUpSpacePage extends BasePage {

    public KFreeUpSpacePage(AndroidDriver driver) {
        super(driver);
    }

    public void scrollAndOptimize() {

        ExtentTestListener.logStep("Start Free Up Space Flow");

        boolean found = false;

        // Scroll maximum 5 times
        for (int i = 0; i < 5; i++) {

            List<WebElement> elements =
                    driver.findElements(AppiumBy.accessibilityId("Free up space"));

            if (!elements.isEmpty()) {
                ExtentTestListener.logStep("Free up space Found");
                found = true;
                break;
            }

            utility.swipeUp(0.8);
        }

        if (!found) {
            throw new RuntimeException("Free up space NOT found after scrolling");
        }

        // Click Free Up Space
        wait.until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Free up space")))
                .click();

        ExtentTestListener.logStep("Free up space Clicked");

        clickOptimizeAndReset();
    }

    //=====================================================
    // Optimize + Reset
    //=====================================================

    public void clickOptimizeAndReset() {

        // Optimize
        ExtentTestListener.logStep("Optimize Step Started");

        wait.until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Optimize")))
                .click();

        ExtentTestListener.logStep("Optimize Clicked");

        // Reset
        ExtentTestListener.logStep("Reset Step Started");

        wait.until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Reset")))
                .click();

        ExtentTestListener.logStep("Reset Clicked");

        // Popup Handling
        ExtentTestListener.logStep("Handling Popup");

        try {
            wait.until(ExpectedConditions.elementToBeClickable(
                            AppiumBy.accessibilityId("Cancel")))
                    .click();

            ExtentTestListener.logStep("Cancel Clicked");

        } catch (Exception e) {

            ExtentTestListener.logStep("Cancel button not found");
        }

        // Back Navigation
        ExtentTestListener.logStep("Navigating Back");

        // Back 1
        try {

            wait.until(ExpectedConditions.elementToBeClickable(
                            AppiumBy.className("android.widget.Button")))
                    .click();

            ExtentTestListener.logStep("Back Button Clicked (1st time)");

        } catch (Exception e) {

            ExtentTestListener.logStep("Using driver.navigate().back()");

            driver.navigate().back();
        }

        // Back 2
        try {

            wait.until(ExpectedConditions.elementToBeClickable(
                            AppiumBy.androidUIAutomator(
                                    "new UiSelector().className(\"android.widget.Button\").instance(0)")))
                    .click();

            ExtentTestListener.logStep("Back Button Clicked (2nd time)");

        } catch (Exception e) {

            ExtentTestListener.logStep("Using driver.navigate().back()");

            driver.navigate().back();
        }

        ExtentTestListener.logStep("Navigation Completed");
    }
}