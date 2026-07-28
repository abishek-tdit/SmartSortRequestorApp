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

public class HVoucherPage extends BasePage {

    //=========================================================
    // Constructor
    //=========================================================

    public HVoucherPage(AndroidDriver driver) {
        super(driver);
    }

    //=========================================================
    // Locators
    //=========================================================

    private final By exploreLocationsBtn =
            AppiumBy.accessibilityId("Explore Other Locations");

    private final By bqaiqLocation =
            AppiumBy.accessibilityId("Bqaiq");

    private final By redeemCashOutBtn =
            AppiumBy.xpath("//android.view.View[@content-desc='Redeem & cash it out']/android.widget.Button");

    private final By proceedRedeemBtn =
            AppiumBy.accessibilityId("Proceed to Redeem Points");

    private final By voucherBtn =
            AppiumBy.accessibilityId("Voucher");

    private final By checkBox =
            AppiumBy.className("android.widget.CheckBox");

    private final By pointsField =
            AppiumBy.className("android.widget.EditText");

    private final By redeemVoucherBtn =
            AppiumBy.accessibilityId("Redeem Voucher");

    private final By okBtn =
            AppiumBy.accessibilityId("OK");

    //=========================================================
    // Explore Other Locations
    //=========================================================

    public void clickExploreLocations() {

        click(exploreLocationsBtn);

        log("Clicked Explore Other Locations");
    }

    //=========================================================
    // Select Bqaiq
    //=========================================================

    public void selectBqaiqLocation() {

        click(bqaiqLocation);

        log("Selected Bqaiq Location");

        // Wait until Home page loads
        utility.delay(8);
    }

    //=========================================================
    // Scroll & Click Redeem Cash Out
    //=========================================================

    public void scrollAndClickRedeemCashOut() {

        log("Scrolling to Redeem & Cash It Out");

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

        waitClickable(redeemCashOutBtn);

        click(redeemCashOutBtn);

        log("Clicked Redeem & Cash It Out");
    }

    //=========================================================
    // Proceed To Redeem Points
    //=========================================================

    public void clickProceedToRedeemPoints() {

        click(proceedRedeemBtn);

        log("Clicked Proceed To Redeem Points");
    }

    //=========================================================
    // Voucher
    //=========================================================

    public void clickVoucher() {

        click(voucherBtn);

        log("Selected Voucher");
    }

    //=========================================================
    // Checkbox
    //=========================================================

    public void clickCheckbox() {

        click(checkBox);

        log("Checkbox Selected");
    }

    //=========================================================
    // Enter Points
    //=========================================================

    public void enterPoints(String points) {

        sendKeys(pointsField, points);

        log("Entered Points : " + points);
    }

    //=========================================================
    // Hide Keyboard
    //=========================================================

    public void hideKeyboardIfVisible() {

        hideKeyboard();

        log("Keyboard Hidden");
    }

    //=========================================================
    // Redeem Voucher
    //=========================================================

    public void clickRedeemVoucher() {

        click(redeemVoucherBtn);

        log("Clicked Redeem Voucher");
    }

    //=========================================================
    // OK Popup
    //=========================================================

    public void clickOkPopup() {

        click(okBtn);

        log("Clicked OK Popup");

        log("========== VOUCHER FLOW COMPLETED ==========");
    }
}