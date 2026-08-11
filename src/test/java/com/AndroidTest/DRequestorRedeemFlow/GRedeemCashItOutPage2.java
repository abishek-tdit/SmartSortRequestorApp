package com.AndroidTest.DRequestorRedeemFlow;

import Base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

public class GRedeemCashItOutPage2 extends BasePage {

    //=========================================================
    // Constructor
    //=========================================================

    public GRedeemCashItOutPage2(AndroidDriver driver) {
        super(driver);
    }

    //=========================================================
    // Locators
    //=========================================================

    private final By REDEEM_CASH_OUT =
            AppiumBy.accessibilityId("Redeem & cash it out");

    //=========================================================
    // Redeem Cash Out
    //=========================================================

    public void redeemPoints2() {

        log("========== REDEEM CASH OUT STARTED ==========");

        boolean found = false;

        // Check current screen first
        if (!driver.findElements(REDEEM_CASH_OUT).isEmpty()) {
            found = true;
        }

        // Swipe until found
        while (!found) {

            swipeUp();

            if (!driver.findElements(REDEEM_CASH_OUT).isEmpty()) {
                found = true;
                break;
            }
        }

        waitClickable(REDEEM_CASH_OUT);
        click(REDEEM_CASH_OUT);

        log("Clicked 'Redeem & Cash It Out'");
        log("========== REDEEM CASH OUT COMPLETED ==========");
    }

    //=========================================================
    // Swipe Up
    //=========================================================

    private void swipeUp() {

        Dimension size = driver.manage().window().getSize();

        int startX = size.width / 2;
        int startY = (int) (size.height * 0.80);
        int endY = (int) (size.height * 0.30);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(
                Duration.ZERO,
                PointerInput.Origin.viewport(),
                startX,
                startY));

        swipe.addAction(finger.createPointerDown(
                PointerInput.MouseButton.LEFT.asArg()));

        swipe.addAction(finger.createPointerMove(
                Duration.ofMillis(500),
                PointerInput.Origin.viewport(),
                startX,
                endY));

        swipe.addAction(finger.createPointerUp(
                PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }
}