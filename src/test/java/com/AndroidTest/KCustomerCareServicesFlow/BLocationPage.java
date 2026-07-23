package com.AndroidTest.KCustomerCareServicesFlow;
import Base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class BLocationPage extends BasePage {

    //=========================================================
    // Constructor
    //=========================================================

    public BLocationPage(AndroidDriver driver) {
        super(driver);
    }

    //=========================================================
    // Locators
    //=========================================================

    private final By exploreLocationsBtn =
            AppiumBy.accessibilityId("Explore Other Locations");

    private final By bqaiqLocation =
            AppiumBy.accessibilityId("Bqaiq");

    //=========================================================
    // Select Location
    //=========================================================

    public void selectLocation() throws InterruptedException {

        log("========== LOCATION SELECTION STARTED ==========");

        // Wait for Home Screen
        waitVisible(exploreLocationsBtn);

        // Click Explore Other Locations
        click(exploreLocationsBtn);
        log("Clicked 'Explore Other Locations'");

        // Wait for Location List
        waitClickable(bqaiqLocation);

        // Select Bqaiq
        click(bqaiqLocation);
        log("Selected Location : Bqaiq");

        log("========== LOCATION SELECTION COMPLETED ==========");

    }
}