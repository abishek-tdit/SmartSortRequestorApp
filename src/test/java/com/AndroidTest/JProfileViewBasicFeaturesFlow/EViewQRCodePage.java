package com.AndroidTest.JProfileViewBasicFeaturesFlow;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EViewQRCodePage {

    AndroidDriver driver;
    WebDriverWait wait;

    public EViewQRCodePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void verifyQRCodeFeature() throws InterruptedException {

        // Navigate back to Profile Page
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().className(\"android.widget.ImageView\").instance(0)")
        )).click();

        System.out.println("Profile Icon Clicked");

        Thread.sleep(5000);


        // Click View Profile
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("View Profile")
        )).click();

        System.out.println("View Profile Clicked");

        Thread.sleep(5000);

        // Click View QR Code
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("View QR Code")
        )).click();

        System.out.println("View QR Code Clicked");

        Thread.sleep(5000);

        // Click Download QR
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.Button")
        )).click();

        System.out.println("Download QR Clicked");

        Thread.sleep(5000);

        // Go Back to Previous Screen
        driver.navigate().back();

        System.out.println("Navigated Back");

        Thread.sleep(3000);

        System.out.println("QR Code Feature Completed Successfully");
    }
}