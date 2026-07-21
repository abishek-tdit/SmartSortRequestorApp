package com.AndroidTest.FRequestorRescheduleFlow;

import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class CReschedulePage {

    AndroidDriver driver;
    WebDriverWait wait;

    public CReschedulePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public void clickReschedule() throws Exception {

        Thread.sleep(6000);

        boolean found = false;

        // Try scroll + search multiple times
        for (int i = 0; i < 5; i++) {

            try {

                WebElement pendingBtn = driver.findElement(
                        By.xpath("//android.view.View[contains(@content-desc,'Pending')]")
                );

                if (pendingBtn.isDisplayed()) {
                    pendingBtn.click();
                    ExtentTestListener.logStep("Pending clicked successfully");

                    if (ExtentTestListener.getTest() != null) {
                        ExtentTestListener.getTest().pass("Clicked Pending Orders");
                    }

                    found = true;
                    break;
                }
            }
            catch (Exception e)
            {
                // Scroll if not found
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

    // Click Order based on Order Number
    public void selectOrderToReschedule(String orderNumber) throws Exception {

        Thread.sleep(5000);

        boolean found = false;

        // Dynamic XPath using Order Number
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

                ExtentTestListener.logStep("Order Clicked Successfully : " + orderNumber);

                if (ExtentTestListener.getTest() != null) {
                    ExtentTestListener.getTest().pass(
                            "Order selected successfully : " + orderNumber);
                }

                found = true;
                break;

            }
            catch (Exception e)
            {
                // Scroll Up
                driver.executeScript("mobile: swipeGesture",
                        java.util.Map.of(
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
    public void clickRescheduleButton() throws Exception {

        Thread.sleep(5000);

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

        if (ExtentTestListener.getTest() != null) {
            ExtentTestListener.getTest().pass("Clicked Reschedule button");
        }

        Thread.sleep(3000);
    }
}
