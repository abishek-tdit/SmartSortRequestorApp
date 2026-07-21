package com.AndroidTest.JProfileViewBasicFeaturesFlow;

import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JCheckForUpdatePage {

    AndroidDriver driver;
    WebDriverWait wait;

    public JCheckForUpdatePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickCheckForUpdate() throws InterruptedException {

        //Click View Profile (if needed)
        try {
            wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.accessibilityId("View Profile")
            )).click();

            ExtentTestListener.logStep("View Profile Clicked");

            Thread.sleep(3000);
        } catch (Exception e) {
            ExtentTestListener.logStep("View Profile already open");
        }

        //Click Check for Update
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Check for update")
        )).click();

        ExtentTestListener.logStep("Check for Update Clicked");

        Thread.sleep(3000);
    }
}