package com.AndroidTest.DRequestorRedeemFlow;

import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FLocationPage2 {

    AndroidDriver driver;
    WebDriverWait wait;

    public FLocationPage2(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void selectLocation() throws Exception {
        // Wait until Home page loading is completed
        waitForPageToBeStable();

        ExtentTestListener.logStep("Home page loading completed");
        // Click Explore Other Locations
        WebElement exploreBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Explore Other Locations")));

        exploreBtn.click();

        ExtentTestListener.logStep("Explore Other Locations clicked");

        // Click Bqaiq
        WebElement locationBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Bqaiq")));

        locationBtn.click();

        ExtentTestListener.logStep("Location Selected : Bqaiq");

        // Wait until loading is completed
        waitForPageToBeStable();

        ExtentTestListener.logStep("Location loading completed");
    }

    private void waitForPageToBeStable() {

        String previousSource = "";
        int stableCount = 0;

        long endTime = System.currentTimeMillis() + 15000; // Max 15 seconds

        while (System.currentTimeMillis() < endTime) {

            String currentSource = driver.getPageSource();

            if (currentSource.equals(previousSource)) {
                stableCount++;

                // Only 2 stable checks (about 1 second)
                if (stableCount >= 2) {
                    return;
                }
            } else {
                stableCount = 0;
                previousSource = currentSource;
            }

            try {
                Thread.sleep(500);   // Check every 0.5 second
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}