package com.AndroidTest.JProfileViewBasicFeaturesFlow;

import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.Map;

public class CProfilePhotoUploadPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public CProfilePhotoUploadPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public void clickViewProfile() {

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("View Profile"))).click();

        ExtentTestListener.logStep("View Profile Clicked");
    }

    public void uploadProfilePhoto() throws Exception {

        // Click Upload Icon
        WebElement uploadIcon = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        AppiumBy.xpath("//android.widget.ScrollView/android.view.View[1]")));

        driver.executeScript("mobile: clickGesture",
                Map.of("elementId", ((RemoteWebElement) uploadIcon).getId()));

        ExtentTestListener.logStep("Upload icon tapped");

        // Click Gallery
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Gallery"))).click();

        ExtentTestListener.logStep("Gallery Clicked");

        // Select image manually
        ExtentTestListener.logStep("Please select image manually from Gallery...");
        Thread.sleep(30000);   // Wait 30 seconds for manual image selection

// Bring SmartSort back
        driver.activateApp("com.abqaiq.smartsort");
        ExtentTestListener.logStep("Returned to SmartSort App");

// Wait for screen to load
        Thread.sleep(5000);

        try {

            // Wait until Done button is visible (NOT clickable)
            WebElement doneBtn = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.androidUIAutomator(
                                    "new UiSelector().className(\"android.widget.Button\").instance(3)")
                    ));

            // Click using JavaScript/Appium click
            doneBtn.click();

            ExtentTestListener.logStep("Done Button Clicked");

        } catch (Exception e) {

            System.out.println("Normal click failed. Trying coordinates...");

            // Tap on Done button using coordinates
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence tap = new Sequence(finger, 1);

            tap.addAction(finger.createPointerMove(Duration.ZERO,
                    PointerInput.Origin.viewport(), 586, 1452));
            tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Collections.singletonList(tap));

            ExtentTestListener.logStep("Done Button Tapped by Coordinates");
        }

// Wait for popup
        WebElement okBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("OK")));

        okBtn.click();

        ExtentTestListener.logStep("OK Button Clicked");

        Thread.sleep(4000);
        // Wait until profile screen is loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("View Profile")));

        ExtentTestListener.logStep("Profile Photo Uploaded Successfully");
    }
}