package com.AndroidTest.JProfileViewBasicFeaturesFlow;

import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NPrivacyPolicyPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public NPrivacyPolicyPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickPrivacyPolicy() throws InterruptedException {
        wait.until(driver -> true);
        // Click Privacy Policy
        WebElement privacyPolicy = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Privacy Policy"))
        );

        privacyPolicy.click();

        ExtentTestListener.logStep("Privacy Policy Clicked");

        // Wait for page to open
        Thread.sleep(3000);

        // Navigate Back
        driver.navigate().back();

        ExtentTestListener.logStep("Navigated Back from Privacy Policy");
    }
}