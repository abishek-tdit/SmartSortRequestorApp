package com.AndroidTest.DRequestorRedeemFlow;

import Base.BasePage;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DBusinessPointHistoryPage extends BasePage {

    public DBusinessPointHistoryPage(AndroidDriver driver) {
        super(driver);
    }

    //=========================================================
    // Locator
    //=========================================================

    private final By businessPointHistory =
            AppiumBy.accessibilityId("Business Point History");

    private final By startDate =
            AppiumBy.accessibilityId("2026-07-12");

    private final By nextMonth =
            AppiumBy.accessibilityId("Next month");

    private final By startDay =
            AppiumBy.xpath("//android.widget.Button[starts-with(@content-desc,'1,')]");

    private final By endDate =
            AppiumBy.accessibilityId("2026-08-11");

    private final By endDay =
            AppiumBy.accessibilityId("11, Tuesday, August 11, 2026, Today");

    private final By okButton =
            AppiumBy.accessibilityId("OK");

    private final By filteredRecord =
            AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc,'Request Date:')]");

    //=========================================================
    // Business Point History
    //=========================================================

    public void openBusinessPointHistory() {

        WebElement history = wait.until(
                ExpectedConditions.elementToBeClickable(businessPointHistory));

        history.click();

        ExtentTestListener.logStep("Business Point History Clicked");
    }

    public void filterBusinessHistory() {

        // Start Date
        wait.until(ExpectedConditions.elementToBeClickable(startDate)).click();

        ExtentTestListener.logStep("Start Date field clicked");

        // Click Next Month
        wait.until(ExpectedConditions.elementToBeClickable(nextMonth)).click();

        ExtentTestListener.logStep("Next Month clicked");

        wait.until(ExpectedConditions.elementToBeClickable(startDay)).click();

        ExtentTestListener.logStep("Start Date selected");

        wait.until(ExpectedConditions.elementToBeClickable(okButton)).click();

        ExtentTestListener.logStep("Start Date confirmed");

        // End Date
        wait.until(ExpectedConditions.elementToBeClickable(endDate)).click();

        ExtentTestListener.logStep("End Date field clicked");

        wait.until(ExpectedConditions.elementToBeClickable(endDay)).click();

        ExtentTestListener.logStep("End Date selected");

        wait.until(ExpectedConditions.elementToBeClickable(okButton)).click();

        ExtentTestListener.logStep("End Date confirmed");


        // Validate Filter
        WebElement record = wait.until(
                ExpectedConditions.visibilityOfElementLocated(filteredRecord));

        String recordText = record.getAttribute("contentDescription");

        System.out.println("======================================");
        System.out.println("Filtered Record:");
        System.out.println(recordText);
        System.out.println("======================================");

        if (record.isDisplayed()) {

            System.out.println("Filter Verification : PASSED");

            ExtentTestListener.logStep("Business History filtered successfully");

            ExtentTestListener.getTest().pass("Business History filter validated successfully");
            driver.navigate().back();
        } else {

            System.out.println("Filter Verification : FAILED");

            throw new RuntimeException("Business History filter validation failed");

        }
    }
}