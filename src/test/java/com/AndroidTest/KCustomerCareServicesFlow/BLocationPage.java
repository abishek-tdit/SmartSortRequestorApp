package com.AndroidTest.KCustomerCareServicesFlow;

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
        Thread.sleep(5000);
    }
}
