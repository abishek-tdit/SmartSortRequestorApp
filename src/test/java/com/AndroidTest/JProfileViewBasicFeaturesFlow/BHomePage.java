package com.AndroidTest.JProfileViewBasicFeaturesFlow;

import Base.BasePage;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BHomePage extends BasePage {

    //=========================================================
    // Constructor
    //=========================================================

    public BHomePage(AndroidDriver driver) {
        super(driver);
    }

    //=========================================================
    // Locators
    //=========================================================

    private final By profileIcon = AppiumBy.xpath(
            "//android.widget.FrameLayout[@resource-id='android:id/content']" +
                    "/android.widget.FrameLayout/android.widget.FrameLayout" +
                    "/android.view.View/android.view.View/android.view.View" +
                    "/android.view.View/android.view.View[1]" +
                    "/android.view.View/android.widget.ImageView[1]"
    );

    //=========================================================
    // Click Profile Icon
    //=========================================================

    public void clickProfileIcon() {

        wait.until(ExpectedConditions.elementToBeClickable(profileIcon))
                .click();

        ExtentTestListener.logStep("Profile Icon Clicked");

        if (ExtentTestListener.getTest() != null) {
            ExtentTestListener.getTest().pass("Clicked Profile Icon");
        }
    }
}