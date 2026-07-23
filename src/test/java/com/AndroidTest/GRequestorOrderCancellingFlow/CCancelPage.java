package com.AndroidTest.GRequestorOrderCancellingFlow;

import Base.BasePage;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

public class CCancelPage extends BasePage {

    //=========================================================
    // Constructor
    //=========================================================

    public CCancelPage(AndroidDriver driver) {
        super(driver);
    }

    //=========================================================
    // Locators
    //=========================================================

    private final By pendingButton =
            By.xpath("//android.view.View[contains(@content-desc,'Pending')]");

    private final By cancelButton =
            AppiumBy.accessibilityId("Cancel");

    private final By cancelReason =
            AppiumBy.accessibilityId("Changed My Mind");

    private final By submitButton =
            AppiumBy.accessibilityId("Submit");

    private final By okButton =
            AppiumBy.accessibilityId("OK");


    //=========================================================
    // Open Pending Orders
    //=========================================================

//=========================================================
// Open Pending Orders
//=========================================================

    public void openPendingOrders() {

        boolean found = false;

        for (int i = 0; i < 6; i++) {

            // Check whether Pending button is available
            java.util.List<WebElement> pendingList = driver.findElements(pendingButton);

            if (!pendingList.isEmpty() && pendingList.get(0).isDisplayed()) {

                wait.until(ExpectedConditions.elementToBeClickable(pendingList.get(0)));

                pendingList.get(0).click();

                ExtentTestListener.logStep("Pending clicked successfully");

                if (ExtentTestListener.getTest() != null) {
                    ExtentTestListener.getTest().pass("Clicked Pending Orders");
                }

                found = true;
                break;
            }

            // Scroll down if Pending button is not visible
            swipeUp(0.85);
        }

        if (!found) {
            throw new RuntimeException("Pending Orders button not found after scrolling.");
        }
    }
    //=========================================================
    // Select Order
    //=========================================================

    public void selectOrderToCancel(String orderNumber) {

        boolean found = false;

        By orderXpath = By.xpath(
                "//android.widget.ImageView[contains(@content-desc,'" + orderNumber + "')]");

        for (int i = 0; i < 8; i++) {

            try {

                WebElement order = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(orderXpath));

                ExtentTestListener.logStep(
                        "Order Found : " + order.getAttribute("content-desc"));

                wait.until(ExpectedConditions.elementToBeClickable(order));

                order.click();

                ExtentTestListener.logStep(
                        "Order Clicked Successfully : " + orderNumber);

                if (ExtentTestListener.getTest() != null) {
                    ExtentTestListener.getTest().pass(
                            "Selected Order : " + orderNumber);
                }

                found = true;
                break;

            } catch (Exception e) {

                swipeUp(0.80);
            }
        }

        if (!found) {
            throw new RuntimeException(
                    "Order not found : " + orderNumber);
        }
    }

    //=========================================================
    // Click Cancel Button
    //=========================================================

    public void clickCancelButton() {

        wait.until(ExpectedConditions.elementToBeClickable(cancelButton))
                .click();

        ExtentTestListener.logStep("Cancel Button Clicked");

        if (ExtentTestListener.getTest() != null) {
            ExtentTestListener.getTest().pass("Clicked Cancel Button");
        }
    }

    //=========================================================
    // Select Cancel Reason
    //=========================================================

    public void selectCancelReason() {

        wait.until(ExpectedConditions.elementToBeClickable(cancelReason))
                .click();

        ExtentTestListener.logStep(
                "Cancel Reason Selected : Changed My Mind");

        if (ExtentTestListener.getTest() != null) {
            ExtentTestListener.getTest().pass(
                    "Selected Cancel Reason : Changed My Mind");
        }
    }

    //=========================================================
    // Click Submit
    //=========================================================

    public void clickSubmit() {

        wait.until(ExpectedConditions.elementToBeClickable(submitButton))
                .click();

        ExtentTestListener.logStep("Submit Button Clicked");

        if (ExtentTestListener.getTest() != null) {
            ExtentTestListener.getTest().pass("Clicked Submit Button");
        }
    }

    //=========================================================
    // Click OK Popup
    //=========================================================

    public void clickOkPopup() {

        wait.until(ExpectedConditions.elementToBeClickable(okButton))
                .click();

        ExtentTestListener.logStep("OK Popup Clicked");

        if (ExtentTestListener.getTest() != null) {
            ExtentTestListener.getTest().pass("Clicked OK Popup");
        }
    }

    //=========================================================
    // Reusable Swipe Method
    //=========================================================

    private void swipeUp(double percent) {

        driver.executeScript(
                "mobile: swipeGesture",
                Map.of(
                        "left", 100,
                        "top", 300,
                        "width", 500,
                        "height", 1000,
                        "direction", "up",
                        "percent", percent
                )
        );
    }
}