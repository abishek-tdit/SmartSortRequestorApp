package com.AndroidTest.C5CollectorNavigateToCollectionCenterFlow;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BCollectorNavigateToCollectionCenterDOPage extends BaseClassMobile {

    public void openAcceptedDeliveryOrders() throws Exception {

        try {

            // Click Delivery Orders
            ExtentTestListener.logStep("Clicking Delivery Orders (DO)...");

            WebElement deliveryOrders = waitUntilClickable(
                    AppiumBy.accessibilityId("Delivery Orders (DO)"), 20);
            deliveryOrders.click();

            // Click Accepted Tab
            ExtentTestListener.logStep("Clicking Accepted Tab...");

            WebElement acceptedTab = waitUntilClickable(
                    AppiumBy.androidUIAutomator(
                            "new UiSelector().descriptionContains(\"Accepted\")"), 20);

            acceptedTab.click();

            ExtentTestListener.logStep("Accepted Tab Clicked Successfully");

            // Click First Order
            ExtentTestListener.logStep("Clicking Order Details...");

            WebElement orderDetails = waitUntilClickable(
                    AppiumBy.xpath("(//android.view.View[contains(@content-desc,'AB-DO-')])[1]"), 20);

            orderDetails.click();

            // First Start Navigation
            WebElement startNavigation = waitUntilClickable(
                    AppiumBy.accessibilityId("Start Navigation"), 20);

            startNavigation.click();

            ExtentTestListener.logStep("First Start Navigation Clicked");

            // Wait until first button disappears
            wait.until(ExpectedConditions.stalenessOf(startNavigation));

            // Now locate the second button
            WebElement secondStartNavigation = waitUntilClickable(
                    AppiumBy.accessibilityId("Start Navigation"), 20);

            secondStartNavigation.click();

            ExtentTestListener.logStep("Second Start Navigation Clicked Successfully");

            // Reached Destination
            ExtentTestListener.logStep("Waiting for Reached Destination...");

            WebElement reachedDestination = waitUntilClickable(
                    AppiumBy.accessibilityId("Reached Destination"), 20);

            reachedDestination.click();
            Thread.sleep(4000);
            // OK Popup
            ExtentTestListener.logStep("Clicking OK Popup...");

            WebElement okButton = waitUntilClickable(
                    AppiumBy.accessibilityId("OK"), 20);

            okButton.click();

            ExtentTestListener.logStep("Navigation completed successfully.");

            // Back Button
            ExtentTestListener.logStep("Clicking Back Button...");

            WebElement backButton = waitUntilClickable(
                    AppiumBy.androidUIAutomator(
                            "new UiSelector().className(\"android.view.View\").instance(6)"), 20);

            backButton.click();

            ExtentTestListener.logStep("Back Button Clicked Successfully");

        } catch (Exception e) {

            ExtentTestListener.logStep(
                    "Error while opening Accepted Delivery Orders: " + e.getMessage());

            throw e;
        }
    }
}