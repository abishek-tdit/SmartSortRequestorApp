package com.AndroidTest.DRequestorRedeemFlow;

import Base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class JRedeemCashItOutPage3 extends BasePage {

    //=========================================================
    // Constructor
    //=========================================================

    public JRedeemCashItOutPage3(AndroidDriver driver) {
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

    public void redeemPoints3() throws InterruptedException {

        log("========== REDEEM CASH OUT STARTED ==========");

        Thread.sleep(6000);

        // Scroll until Redeem & Cash Out is visible
        boolean found = false;

        for (int i = 0; i < 8; i++) {

            if (!driver.findElements(REDEEM_CASH_OUT).isEmpty()) {
                found = true;
                log("Redeem & Cash Out button found");
                break;
            }

            driver.findElement(
                    AppiumBy.androidUIAutomator(
                            "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));

            log("Small scroll performed");
        }

        if (!found) {
            throw new RuntimeException("Redeem & Cash Out button not found after scrolling.");
        }

        waitClickable(REDEEM_CASH_OUT);
        click(REDEEM_CASH_OUT);

        log("Clicked 'Redeem & Cash It Out'");
        log("========== REDEEM CASH OUT COMPLETED ==========");
    }
}