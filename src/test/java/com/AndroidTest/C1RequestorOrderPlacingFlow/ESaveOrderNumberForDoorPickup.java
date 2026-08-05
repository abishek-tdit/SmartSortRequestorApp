package com.AndroidTest.C1RequestorOrderPlacingFlow;

import Base.BasePage;
import Base.ExtentTestListener;
import Utility.AOrderDataDoorPickup;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ESaveOrderNumberForDoorPickup extends BasePage {

    //=========================================================
    // Constructor
    //=========================================================

    public ESaveOrderNumberForDoorPickup(AndroidDriver driver) {
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

            AOrderDataDoorPickup.orderNumberDoorPickup = matcher.group();

            System.out.println("Saved Order Number : " + AOrderDataDoorPickup.orderNumberDoorPickup);

            ExtentTestListener.logStep(
                    "Order Number Saved : " + AOrderDataDoorPickup.orderNumberDoorPickup);
        }
        else
        {
            throw new RuntimeException("Order number not found in : " + description);
        }
        // Go back to previous screen
        driver.navigate().back();

        ExtentTestListener.logStep("Navigated back successfully.");
    }
}