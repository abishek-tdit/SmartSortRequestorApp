package com.AndroidTest.JProfileViewBasicFeaturesFlow;

import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HLocationPage {
    AndroidDriver driver;
    WebDriverWait wait;

    public HLocationPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public void selectLocation() throws Exception {

        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement exploreBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Explore Other Locations")
                )
        );

        exploreBtn.click();

        ExtentTestListener.logStep("Explore Other Locations clicked");

        Thread.sleep(2000);

        WebElement locationBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Bqaiq")
                )
        );

        locationBtn.click();

        ExtentTestListener.logStep("Location Selected : Bqaiq");

        if (ExtentTestListener.getTest() != null) {
            ExtentTestListener.getTest().pass("Selected Location: Bqaiq");
        }

        Thread.sleep(3000);
    }
}
