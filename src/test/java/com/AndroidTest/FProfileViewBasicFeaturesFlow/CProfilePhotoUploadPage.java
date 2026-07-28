package com.AndroidTest.FProfileViewBasicFeaturesFlow;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CProfilePhotoUploadPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public CProfilePhotoUploadPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickViewProfile() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("View Profile")
        )).click();

        System.out.println("View Profile Clicked");

        Thread.sleep(3000);
    }

    public void uploadProfilePhoto() throws InterruptedException {

        // Click Profile Photo
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath(
                        "//android.widget.ScrollView/android.view.View[1]"
                )
        )).click();

        System.out.println("Profile Photo Clicked");

        Thread.sleep(2000);


        // Click Gallery
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Gallery")
        )).click();

        System.out.println("Gallery Clicked");


        // Select image manually
        System.out.println("Please select image manually...");
        Thread.sleep(20000);


        // Click Done
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath(
                        "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[6]/android.view.View/android.view.View[3]/android.widget.Button"
                )
        )).click();

        System.out.println("Done Button Clicked");

        Thread.sleep(5000);


        // Click OK Popup
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("OK")
        )).click();

        System.out.println("OK Popup Clicked");

        Thread.sleep(6000);

        System.out.println("Profile Photo");
    }
}