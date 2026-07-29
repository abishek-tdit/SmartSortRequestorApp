package com.AndroidTest.CRequestorOrderPlacingFlow;

import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Map;

public class CDoorPickupPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public CDoorPickupPage(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public void selectPickup() throws Exception {

        // Scroll to Door Pickup
        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))"
                                + ".scrollIntoView(new UiSelector().descriptionContains(\"Door Pickup\"))"));

        ExtentTestListener.logStep("Scrolled to Door Pickup");



        // Click Door Pickup directly
        WebElement doorPickup = driver.findElement(
                By.xpath("//android.widget.ImageView[contains(@content-desc,'Door Pickup')]"));

        doorPickup.click();

        ExtentTestListener.logStep("Door Pickup Clicked");


        // CLICK "SELECT YOUR PICKUP LOCATION ON MAP"
        WebElement pickupLocation = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]")));

        pickupLocation.click();

        ExtentTestListener.logStep("Pickup Location Clicked");

        ExtentTestListener.getTest().pass("Clicked Select Pickup Location On Map");



        // Click Saved Address
        WebElement savedAddress = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath(
                                "//android.view.View[contains(@content-desc,'Buqayq')]")
                )
        );
        savedAddress.click();

        ExtentTestListener.logStep("Saved Address Clicked ");


        // WAIT FOR OK POPUP
        WebElement okButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("OK")));

        okButton.click();

        ExtentTestListener.logStep("OK Popup Clicked");
        ExtentTestListener.getTest().pass("Clicked OK Popup");



        //Tic checkbox
        WebElement checkBox = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath(
                                "//android.widget.CheckBox[@content-desc='I confirm that my request contains only the accepted materials and meets the above conditions *']")));

        driver.executeScript(
                "mobile: clickGesture",
                Map.of(
                        "elementId",
                        ((RemoteWebElement) checkBox).getId()));

        ExtentTestListener.logStep("Checkbox Selected");
        ExtentTestListener.getTest().pass("Checkbox Selected");


        // Scroll down until "Pick up instructions" is visible
        while (driver.findElements(AppiumBy.accessibilityId("Pick up instructions")).isEmpty()) {

            driver.executeScript(
                    "mobile: scrollGesture",
                    Map.of(
                            "left", 100,
                            "top", 300,
                            "width", 800,
                            "height", 1200,
                            "direction", "down",
                            "percent", 0.8
                    ));
        }

        // Pickup Instructions
        WebElement pickupInstructions = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Pick up instructions")));

        pickupInstructions.click();
        ExtentTestListener.logStep("Pickup Instructions Opened");

// Select "Dont ring bell"
        WebElement dontRingBell = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Dont ring bell")));

        dontRingBell.click();
        ExtentTestListener.logStep("Instruction Selected : Don't ring bell");

// Enter Note
        WebElement noteTextBox = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.className("android.widget.EditText")));

        noteTextBox.click();
        noteTextBox.clear();
        noteTextBox.sendKeys("Beware of dogs");

        ExtentTestListener.logStep("Pickup Note Entered");

// Start Recording
        WebElement startRecording = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Start recording")));

        driver.executeScript(
                "mobile: clickGesture",
                Map.of(
                        "elementId",
                        ((RemoteWebElement) startRecording).getId()));

        ExtentTestListener.logStep("Audio Recording Started");

// Record for 3 seconds
        Thread.sleep(3000);

// Stop Recording
        WebElement stopRecording = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Recording in progress")));

        driver.executeScript(
                "mobile: clickGesture",
                Map.of(
                        "elementId",
                        ((RemoteWebElement) stopRecording).getId()));

        ExtentTestListener.logStep("Audio Recording Stopped");

// Save
        WebElement saveButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Save")));

        saveButton.click();
        ExtentTestListener.logStep("Pickup Instructions Saved");


    }
}