package com.AndroidTest.C4CollectionCenterAcceptOrderFlow;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class BUnacceptedOrdersPage extends BaseClassMobile {

    public void clickUnacceptedOrders() {

        try {
            ExtentTestListener.logStep("Clicking Unaccepted Orders...");

            WebElement unacceptedOrders = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            AppiumBy.xpath("//android.view.View[contains(@content-desc,'Unaccepted Orders')]")));

            unacceptedOrders.click();

            ExtentTestListener.logStep("Unaccepted Orders clicked successfully.");

        }
        catch (Exception e)
        {
            ExtentTestListener.logStep("Failed to click Unaccepted Orders: " + e.getMessage());
            throw e;
        }
    }

    public void clickOrder() {
        try {
            ExtentTestListener.logStep("Clicking order...");

            WebElement firstOrder = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            AppiumBy.xpath("(//android.view.View[contains(@content-desc,'Delivery:')])[1]")));

            firstOrder.click();

            ExtentTestListener.logStep("First order clicked successfully.");

        }
        catch (Exception e)
        {
            ExtentTestListener.logStep("Failed to click first order: " + e.getMessage());
            throw e;
        }
    }

    public void swipeToAccept() {

        try {

            ExtentTestListener.logStep("Swiping to Accept...");

            WebElement slider = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.androidUIAutomator(
                                    "new UiSelector().className(\"android.view.View\").instance(27)")));

            int startX = 90;
            int startY = 1425;

            int endX = 900;
            int endY = startY;

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 1);

            swipe.addAction(
                    finger.createPointerMove(
                            Duration.ZERO,
                            PointerInput.Origin.viewport(),
                            startX,
                            startY));

            swipe.addAction(
                    finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

            swipe.addAction(
                    finger.createPointerMove(
                            Duration.ofMillis(1000),
                            PointerInput.Origin.viewport(),
                            endX,
                            endY));

            swipe.addAction(
                    finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(java.util.Collections.singletonList(swipe));

            ExtentTestListener.logStep("Swipe completed successfully");

        }
        catch (Exception e)
        {

            ExtentTestListener.logStep("Failed to swipe: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void clickOkPopup() {
        try {
            ExtentTestListener.logStep("Clicking OK popup...");

            WebElement okButton = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            AppiumBy.accessibilityId("OK")));

            okButton.click();

            ExtentTestListener.logStep("OK popup clicked successfully.");

        }
        catch (Exception e)
        {
            ExtentTestListener.logStep("Failed to click OK popup: " + e.getMessage());
            throw e;
        }
    }
}