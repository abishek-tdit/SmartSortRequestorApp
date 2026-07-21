package com.AndroidTest.DRequestorDirectDeliveryOrderPlacingFlow;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.Collections;

public class CDirectDeliveryPage extends BaseClassMobile {

    public CDirectDeliveryPage(AndroidDriver driver) {super();
    }
    public void clickDirectDelivery() {

        try {
            driver.findElement(
                    AppiumBy.androidUIAutomator(
                            "new UiScrollable(new UiSelector().scrollable(true))" +
                                    ".setAsVerticalList()" +
                                    ".setSwipeDeadZonePercentage(0.3)" +
                                    ".scrollForward()"));

            ExtentTestListener.logStep("Half-like scroll done");
            Thread.sleep(2000);

            // Swipe left
            Dimension size = driver.manage().window().getSize();

            int startX = (int) (size.width * 0.85);
            int endX = (int) (size.width * 0.15);
            int y = (int) (size.height * 0.60);

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

            Sequence swipe = new Sequence(finger, 1);

            swipe.addAction(finger.createPointerMove(Duration.ZERO,
                    PointerInput.Origin.viewport(), startX, y));

            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

            swipe.addAction(finger.createPointerMove(Duration.ofMillis(700),
                    PointerInput.Origin.viewport(), endX, y));

            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Collections.singletonList(swipe));

            ExtentTestListener.logStep("Swiped left");

            Thread.sleep(2000);

            // Click Direct Delivery
            WebElement directDelivery = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            AppiumBy.accessibilityId(
                                    "Direct Delivery\nSubmit materials directly to Collection Center")));

            directDelivery.click();

            ExtentTestListener.logStep("Direct Delivery clicked");
            Thread.sleep(5000);

            //CC
            WebElement selectCentre = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            AppiumBy.xpath("//android.widget.Button[contains(@content-desc,'Select Collection Centre')]")));

            selectCentre.click();
            ExtentTestListener.logStep("Select Collection Center clicked");

            Thread.sleep(3000);

            //Select CC
            WebElement centre = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            AppiumBy.androidUIAutomator(
                                    "new UiSelector().descriptionContains(\"TTFVaasan\")")));

            centre.click();
            ExtentTestListener.logStep("TTFVaasan 0.03KM selected");

            //Scroll DOWN
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollForward()"));

            ExtentTestListener.logStep("Page scrolled");

            //Tic - Checkbox
            WebElement mixedMaterials = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            AppiumBy.accessibilityId("Mixed Materials *")));

            mixedMaterials.click();
            ExtentTestListener.logStep("Mixed Materials checked");

            // Scroll DOWN
            driver.executeScript(
                    "mobile: swipeGesture",
                    java.util.Map.of(
                            "left", 100,
                            "top", 400,
                            "width", 500,
                            "height", 800,
                            "direction", "up",
                            "percent", 0.75));

            Thread.sleep(2000);

            //Tic
            WebElement confirmDryMaterials = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            AppiumBy.accessibilityId(
                                    "I confirm that my request contains only the accepted materials and meets the above conditions *")));

            confirmDryMaterials.click();
            ExtentTestListener.logStep("Checkbox clicked");


        }
        catch (Exception e)
        {
            ExtentTestListener.logStep("Failed to click Direct Delivery");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}