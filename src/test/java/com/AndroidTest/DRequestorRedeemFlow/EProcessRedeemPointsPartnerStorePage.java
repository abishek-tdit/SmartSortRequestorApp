package com.AndroidTest.DRequestorRedeemFlow;

import Base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.List;

public class EProcessRedeemPointsPartnerStorePage extends BasePage {

    //=========================================================
    // Constructor
    //=========================================================

    public EProcessRedeemPointsPartnerStorePage(AndroidDriver driver) {
        super(driver);
    }

    //=========================================================
    // Locators
    //=========================================================

    private final By proceedRedeemBtn =
            AppiumBy.accessibilityId("Proceed to Redeem Points");

    private final By checkBox =
            AppiumBy.className("android.widget.CheckBox");

    private final By mostPopular =
            AppiumBy.accessibilityId("Most Popular");

    private final By searchBox =
            AppiumBy.className("android.widget.EditText");

    private final By redeemBtn =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().description(\"Redeem\").instance(1)");

    private final By redeemGiftBtn =
            AppiumBy.accessibilityId("Redeem Gift");

    private final By okBtn =
            AppiumBy.accessibilityId("OK");

    //=========================================================
    // Redeem Process
    //=========================================================

    public void proceedRedeem() {

        log("========== REDEEM PROCESS STARTED ==========");

        // Proceed Redeem
        click(proceedRedeemBtn);
        log("Clicked Proceed to Redeem Points");

        // Checkbox
        click(checkBox);
        log("Checkbox Selected");

        // Most Popular
        click(mostPopular);
        log("Clicked Most Popular");

        // Search Amazon
        sendKeys(searchBox, "Amazon");
        log("Entered Amazon");

        hideKeyboard();

        // Scroll
        utility.swipeUp(0.8);
        log("Scrolled Up");

        // Redeem Button
        waitVisible(redeemBtn);

        WebElement redeem = getElement(redeemBtn);

        int centerX = redeem.getRect().getX() +
                (redeem.getRect().getWidth() / 2);

        int centerY = redeem.getRect().getY() +
                (redeem.getRect().getHeight() / 2);

        PointerInput finger =
                new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence tap = new Sequence(finger, 1);

        tap.addAction(
                finger.createPointerMove(
                        Duration.ZERO,
                        PointerInput.Origin.viewport(),
                        centerX,
                        centerY));

        tap.addAction(
                finger.createPointerDown(
                        PointerInput.MouseButton.LEFT.asArg()));

        tap.addAction(
                finger.createPointerUp(
                        PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(tap));

        log("Redeem Button Clicked");

        // SAR Amount
        sendKeys(searchBox, "10");
        log("Entered SAR Amount");

        // Redeem Gift
        click(redeemGiftBtn);
        log("Clicked Redeem Gift");

        // OK Popup
        click(okBtn);
        log("Clicked OK");

        log("========== REDEEM PROCESS COMPLETED ==========");
    }

}