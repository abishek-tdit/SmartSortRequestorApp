package com.AndroidTest.O3VerifyReferralPointsFlow;

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

    private final By redeemCashOutButton =
            AppiumBy.xpath("//*[@content-desc='Redeem & cash it out']");

    //=========================================================
    // Redeem Cash Out
    //=========================================================

    public void clickRedeemCashOut() throws InterruptedException {

        ExtentTestListener.logStep("========== REDEEM CASH OUT STARTED ==========");

        boolean isFound = false;

        // Scroll until Redeem button appears
        for (int i = 0; i < 5; i++) {

            if (!driver.findElements(redeemCashOutButton).isEmpty()) {

                isFound = true;
                ExtentTestListener.logStep("Redeem & Cash Out button found");
                break;
            }

            utility.swipeUp(0.7);
            ExtentTestListener.logStep("Scrolling down...");
        }

        if (!isFound) {
            throw new RuntimeException(
                    "Redeem & Cash Out button not found after scrolling");
        }

        WebElement redeemButton = wait.until(
                ExpectedConditions.elementToBeClickable(redeemCashOutButton));

        redeemButton.click();

        ExtentTestListener.logStep("Clicked 'Redeem & Cash It Out'");
//=========================================================
// Approved Referral Users
//=========================================================

        WebElement approvedReferralUsers = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Approved Referral Users")));

        approvedReferralUsers.click();

        ExtentTestListener.logStep("Approved Referral Users Clicked");

// Wait for page to load
        Thread.sleep(5000);

// Navigate Back
        driver.navigate().back();
        driver.navigate().back();

        ExtentTestListener.getTest().pass("Approved Referral Users Page Verified Successfully");
    }
}