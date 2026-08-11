package com.AndroidTest.N1ReferAndEarnFlow;

import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utility.MobileUtility;
import java.time.Duration;

public class A2ReferAndEarnPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public A2ReferAndEarnPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    // Refer & Earn
    private final By referAndEarn = AppiumBy.accessibilityId("Refer Earn");

    // Tap to Copy
    private final By tapToCopy = AppiumBy.xpath(
            "//android.view.View[contains(@content-desc,'Tap to copy')]");


     //Click Refer & Earn
    public void clickReferAndEarn() {

        WebElement referCard = wait.until(
                ExpectedConditions.elementToBeClickable(referAndEarn));

        referCard.click();

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