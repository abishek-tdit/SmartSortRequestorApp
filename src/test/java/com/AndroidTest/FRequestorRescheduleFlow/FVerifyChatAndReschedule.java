package com.AndroidTest.FRequestorRescheduleFlow;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.Map;

public class FVerifyChatAndReschedule extends BaseClassMobile {

    //=========================================================
    // Open Pending Orders
    //=========================================================

    public void openPendingOrders() throws Exception {

        boolean found = false;

        // Try scroll + search multiple times
        for (int i = 0; i < 5; i++) {

            try {

                WebElement pendingBtn = driver.findElement(
                        By.xpath("//android.view.View[contains(@content-desc,'Pending')]"));

                if (pendingBtn.isDisplayed()) {

                    pendingBtn.click();

                    ExtentTestListener.logStep("Pending clicked successfully");

                    if (ExtentTestListener.getTest() != null) {
                        ExtentTestListener.getTest().pass("Clicked Pending Orders");
                    }

                    found = true;
                    break;
                }

            } catch (Exception e) {

                Map<String, Object> params = new HashMap<>();
                params.put("left", 100);
                params.put("top", 300);
                params.put("width", 500);
                params.put("height", 1000);
                params.put("direction", "up");
                params.put("percent", 0.85);

                driver.executeScript("mobile: swipeGesture", params);

                Thread.sleep(2000);
            }
        }

        if (!found) {
            throw new RuntimeException("Pending Orders button not found after scrolling");
        }
    }

    //=========================================================
    // Select Order
    //=========================================================

    public void selectOrderToReschedule(String orderNumber) throws Exception {

        boolean found = false;

        By orderXpath = By.xpath(
                "//android.widget.ImageView[contains(@content-desc,'" + orderNumber + "')]");

        for (int i = 0; i < 6; i++) {

            try {

                WebElement order = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(orderXpath));

                wait.until(ExpectedConditions.elementToBeClickable(order));

                String orderDetails = order.getAttribute("content-desc");

                ExtentTestListener.logStep("Order Found : " + orderDetails);

                order.click();

                ExtentTestListener.logStep(
                        "Order Clicked Successfully : " + orderNumber);

                if (ExtentTestListener.getTest() != null) {
                    ExtentTestListener.getTest().pass(
                            "Order selected successfully : " + orderNumber);
                }

                found = true;
                break;

            } catch (Exception e) {

                driver.executeScript("mobile: swipeGesture",
                        Map.of(
                                "left", 100,
                                "top", 300,
                                "width", 500,
                                "height", 1000,
                                "direction", "up",
                                "percent", 0.80));

                Thread.sleep(2000);
            }
        }

        if (!found) {
            throw new RuntimeException("Order not found : " + orderNumber);
        }
    }

    //=========================================================
    // Open Chat
    //=========================================================

    public void openChatAndReturn() throws Exception {

        WebElement chatBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Chat")));

        chatBtn.click();

        ExtentTestListener.logStep("Chat button clicked");

        Thread.sleep(5000);

        driver.navigate().back();

        // Click Go Back
        WebElement goBackBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("go back")));
        goBackBtn.click();

        ExtentTestListener.logStep("Go Back button clicked");
    }

        public void clickRescheduleButton() throws Exception {

        // Scroll down a little
        driver.executeScript("mobile: swipeGesture",
                java.util.Map.of(
                        "left", 100,
                        "top", 400,
                        "width", 500,
                        "height", 900,
                        "direction", "up",
                        "percent", 0.30 ));

        Thread.sleep(1500);
        WebElement rescheduleBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Reschedule")));

        rescheduleBtn.click();

        ExtentTestListener.logStep("Reschedule button clicked");
    }
}