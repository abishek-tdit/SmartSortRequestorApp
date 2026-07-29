package com.AndroidTest.NAccountDeleteFlow;

import Base.BasePage;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.Collections;
import java.util.Map;

public class ADeleteAccountPage extends BasePage {

    //=========================================================
    // Constructor
    //=========================================================

    public ADeleteAccountPage(AndroidDriver driver) {
        super(driver);
    }

    //=========================================================
    // Locators
    //=========================================================

    private final By profileIcon = AppiumBy.xpath(
            "//android.widget.FrameLayout[@resource-id='android:id/content']" +
                    "/android.widget.FrameLayout/android.widget.FrameLayout" +
                    "/android.view.View/android.view.View/android.view.View" +
                    "/android.view.View/android.view.View[1]" +
                    "/android.view.View/android.widget.ImageView[1]"
    );

    private final By viewProfile =
            AppiumBy.accessibilityId("View Profile");

    private final By deleteAccount =
            AppiumBy.accessibilityId("Delete Account");

    private final By yesButton =
            AppiumBy.accessibilityId("Yes");

    private final By othersRadioButton =
            AppiumBy.accessibilityId("Others");

    private final By deleteButton =
            AppiumBy.accessibilityId("Delete");

    //=========================================================
    // Delete Account
    //=========================================================

    public void deleteAccount() {

        // Click Profile Icon
        wait.until(ExpectedConditions.elementToBeClickable(profileIcon)).click();

        ExtentTestListener.logStep("Profile Icon Clicked");

        // Click View Profile
        wait.until(ExpectedConditions.elementToBeClickable(viewProfile)).click();

        ExtentTestListener.logStep("View Profile Clicked");

        // Scroll until Delete Account is visible
        boolean found = false;

        while (!found) {

            try {

                if (driver.findElement(deleteAccount).isDisplayed()) {
                    found = true;
                    break;
                }

            } catch (Exception ignored) {
            }

            driver.executeScript(
                    "mobile: scrollGesture",
                    Map.of(
                            "left", 100,
                            "top", 300,
                            "width", 600,
                            "height", 1000,
                            "direction", "down",
                            "percent", 0.9
                    )
            );
        }

        // Click Delete Account
        wait.until(ExpectedConditions.elementToBeClickable(deleteAccount)).click();

        ExtentTestListener.logStep("Delete Account Button Clicked");

        // Click Yes Popup
        wait.until(ExpectedConditions.elementToBeClickable(yesButton)).click();

        ExtentTestListener.logStep("Yes Button Clicked");

        //=========================================================
        // Select Others Radio Button using Coordinates
        //=========================================================

        WebElement others = wait.until(
                ExpectedConditions.visibilityOfElementLocated(othersRadioButton));

        Rectangle rect = others.getRect();

        // Tap near the left radio circle
        int x = rect.getX() + 35;
        int y = rect.getY() + (rect.getHeight() / 2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence tap = new Sequence(finger, 1);

        tap.addAction(finger.createPointerMove(
                Duration.ZERO,
                PointerInput.Origin.viewport(),
                x,
                y));

        tap.addAction(finger.createPointerDown(
                PointerInput.MouseButton.LEFT.asArg()));

        tap.addAction(finger.createPointerUp(
                PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(tap));

        ExtentTestListener.logStep("Others Radio Button Selected");

        //=========================================================
        // Click Delete
        //=========================================================

        wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();

        ExtentTestListener.logStep("Final Delete Button Clicked");

        if (ExtentTestListener.getTest() != null) {
            ExtentTestListener.getTest().pass("Account Deleted Successfully");
        }
    }
}