package com.AndroidTest.ERequestorRedeemFlow;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GProcessRedeemPointsConvertToCashPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public GProcessRedeemPointsConvertToCashPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    //CLICK PROCEED TO REDEEM POINTS + CHECKBOX
    public void proceedToRedeemPointsAndSelectCheckbox() throws InterruptedException {

        // CLICK PROCEED TO REDEEM POINTS
        WebElement proceedBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Proceed to Redeem Points"))
        );

        proceedBtn.click();
        System.out.println("Proceed to Redeem Points clicked");

        // WAIT AFTER CLICK
        Thread.sleep(2000);

        // CLICK CHECKBOX
        WebElement checkBox = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.className("android.widget.CheckBox"))
        );

        checkBox.click();
        System.out.println("Checkbox selected");

        // WAIT AFTER CHECKBOX CLICK
        Thread.sleep(3000);
    }

    //CLICK CONVERT TO CASH
    public void clickConvertToCash() throws InterruptedException {

        WebElement convertButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Convert to cash")
                )
        );

        convertButton.click();
        System.out.println("Convert to Cash clicked");
        Thread.sleep(3000);
    }


    public void selectSAR10Points() {

        WebElement sarPoints = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.view.View[@content-desc='SAR 10\nPoints 200.0']")
                )
        );

        sarPoints.click();
        System.out.println("✅ SAR 10 Points selected");
    }

    //SELECT BANK TRANSFER OPTION
    public void selectBankTransfer() {

        WebElement bankTransfer = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Bank Transfer (IBAN, Beneficiary Name, BIC Code)")
                )
        );

        bankTransfer.click();
        System.out.println("✅ Bank Transfer option selected");
    }


    //---------This step only for 1st time -------//
//     //STEP 4: ENTER MIDDLE NAME
//    public void enterMiddleName(String middleNameValue) {
//
//        WebElement middleName = wait.until(
//                ExpectedConditions.visibilityOfElementLocated(
//                        AppiumBy.className("android.widget.EditText")
//                )
//        );
//
//        middleName.click();
//        middleName.clear();
//        middleName.sendKeys(middleNameValue);
//
//        System.out.println("Middle Name entered: " + middleNameValue);
//    }
//
//    //COMPLETE FLOW METHOD (CALL THIS)
//    public void completeConvertToCashFlow() {
//
//        clickConvertToCash();
//        selectSAR10Points();
//        selectBankTransfer();
//        enterMiddleName("raman");
//
//        System.out.println("✅ Convert to Cash flow completed");
//    }
//----------------------------------------------------------------------------------


    public void clickProceed() {

        try {
            driver.hideKeyboard(); // hide keyboard
            System.out.println("Keyboard hidden");
        } catch (Exception e) {
            System.out.println("Keyboard not visible");
        }

        WebElement proceedBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Proceed")
                )
        );

        proceedBtn.click();
        System.out.println("Proceed button clicked");
    }

    public void clickConfirm() {

        WebElement confirmBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Confirm")
                )
        );

        confirmBtn.click();
        System.out.println("Confirm button clicked");
    }

    public void clickOkPopup() throws InterruptedException {

        WebElement okBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("OK")
                )
        );

        okBtn.click();
        System.out.println("OK popup clicked");
        Thread.sleep(10000);
    }

}
