package com.AndroidTest.N1ReferAndEarnFlow;

import Base.ExtentTestListener;
import Utility.DOrderDataReferEarn;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EDoorPickupPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public EDoorPickupPage(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public void completeDoorPickupFlow() throws Exception {

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

        // Choose Location From Map
        WebElement chooseLocation = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.view.View[contains(@content-desc,'Choose location from map')]")));

        chooseLocation.click();

        ExtentTestListener.logStep("Choose Location From Map Clicked");

        // Location  OK
        WebElement okView = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.view.View[@content-desc='OK']")));

        okView.click();

        ExtentTestListener.logStep("Location OK Clicked");

        // Second OK Button
        WebElement secondOk = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.widget.Button[@content-desc='OK']"))
        );

        secondOk.click();

        ExtentTestListener.logStep("Second OK Button Clicked");

//
//        // Save
//        WebElement saveBtn = wait.until(
//                ExpectedConditions.elementToBeClickable(
//                        AppiumBy.accessibilityId("Save")));
//
//        saveBtn.click();
//
//        ExtentTestListener.logStep("Save Clicked");
//        ExtentTestListener.getTest().pass("Location Saved Successfully");
//
//
//        // CLICK "SELECT YOUR PICKUP LOCATION ON MAP"
//        WebElement pickupLocation1 = wait.until(
//                ExpectedConditions.visibilityOfElementLocated(
//                        By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]")));
//
//        pickupLocation1.click();
//
//        ExtentTestListener.logStep("Pickup Location Clicked");
//
//        ExtentTestListener.getTest().pass("Clicked Select Pickup Location On Map");
//
//
//        //saved Address (dynamic)
//        WebElement savedAddress = wait.until(
//                ExpectedConditions.elementToBeClickable(
//                        AppiumBy.xpath(
//                                "//android.view.View[@content-desc='Saved Address']/following::android.view.View[@clickable='true'][1]"
//                        )
//                )
//        );
//
//        savedAddress.click();
//
//        ExtentTestListener.logStep("Saved Address Clicked");
//
//
//
//
//        // WAIT FOR OK POPUP
//        WebElement okButton = wait.until(
//                ExpectedConditions.elementToBeClickable(
//                        AppiumBy.accessibilityId("OK")));
//
//        okButton.click();
//
//        ExtentTestListener.logStep("OK Popup Clicked");
//        ExtentTestListener.getTest().pass("Clicked OK Popup");
//

         //Checkbox
        WebElement checkbox = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.widget.CheckBox[@content-desc='I confirm that my request contains only the accepted materials and meets the above conditions *']")));

        driver.executeScript(
                "mobile: clickGesture",
                Map.of(
                        "elementId",
                        ((RemoteWebElement) checkbox).getId()));

        ExtentTestListener.logStep("Checkbox Selected");


        // Scroll until Select Slot
        while (driver.findElements(AppiumBy.accessibilityId("Select Slot")).isEmpty()) {

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

        // ==========================================================
        // Select Slot
        // ==========================================================

        WebElement selectSlot = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Select Slot")));

        selectSlot.click();

        ExtentTestListener.logStep("Select Slot Clicked");


        // ==========================================================
        // Select  Slot Time
        // ==========================================================

        WebElement slot = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("02:00 PM - 11:55 PM")
                )
        );

        slot.click();

        ExtentTestListener.logStep("Slot Selected");

        // ==========================================================
        // Continue
        // ==========================================================

        WebElement continueBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Continue")));

        continueBtn.click();

        ExtentTestListener.logStep("Continue Clicked");

        // ==========================================================
        // Confirm
        // ==========================================================

        WebElement confirmBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Confirm")));

        confirmBtn.click();

        ExtentTestListener.logStep("Confirm Clicked");

        // ==========================================================
        // Final OK Popup
        // ==========================================================

        WebElement finalOk = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.widget.Button[@content-desc='OK']")));

        finalOk.click();

        ExtentTestListener.logStep("Final OK Clicked");

        // ==========================================================
        // Scroll to Recent Order
        // ==========================================================

        while (driver.findElements(
                        AppiumBy.xpath("//android.view.View[contains(@content-desc,'Your order')]"))
                .isEmpty()) {

            driver.executeScript("mobile: scrollGesture", Map.of(
                    "left", 300,
                    "top", 1100,
                    "width", 200,
                    "height", 500,
                    "direction", "down",
                    "percent", 0.8
            ));
        }


        // ==========================================================
        // Capture Order Number
        // ==========================================================

        WebElement recentOrder = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.xpath("//android.view.View[contains(@content-desc,'Your order')]")
                ));

        String orderText = recentOrder.getAttribute("contentDescription");

        System.out.println("Order Card : " + orderText);


        // Extract CH-RO-xxxxx
        Pattern pattern = Pattern.compile("CH-RO-\\d+");
        Matcher matcher = pattern.matcher(orderText);

        if (matcher.find()) {

            DOrderDataReferEarn.orderNumberReferEarn = matcher.group();

            System.out.println("Saved Order Number : " + DOrderDataReferEarn.orderNumberReferEarn);

            ExtentTestListener.logStep("Order Number Saved : " + DOrderDataReferEarn.orderNumberReferEarn);

        } else {
            throw new RuntimeException("Order Number not found.");
        }

        ExtentTestListener.getTest().pass(
                "Door Pickup Flow Completed Successfully. Order Number: " + DOrderDataReferEarn.orderNumberReferEarn);

        ExtentTestListener.getTest().pass("Door Pickup Flow Completed Successfully");
    }
}