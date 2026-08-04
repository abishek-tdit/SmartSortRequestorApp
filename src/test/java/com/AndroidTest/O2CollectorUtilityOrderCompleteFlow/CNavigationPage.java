package com.AndroidTest.O2CollectorUtilityOrderCompleteFlow;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

public class CNavigationPage extends BaseClassMobile {

    public void completeNavigation() {

        try {

            // Scroll to Start Navigation if required
            ExtentTestListener.logStep("Searching Start Navigation...");

            WebElement startNavigation = driver.findElement(
                    AppiumBy.androidUIAutomator(
                            "new UiScrollable(new UiSelector().scrollable(true))"
                                    + ".scrollIntoView(new UiSelector().description(\"Start Navigation\"))"
                    )
            );

            // Click Start Navigation - Page 1
            driver.executeScript(
                    "mobile: clickGesture",
                    Map.of(
                            "elementId",
                            ((RemoteWebElement) startNavigation).getId()
                    )
            );

            ExtentTestListener.logStep("Start Navigation (Page 1) clicked");

            // Click Start Navigation - Page 2 (if available)
            try {

                WebElement secondStart = wait.until(
                        ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.widget.Button[@content-desc='Start Navigation']")
                        ));

                secondStart.click();

                ExtentTestListener.logStep("Start Navigation (Page 2) clicked");

            } catch (Exception e) {

                ExtentTestListener.logStep("Second Start Navigation not available");
            }

            // Wait before clicking Reached
            Thread.sleep(2000);

            // Reached
            WebElement reached = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            AppiumBy.accessibilityId("Reached")));

            reached.click();

            ExtentTestListener.logStep("Reached clicked");

            // Wait 2 seconds after clicking Reached
            Thread.sleep(2000);

            // ==========================================================
            // Return to Dashboard
            // ==========================================================

            WebElement popup = wait.until(
                    ExpectedConditions.presenceOfElementLocated(
                            AppiumBy.xpath("//android.view.View[contains(@content-desc,'Status updated successfully')]")));

            ExtentTestListener.logStep("Popup detected");

            Rectangle rect = popup.getRect();

            int centerX = rect.getX() + rect.getWidth() / 2;
            int startY = rect.getY();

            int[] yOffsets = {
                    (int) (rect.getHeight() * 0.60),
                    (int) (rect.getHeight() * 0.65),
                    (int) (rect.getHeight() * 0.70),
                    (int) (rect.getHeight() * 0.75)
            };

            boolean clicked = false;

            for (int offset : yOffsets) {

                int tapY = startY + offset;

                ExtentTestListener.logStep("Trying tap at : " + centerX + "," + tapY);

                ((JavascriptExecutor) driver).executeScript(
                        "mobile: clickGesture",
                        Map.of(
                                "x", centerX,
                                "y", tapY
                        )
                );

                if (driver.findElements(
                        AppiumBy.xpath("//android.view.View[contains(@content-desc,'Status updated successfully')]")
                ).isEmpty()) {

                    clicked = true;

                    ExtentTestListener.logStep("Return to Dashboard Clicked");

                    break;
                }
            }

            if (!clicked) {
                throw new RuntimeException("Could not click Return to Dashboard button");
            }

            ExtentTestListener.logStep("Navigation Flow Completed Successfully");

        } catch (Exception e) {

            ExtentTestListener.logStep("Navigation failed : " + e.getMessage());

            throw new RuntimeException("Navigation Flow Failed", e);
        }
    }
}