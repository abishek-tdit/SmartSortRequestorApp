package com.AndroidTest.N3VerifyReferralPointsFlow;

import Base.BasePage;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CApprovedReferralUsersPage extends BasePage {

    public CApprovedReferralUsersPage(AndroidDriver driver) {
        super(driver);
    }

    //=========================================================
    // Locator
    //=========================================================

    private final By REDEEM_CASH_OUT =
            AppiumBy.accessibilityId("Redeem & cash it out");

    // Redeem Cash Out
    public void clickRedeemCashOut() throws InterruptedException {

        ExtentTestListener.logStep("========== REDEEM CASH OUT STARTED ==========");

        boolean found = false;

        // Check current screen first
        if (!driver.findElements(REDEEM_CASH_OUT).isEmpty()) {
            found = true;
        }

        // Scroll until Redeem button is found
        while (!found) {

            utility.swipeUp(0.7);

            if (!driver.findElements(REDEEM_CASH_OUT).isEmpty()) {
                found = true;
                break;
            }
        }

        WebElement redeemButton = wait.until(
                ExpectedConditions.elementToBeClickable(REDEEM_CASH_OUT));

        redeemButton.click();

        ExtentTestListener.logStep("Clicked 'Redeem & Cash It Out'");

        ExtentTestListener.logStep("Wait for Approved Referral Users Page to Load");
        Thread.sleep(10000);
        //=========================================================
        // Approved Referral Users
        //=========================================================

        WebElement approvedReferralUsers = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Approved Referral Users")));

        approvedReferralUsers.click();

        ExtentTestListener.logStep("Approved Referral Users Clicked");

        Thread.sleep(5000);

        //=========================================================
        // Navigate Back
        //=========================================================

        driver.navigate().back();
        driver.navigate().back();

        ExtentTestListener.logStep("Navigated back successfully");

        ExtentTestListener.getTest().pass(
                "Approved Referral Users Page Verified Successfully");

        ExtentTestListener.logStep("========== REDEEM CASH OUT COMPLETED ==========");
    }
}