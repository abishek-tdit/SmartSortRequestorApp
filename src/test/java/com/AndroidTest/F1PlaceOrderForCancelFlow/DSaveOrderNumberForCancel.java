package com.AndroidTest.F1PlaceOrderForCancelFlow;

import Base.BasePage;
import Base.ExtentTestListener;
import Utility.COrderDataCancel;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DSaveOrderNumberForCancel extends BasePage {

    //=========================================================
    // Constructor
    //=========================================================

    public DSaveOrderNumberForCancel(AndroidDriver driver) {
        super(driver);
    }

    //=========================================================
    // Click Orders and Save First Visible Order Number
    //=========================================================

    public void SaveRecentlyPlacedOrderNumber() {

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

            COrderDataCancel.orderNumberCancel = matcher.group();

            System.out.println("Saved Order Number : " + COrderDataCancel.orderNumberCancel);

            ExtentTestListener.logStep(
                    "Order Number Saved : " + COrderDataCancel.orderNumberCancel);

        } else {

            throw new RuntimeException("Order number not found in : " + description);
        }

        // Go back to previous screen
        driver.navigate().back();

        ExtentTestListener.logStep("Navigated back successfully.");
    }
}