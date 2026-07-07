package com.AndroidTest.GRequestorOrderCancellingFlow;

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

public class CCancelPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public CCancelPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    //OPEN PENDING ORDERS
    public void openPendingOrders() throws Exception {

        // Wait for page to stabilize after location selection
        Thread.sleep(8000);

        boolean found = false;

        // Try scroll + search multiple times
        for (int i = 0; i < 5; i++) {

            try {
                // Try dynamic locator (IMPORTANT FIX)
                WebElement pendingBtn = driver.findElement(
                        By.xpath("//android.view.View[contains(@content-desc,'Pending')]")
                );

                if (pendingBtn.isDisplayed()) {
                    pendingBtn.click();
                    System.out.println("Pending clicked successfully");

                    if (ExtentTestListener.getTest() != null) {
                        ExtentTestListener.getTest().pass("Clicked Pending Orders");
                    }

                    found = true;
                    break;
                }

            } catch (Exception e) {
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

        Thread.sleep(3000);
    }

    // Click Order based on Order Number
    public void selectOrderToCancel(String orderNumber) throws Exception {

        Thread.sleep(5000);

        boolean found = false;

        By orderXpath = By.xpath(
                "//android.widget.ImageView[contains(@content-desc,'" + orderNumber + "')]"
        );

        for (int i = 0; i < 8; i++) {

            try {

                WebElement order = driver.findElement(orderXpath);

                System.out.println("Found Order : "
                        + order.getAttribute("content-desc"));

                wait.until(ExpectedConditions.elementToBeClickable(order));

                order.click();

                System.out.println("Clicked Successfully : " + orderNumber);

                found = true;
                break;

            } catch (Exception e) {

                driver.executeScript("mobile: swipeGesture",
                        java.util.Map.of(
                                "left", 100,
                                "top", 300,
                                "width", 500,
                                "height", 1000,
                                "direction", "up",
                                "percent", 0.80
                        ));

                Thread.sleep(2000);
            }
        }

        if (!found) {
            throw new RuntimeException("Order not found : " + orderNumber);
        }
    }

    //CLICK CANCEL BUTTON
    public void clickCancelButton() throws Exception {

        Thread.sleep(3000);

        WebElement cancelBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Cancel")
                )
        );

        cancelBtn.click();

        System.out.println("Cancel Button Clicked");

        if (ExtentTestListener.getTest() != null) {
            ExtentTestListener.getTest().pass("Cancel Button Clicked");
        }

        Thread.sleep(2000);
    }

    // ================= SELECT CANCEL REASON =================
    public void selectCancelReason() throws Exception {

        Thread.sleep(3000);

        WebElement reasonBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Changed My Mind")
                )
        );

        reasonBtn.click();

        System.out.println("Cancel Reason Selected: Changed My Mind");

        if (ExtentTestListener.getTest() != null) {
            ExtentTestListener.getTest().pass("Selected Cancel Reason: Changed My Mind");
        }

        Thread.sleep(2000);
    }

    // ================= CLICK SUBMIT =================
    public void clickSubmit() throws Exception {

        Thread.sleep(2000);

        WebElement submitBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Submit")
                )
        );

        submitBtn.click();

        System.out.println("Submit Button Clicked");

        if (ExtentTestListener.getTest() != null) {
            ExtentTestListener.getTest().pass("Clicked Submit Button");
        }

        Thread.sleep(2000);
    }

    // ================= CLICK OK POPUP =================
    public void clickOkPopup() throws Exception {

        Thread.sleep(3000);

        WebElement okBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("OK")
                )
        );

        okBtn.click();

        System.out.println("OK Popup Clicked");

        if (ExtentTestListener.getTest() != null) {
            ExtentTestListener.getTest().pass("Clicked OK Popup");
        }

        Thread.sleep(2000);
    }
}