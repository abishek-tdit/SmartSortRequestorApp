package com.AndroidTest.JProfileViewBasicFeaturesFlow;

import Base.BasePage;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.Collections;
import java.util.Map;

public class CProfilePhotoUploadPage extends BasePage {

    //=========================================================
    // Constructor
    //=========================================================

    public CProfilePhotoUploadPage(AndroidDriver driver) {
        super(driver);
    }

    //=========================================================
    // Locators
    //=========================================================

    private final By viewProfile =
            AppiumBy.accessibilityId("View Profile");

    private final By uploadIcon =
            AppiumBy.xpath("//android.widget.ScrollView/android.view.View[1]");

    private final By galleryButton =
            AppiumBy.accessibilityId("Gallery");

    private final By doneButton =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().className(\"android.widget.Button\").instance(3)");

    private final By okButton =
            AppiumBy.accessibilityId("OK");

    //=========================================================
    // Click View Profile
    //=========================================================

    public void clickViewProfile() {

        wait.until(ExpectedConditions.elementToBeClickable(viewProfile))
                .click();

        ExtentTestListener.logStep("View Profile Clicked");

        if (ExtentTestListener.getTest() != null) {
            ExtentTestListener.getTest().pass("Clicked View Profile");
        }
    }

    //=========================================================
    // Upload Profile Photo
    //=========================================================

    public void uploadProfilePhoto() throws Exception {

        // Upload Icon
        WebElement upload = wait.until(
                ExpectedConditions.presenceOfElementLocated(uploadIcon));

        driver.executeScript(
                "mobile: clickGesture",
                Map.of("elementId", ((RemoteWebElement) upload).getId()));

        ExtentTestListener.logStep("Upload Icon Clicked");

        // Gallery
        wait.until(ExpectedConditions.elementToBeClickable(galleryButton))
                .click();

        ExtentTestListener.logStep("Gallery Clicked");

        // Manual Image Selection
        ExtentTestListener.logStep("Please select image manually...");

        // Wait until Done button is available after image selection
        WebElement doneButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().text(\"Done\")"
                        )
                )
        );

        doneButton.click();

        ExtentTestListener.logStep("Done button clicked after image selection");

        // OK Popup
        wait.until(ExpectedConditions.elementToBeClickable(okButton))
                .click();

        ExtentTestListener.logStep("OK Button Clicked");

        Thread.sleep(4000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(viewProfile));

        ExtentTestListener.logStep("Profile Photo Uploaded");

    }
}