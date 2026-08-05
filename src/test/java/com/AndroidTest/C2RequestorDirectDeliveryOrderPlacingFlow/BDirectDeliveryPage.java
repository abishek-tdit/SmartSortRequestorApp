package com.AndroidTest.C2RequestorDirectDeliveryOrderPlacingFlow;

import Base.BasePage;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.Map;

public class BDirectDeliveryPage extends BasePage {

    //=========================================================
    // Constructor
    //=========================================================

    public BDirectDeliveryPage(AndroidDriver driver) {
        super(driver);
    }

    //=========================================================
    // Locators
    //=========================================================

    private final By DIRECT_DELIVERY =
            AppiumBy.accessibilityId(
                    "Direct Delivery\nSubmit materials directly to Collection Center");

    private final By SELECT_COLLECTION_CENTER =
            AppiumBy.xpath("//android.widget.Button[contains(@content-desc,'Select Collection Centre')]");
    private final By TTF_CENTER =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().descriptionContains(\"TTFVaasan\")");

    private final By MIXED_MATERIALS =
            AppiumBy.xpath("//android.widget.CheckBox[@content-desc='Mixed Materials *']");

    private final By CONFIRM_CHECKBOX =
            AppiumBy.accessibilityId(
                    "I confirm that my request contains only the accepted materials and meets the above conditions *");

    //=========================================================
    // Direct Delivery
    //=========================================================

    public void clickDirectDelivery() {

        try {

            // Scroll
            driver.findElement(
                    AppiumBy.androidUIAutomator(
                            "new UiScrollable(new UiSelector().scrollable(true))"
                                    + ".setAsVerticalList()"
                                    + ".setSwipeDeadZonePercentage(0.2)"
                                    + ".scrollForward()"));

            ExtentTestListener.logStep("scroll down");


            // Direct Delivery
            click(DIRECT_DELIVERY);

            ExtentTestListener.logStep("Direct Delivery Clicked");
            Thread.sleep(4000);
            // Collection Centre
            click(SELECT_COLLECTION_CENTER);

            ExtentTestListener.logStep("Select Collection Center Clicked");

            // Select Centre
            click(TTF_CENTER);

            ExtentTestListener.logStep("TTFVaasan Selected");

            //scroll down
            scrollDown();

            // Mixed Materials
            click(MIXED_MATERIALS);

            ExtentTestListener.logStep("Mixed Materials Checked");

            // Swipe Up
            driver.executeScript(
                    "mobile: swipeGesture",
                    Map.of(
                            "left", 100,
                            "top", 400,
                            "width", 500,
                            "height", 800,
                            "direction", "up",
                            "percent", 0.75));

            // Final Checkbox
            click(CONFIRM_CHECKBOX);

            ExtentTestListener.logStep("Confirmation Checkbox Clicked");

        }
        catch (Exception e) {

            ExtentTestListener.logStep("Failed to click Direct Delivery");

            throw new RuntimeException(e);
        }
    }
}