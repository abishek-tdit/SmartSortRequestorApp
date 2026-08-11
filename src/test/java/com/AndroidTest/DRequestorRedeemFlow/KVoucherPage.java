package com.AndroidTest.DRequestorRedeemFlow;

import Base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class KVoucherPage extends BasePage {

    //=========================================================
    // Constructor
    //=========================================================

    public KVoucherPage(AndroidDriver driver) {
        super(driver);
    }

    //=========================================================
    // Locators
    //=========================================================

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