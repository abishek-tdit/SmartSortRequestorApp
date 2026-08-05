package com.AndroidTest.N2CollectorUtilityOrderCompleteFlow;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import Utility.DOrderDataReferEarn;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BRequestOrderROPage1 extends BaseClassMobile {

    public void openLatestRequestOrder() {

        //Click Request Orders
        ExtentTestListener.logStep("Navigating to Request Orders...");

        WebElement requestOrdersButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Request Orders (RO)")));
        requestOrdersButton.click();

        ExtentTestListener.logStep("Request Orders Clicked Successfully");

//=======================================================================================================//
        //Click ORDER NO(
//=======================================================================================================//
        String orderNumber = DOrderDataReferEarn.orderNumberReferEarn;
        try {
            WebElement order = driver.findElement(
                    AppiumBy.androidUIAutomator(
                            "new UiScrollable(new UiSelector().scrollable(true))"
                                    + ".scrollIntoView(new UiSelector().descriptionContains(\""
                                    + orderNumber + "\"))"));
            order.click();
            ExtentTestListener.logStep("Clicked Order : " + orderNumber);

        }
        catch (Exception e)
        {
            ExtentTestListener.logStep("Order not found : " + orderNumber);
        }
    }
}