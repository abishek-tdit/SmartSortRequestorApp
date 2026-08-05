package com.AndroidTest.C3CollectorUtilityOrderCompleteFlow;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

public class CNavigationPage extends BaseClassMobile {

    public void completeNavigation() {

        try {

            // Search Start Navigation
            ExtentTestListener.logStep("Searching Start Navigation...");

            WebElement startNavigation = driver.findElement(
                    AppiumBy.androidUIAutomator(
                            "new UiScrollable(new UiSelector().scrollable(true))" +
                                    ".scrollIntoView(new UiSelector().description(\"Start Navigation\"))"
                    )
            );
            Thread.sleep(3000);
            // Click Start Navigation - Page 1
            driver.executeScript(
                    "mobile: clickGesture",
                    Map.of(
                            "elementId",
                            ((RemoteWebElement) startNavigation).getId()
                    )
            );

            ExtentTestListener.logStep("Start Navigation (Page 1) clicked");
            Thread.sleep(3000);
            // Second Start Navigation (Optional)
            try {

                WebElement secondStart = driver.findElement(
                        AppiumBy.xpath("//android.widget.Button[@content-desc='Start Navigation']")
                );

                secondStart.click();

                ExtentTestListener.logStep("Start Navigation (Page 2) clicked");

            } catch (Exception e) {

                ExtentTestListener.logStep("Second Start Navigation not available");
            }
            Thread.sleep(3000);
            // OK Popup (Optional)
            try {

                WebElement ok = driver.findElement(
                        AppiumBy.accessibilityId("OK")
                );

                ok.click();

                ExtentTestListener.logStep("OK clicked");

            } catch (Exception e) {

                ExtentTestListener.logStep("OK popup not displayed");
            }
            Thread.sleep(3000);
            // Reached
            WebElement reached = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.accessibilityId("Reached"))
            );

            reached.click();

        } catch (Exception e) {

            ExtentTestListener.logStep("Navigation failed : " + e.getMessage());

            throw new RuntimeException("Navigation Flow Failed", e);
        }
    }
}