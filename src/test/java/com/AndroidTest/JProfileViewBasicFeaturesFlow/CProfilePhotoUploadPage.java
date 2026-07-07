package com.AndroidTest.JProfileViewBasicFeaturesFlow;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class CProfilePhotoUploadPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public CProfilePhotoUploadPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public void clickViewProfile() {

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("View Profile"))).click();

        System.out.println("View Profile Clicked");
    }

    public void uploadProfilePhoto() throws Exception {

        // Click Upload Icon
        WebElement uploadIcon = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        AppiumBy.xpath("//android.widget.ScrollView/android.view.View[1]")));

        driver.executeScript("mobile: clickGesture",
                Map.of("elementId", ((RemoteWebElement) uploadIcon).getId()));

        System.out.println("Upload icon tapped");

        // Click Gallery
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Gallery"))).click();

        System.out.println("Gallery Clicked");

        // Select image manually
        System.out.println("Please select image manually from Gallery...");
        Thread.sleep(10000);

        // Bring SmartSort app back to the foreground
        driver.activateApp("com.abqaiq.smartsort");

        System.out.println("Returned to SmartSort App");

        // Wait until the Done button is available
        WebElement doneButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath(
                                "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[6]/android.view.View/android.view.View[3]/android.widget.Button")));

        doneButton.click();

        System.out.println("Done Button Clicked");

        // Click OK
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("OK"))).click();

        System.out.println("OK Popup Clicked");

        Thread.sleep(4000);
        // Wait until profile screen is loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("View Profile")));

        System.out.println("Profile Photo Uploaded Successfully");
    }
}