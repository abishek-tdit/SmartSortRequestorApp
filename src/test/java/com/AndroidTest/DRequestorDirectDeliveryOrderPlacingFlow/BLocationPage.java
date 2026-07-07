package com.AndroidTest.DRequestorDirectDeliveryOrderPlacingFlow;

import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BLocationPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public BLocationPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public void selectLocation() throws Exception {

        Thread.sleep(3000);

        WebElement exploreBtn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.accessibilityId("Explore Other Locations")
                )
        );

        exploreBtn.click();

        Thread.sleep(2000);

        WebElement locationBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Bqaiq")
                )
        );

        locationBtn.click();

        System.out.println("Location Selected : Bqaiq");

        if (ExtentTestListener.getTest() != null) {
            ExtentTestListener.getTest().pass("Selected Location: Bqaiq");
        }

        Thread.sleep(3000);
    }
}