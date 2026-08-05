package com.AndroidTest.DRequestorRedeemFlow;

import Base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class HProcessRedeemPointsConvertToCashPage extends BasePage {

    //=========================================================
    // Constructor
    //=========================================================

    public HProcessRedeemPointsConvertToCashPage(AndroidDriver driver) {
        super(driver);
    }

    //=========================================================
    // Locators
    //=========================================================

    private final By proceedRedeemBtn =
            AppiumBy.accessibilityId("Proceed to Redeem Points");

    private final By checkBox =
            AppiumBy.className("android.widget.CheckBox");

    private final By convertToCashBtn =
            AppiumBy.accessibilityId("Convert to cash");

    private final By sar10Points =
            AppiumBy.xpath("//android.view.View[@content-desc='SAR 10\nPoints 200.0']");

    private final By bankTransfer =
            AppiumBy.accessibilityId(
                    "Bank Transfer (IBAN, Beneficiary Name, BIC Code)");

    private final By proceedBtn =
            AppiumBy.accessibilityId("Proceed");

    private final By confirmBtn =
            AppiumBy.accessibilityId("Confirm");

    private final By okBtn =
            AppiumBy.accessibilityId("OK");

    //=========================================================
    // Proceed To Redeem Points
    //=========================================================

    public void proceedToRedeemPointsAndSelectCheckbox() {

        log("========== PROCEED TO REDEEM ==========");

        click(proceedRedeemBtn);
        log("Clicked Proceed to Redeem Points");

        // Checkbox
        click(checkBox);
        log("Checkbox Selected");
    }

    //=========================================================
    // Convert To Cash
    //=========================================================

    public void clickConvertToCash() {

        click(convertToCashBtn);

        log("Clicked Convert To Cash");
    }

    //=========================================================
    // Select SAR 10
    //=========================================================

    public void selectSAR10Points() {

        click(sar10Points);

        log("Selected SAR 10 Points");
    }

    //=========================================================
    // Select Bank Transfer
    //=========================================================

    public void selectBankTransfer() {

        click(bankTransfer);

        log("Selected Bank Transfer");
    }

    //=========================================================
    // Proceed
    //=========================================================

    public void clickProceed() {

        hideKeyboard();

        click(proceedBtn);

        log("Clicked Proceed");
    }

    //=========================================================
    // Confirm
    //=========================================================

    public void clickConfirm() {

        click(confirmBtn);

        log("Clicked Confirm");
    }

    //=========================================================
    // OK Popup
    //=========================================================

    public void clickOkPopup() {

        click(okBtn);

        log("Clicked OK Popup");

        log("========== CONVERT TO CASH COMPLETED ==========");
    }

}