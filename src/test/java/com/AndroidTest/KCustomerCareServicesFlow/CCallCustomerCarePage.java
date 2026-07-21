package com.AndroidTest.KCustomerCareServicesFlow;

import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CCallCustomerCarePage {

    AndroidDriver driver;
    WebDriverWait wait;

    public CCallCustomerCarePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Click Call Icon
    public void clickCallIcon() throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement callIcon = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[1]")
                )
        );

        callIcon.click();

        Thread.sleep(2000);
    }

    // Click Call Popup
    public void clickCallButton() throws Exception {

        WebElement callBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Call")));

        callBtn.click();

        ExtentTestListener.logStep("Call Popup Clicked");

        // Wait for Phone app to open
        Thread.sleep(3000);
    }


    // Return To SmartSort App
    public void navigateBackToHomePage() throws Exception {

        try {
            // Exit Phone app
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Back key failed: " + e.getMessage());
        }

        // Bring SmartSort app back to foreground
        driver.activateApp("com.abqaiq.smartsort");

        Thread.sleep(5000);

        System.out.println("Returned to SmartSort Home Screen");
    }
}