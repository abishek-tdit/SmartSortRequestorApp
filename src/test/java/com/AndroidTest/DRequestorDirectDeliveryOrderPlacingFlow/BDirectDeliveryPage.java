package com.AndroidTest.DRequestorDirectDeliveryOrderPlacingFlow;

import Base.BasePage;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;
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
            AppiumBy.accessibilityId("Mixed Materials *");

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
                                    + ".setSwipeDeadZonePercentage(0.3)"
                                    + ".scrollForward()"));

            ExtentTestListener.logStep("Half-like scroll done");

            // Swipe Left
            Dimension size = driver.manage().window().getSize();

            int startX = (int) (size.width * 0.85);
            int endX = (int) (size.width * 0.15);
            int y = (int) (size.height * 0.60);

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

            Sequence swipe = new Sequence(finger, 1);

            swipe.addAction(finger.createPointerMove(
                    Duration.ZERO,
                    PointerInput.Origin.viewport(),
                    startX,
                    y));

            swipe.addAction(
                    finger.createPointerDown(
                            PointerInput.MouseButton.LEFT.asArg()));

            swipe.addAction(finger.createPointerMove(
                    Duration.ofMillis(700),
                    PointerInput.Origin.viewport(),
                    endX,
                    y));

            swipe.addAction(
                    finger.createPointerUp(
                            PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Collections.singletonList(swipe));

            ExtentTestListener.logStep("Swiped Left");

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

            // Scroll Down
            driver.findElement(
                    AppiumBy.androidUIAutomator(
                            "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));

            ExtentTestListener.logStep("Page Scrolled");

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