package com.AndroidTest.N1ReferAndEarnFlow;

import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BLogoutPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public BLogoutPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Profile Icon
    private final By profileIcon = AppiumBy.xpath(
            "//android.widget.FrameLayout[@resource-id='android:id/content']" +
                    "/android.widget.FrameLayout/android.widget.FrameLayout" +
                    "/android.view.View/android.view.View/android.view.View" +
                    "/android.view.View/android.view.View[1]" +
                    "/android.view.View/android.widget.ImageView[1]"
    );

    // Logout
    private final By logoutButton = AppiumBy.accessibilityId("log out");

    // Yes Popup
    private final By yesButton = AppiumBy.accessibilityId("Yes");



    //Click Profile Icon
    public void clickProfileIcon() {

        wait.until(ExpectedConditions.elementToBeClickable(profileIcon)).click();

        ExtentTestListener.logStep("Profile Icon Clicked");
    }


    //Click Logout
    public void clickLogout() {

        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();

        ExtentTestListener.logStep("Logout Clicked");
    }


    //Click Yes Popup
    public void clickYes() {

        wait.until(ExpectedConditions.elementToBeClickable(yesButton)).click();

        ExtentTestListener.logStep("Logout Confirmation - Yes Clicked");
    }


    //complete Logout Flow

    public void logout() {

        clickProfileIcon();

        clickLogout();

        clickYes();

        ExtentTestListener.logStep("Logout Successful");
    }
}