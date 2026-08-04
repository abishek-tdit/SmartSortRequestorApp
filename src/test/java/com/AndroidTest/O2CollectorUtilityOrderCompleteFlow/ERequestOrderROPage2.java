package com.AndroidTest.O2CollectorUtilityOrderCompleteFlow;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import Utility.OrderData;
import Utility.OrderNumber;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import java.time.Duration;
import java.util.Collections;

public class ERequestOrderROPage2 extends BaseClassMobile {

    public void completeOrder() throws Exception {

        //Again Click Request Orders
        ExtentTestListener.logStep("Navigating to Request Orders...");

        WebElement requestOrdersButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Request Orders (RO)")));
        requestOrdersButton.click();

        ExtentTestListener.logStep("Request Orders Clicked Successfully");

//=======================================================================================================//
        // Click ORDER NO(change number for each order)
//=======================================================================================================//
        String orderNumber = OrderData.orderNumber;

        ExtentTestListener.logStep("Clicking Order : " + orderNumber);

        try {
            WebElement order = driver.findElement(
                    AppiumBy.androidUIAutomator(
                            "new UiScrollable(new UiSelector().scrollable(true))"
                                    + ".scrollIntoView(new UiSelector().descriptionContains(\""
                                    + orderNumber + "\"))"));

            wait.until(ExpectedConditions.elementToBeClickable(order)).click();

            ExtentTestListener.logStep("Order clicked successfully.");

        }
        catch (Exception e)
        {
            ExtentTestListener.logStep("Order not found : " + orderNumber);
        }

//==========================================================================================================//
//==========================================================================================================//
        // Check whether Proceed to complete is already visible
        boolean found = false;

        try {
            driver.findElement(AppiumBy.accessibilityId("Proceed to complete"));
            found = true;
        }
        catch (Exception ignored) {
        }

        while (!found) {

            ExtentTestListener.logStep("Scrolling...");

            Dimension size = driver.manage().window().getSize();

            int startX = size.width / 2;
            int startY = (int) (size.height * 0.80);
            int endY = (int) (size.height * 0.30);

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

            Sequence swipe = new Sequence(finger, 1);

            swipe.addAction(finger.createPointerMove(
                    Duration.ZERO,
                    PointerInput.Origin.viewport(),
                    startX,
                    startY));

            swipe.addAction(finger.createPointerDown(
                    PointerInput.MouseButton.LEFT.asArg()));

            swipe.addAction(finger.createPointerMove(
                    Duration.ofMillis(700),
                    PointerInput.Origin.viewport(),
                    startX,
                    endY));

            swipe.addAction(finger.createPointerUp(
                    PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Collections.singletonList(swipe));

            Thread.sleep(1000);

            try {
                driver.findElement(AppiumBy.accessibilityId("Proceed to complete"));
                found = true;
            }
            catch (Exception ignored) {
            }
        }

        driver.findElement(AppiumBy.accessibilityId("Proceed to complete")).click();

        ExtentTestListener.logStep("Proceed to complete clicked");

        //Click proceed to order
        WebElement proceed2 = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Proceed to Order")));
        proceed2.click();
        ExtentTestListener.logStep("Proceed to Order (Page 2) clicked");
    }
}