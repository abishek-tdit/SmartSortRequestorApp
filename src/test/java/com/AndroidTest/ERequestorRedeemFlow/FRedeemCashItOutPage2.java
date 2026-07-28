package com.AndroidTest.ERequestorRedeemFlow;

import Base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.List;

public class FRedeemCashItOutPage2 extends BasePage {

    //=========================================================
    // Constructor
    //=========================================================

    public FRedeemCashItOutPage2(AndroidDriver driver) {
        super(driver);
    }

    //=========================================================
    // Locators
    //=========================================================

    private final By redeemCashOutButton =
            AppiumBy.xpath(
                    "//android.view.View[@content-desc='Redeem & cash it out']/android.widget.Button");

    //=========================================================
    // Redeem Cash Out
    //=========================================================

    public void redeemPoints2() {

        log("========== REDEEM CASH OUT STARTED ==========");

        // Wait for page to load
        utility.delay(5);

        //=====================================================
        // Manual Swipe
        //=====================================================

        Dimension size = driver.manage().window().getSize();

        int startX = size.width / 2;
        int startY = (int) (size.height * 0.80);
        int endY = (int) (size.height * 0.30);

        PointerInput finger =
                new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(
                finger.createPointerMove(
                        Duration.ZERO,
                        PointerInput.Origin.viewport(),
                        startX,
                        startY));

        swipe.addAction(
                finger.createPointerDown(
                        PointerInput.MouseButton.LEFT.asArg()));

        swipe.addAction(
                finger.createPointerMove(
                        Duration.ofMillis(1000),
                        PointerInput.Origin.viewport(),
                        startX,
                        endY));

        swipe.addAction(
                finger.createPointerUp(
                        PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(swipe));

        log("Page Scrolled");

        utility.delay(3);

        //=====================================================
        // Click Redeem & Cash It Out
        //=====================================================

        waitClickable(redeemCashOutButton);

        click(redeemCashOutButton);

        log("Clicked 'Redeem & Cash It Out'");

        log("========== REDEEM CASH OUT COMPLETED ==========");
    }
}