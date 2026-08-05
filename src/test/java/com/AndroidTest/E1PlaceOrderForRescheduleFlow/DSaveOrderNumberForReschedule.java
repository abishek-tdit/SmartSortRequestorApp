package com.AndroidTest.E1PlaceOrderForRescheduleFlow;

import Base.BasePage;
import Base.ExtentTestListener;
import Utility.BOrderDataReschedule;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DSaveOrderNumberForReschedule extends BasePage {

    //=========================================================
    // Constructor
    //=========================================================

    public DSaveOrderNumberForReschedule(AndroidDriver driver) {
        super(driver);
    }

    //=========================================================
    // Click Orders and Save First Visible Order Number
    //=========================================================

    public void saveRecentlyPlacedOrderNumber() {

        // Click Orders
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Orders"))).click();

        ExtentTestListener.logStep("Orders page opened successfully.");

        // First visible order
        By firstOrder = By.xpath("(//android.widget.ImageView[contains(@content-desc,'AB-RO-')])[1]");

        WebElement order = wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstOrder));

        String description = order.getAttribute("content-desc");

        // Extract Order Number (AB-RO-xxxxx)
        Pattern pattern = Pattern.compile("AB-RO-\\d+");
        Matcher matcher = pattern.matcher(description);

        if (matcher.find()) {

            BOrderDataReschedule.orderNumberReschedule = matcher.group();

            System.out.println("Saved Order Number : " + BOrderDataReschedule.orderNumberReschedule);

            ExtentTestListener.logStep(
                    "Order Number Saved : " + BOrderDataReschedule.orderNumberReschedule);

        } else {

            throw new RuntimeException("Order number not found in : " + description);
        }

        // Go back to previous screen
        driver.navigate().back();

        ExtentTestListener.logStep("Navigated back successfully.");
    }
}