package com.AndroidTest.C3CollectorUtilityOrderCompleteFlow;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

public class HLogoutPage extends BaseClassMobile {

    AndroidDriver driver;

    public HLogoutPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void clearStorage() throws Exception {

        // Click PROFILE
        WebElement profile = waitUntilClickable(
                AppiumBy.accessibilityId("PROFILE"), 20);

        profile.click();
        ExtentTestListener.logStep("Clicked PROFILE");


        // Scroll till Logout from Device is visible
        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))"
                                + ".scrollIntoView(new UiSelector().description(\"Logout from Device\"))"));

        ExtentTestListener.logStep("Scrolled to Logout from Device");

        // Click Logout from Device
        WebElement logoutFromDevice = waitUntilClickable(
                AppiumBy.accessibilityId("Logout from Device"), 20);

        logoutFromDevice.click();

        ExtentTestListener.logStep("Clicked Logout from Device");

        // Click Logout on popup
        driver.executeScript(
                "mobile: clickGesture",
                Map.of(
                        "x", 560,
                        "y", 924));

        ExtentTestListener.logStep("Logout popup clicked");

    }
}