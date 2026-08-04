package com.AndroidTest.ERequestorRedeemFlow;

import Base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class BALocationPage1 extends BasePage {

    //=========================================================
    // Constructor
    //=========================================================

    public BALocationPage1(AndroidDriver driver) {
        super(driver);
    }

    //=========================================================
    // Locators
    //=========================================================

    private final By exploreOtherLocationsButton =
            AppiumBy.accessibilityId("Explore Other Locations");

    private final By bqaiqLocation =
            AppiumBy.accessibilityId("Bqaiq");

    //=========================================================
    // Select Location
    //=========================================================

    public void selectLocation1() {

        log("========== LOCATION SELECTION STARTED ==========");

        // Wait for Home Screen
        waitVisible(exploreOtherLocationsButton);

        // Click Explore Other Locations
        click(exploreOtherLocationsButton);
        log("Clicked 'Explore Other Locations'");

        // Wait until location list appears
        waitVisible(bqaiqLocation);

        // Select Bqaiq
        click(bqaiqLocation);
        log("Selected Location : Bqaiq");


        log("========== LOCATION SELECTION COMPLETED ==========");
    }

}