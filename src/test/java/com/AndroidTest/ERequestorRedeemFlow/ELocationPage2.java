package com.AndroidTest.ERequestorRedeemFlow;

import Base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ELocationPage2 extends BasePage {

    //=========================================================
    // Constructor
    //=========================================================

    public ELocationPage2(AndroidDriver driver) {
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

    public void selectLocation2() {

        log("========== LOCATION 2 SELECTION STARTED ==========");

        // Wait until Home Page is Ready
        waitVisible(exploreOtherLocationsButton);

        // Click Explore Other Locations
        click(exploreOtherLocationsButton);
        log("Clicked 'Explore Other Locations'");

        // Wait until Location List Appears
        waitVisible(bqaiqLocation);

        // Select Bqaiq
        click(bqaiqLocation);
        log("Selected Location : Bqaiq");

        log("========== LOCATION 2 SELECTION COMPLETED ==========");
    }
}