package com.AndroidTest.O1ReferAndEarnFlow;

import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utility.MobileUtility;
import java.time.Duration;
import java.util.Map;

public class AReferAndEarnPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public AReferAndEarnPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Refer & Earn Card
    private final By referAndEarn = AppiumBy.xpath(
            "//android.widget.ImageView[@content-desc='Refer & Earn\nRefer Smart-Sort with your friend and earn points.']");

    // Tap to Copy
    private final By tapToCopy = AppiumBy.xpath(
            "//android.view.View[contains(@content-desc,'Tap to copy')]");

    /**
     * Scroll down a little
     */
    public void scrollDownLittle() {

        driver.executeScript("mobile: scrollGesture",
                Map.of(
                        "left", 50,
                        "top", 350,
                        "width", 620,
                        "height", 900,
                        "direction", "down",
                        "percent", 0.35));

        ExtentTestListener.logStep("Scrolled down");
    }

    /**
     * Click Refer & Earn
     */
    public void clickReferAndEarn() {

        wait.until(ExpectedConditions.elementToBeClickable(referAndEarn)).click();

        ExtentTestListener.logStep("Refer & Earn clicked");
    }

    /**
     * Click Tap to Copy
     */
    public void clickTapToCopy() {

        wait.until(ExpectedConditions.elementToBeClickable(tapToCopy)).click();

        MobileUtility.referralCode = driver.getClipboardText();

        ExtentTestListener.logStep("Referral code copied : " + MobileUtility.referralCode);
    }

    /**
     * Navigate Back
     */
    public void navigateBack() {

        driver.navigate().back();

        ExtentTestListener.logStep("Navigated back");
    }
}