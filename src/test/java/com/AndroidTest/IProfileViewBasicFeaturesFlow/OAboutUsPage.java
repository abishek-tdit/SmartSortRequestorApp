package com.AndroidTest.IProfileViewBasicFeaturesFlow;

import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OAboutUsPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public OAboutUsPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickAboutUs() throws InterruptedException {
        wait.until(driver -> true);
        // Click About Us
        WebElement aboutUs = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("About Us"))
        );

        aboutUs.click();

        ExtentTestListener.logStep("About Us Clicked");

        // Wait for page to open
        Thread.sleep(2000);

        // Navigate Back
        driver.navigate().back();

        ExtentTestListener.logStep("Navigated Back from About Us");
    }
}