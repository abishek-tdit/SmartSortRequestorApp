package com.AndroidTest.N1ReferAndEarnFlow;

import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class A1LocationPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public A1LocationPage(AndroidDriver driver) {
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

        long endTime = System.currentTimeMillis() + 60000; // Max 60 sec

        while (System.currentTimeMillis() < endTime) {

            String currentSource = driver.getPageSource();

            if (currentSource.equals(previousSource)) {
                stableCount++;

                // Page source unchanged for 3 consecutive checks
                if (stableCount >= 3) {
                    return;
                }
            } else {
                stableCount = 0;
                previousSource = currentSource;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}