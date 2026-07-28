package com.AndroidTest.BSmartSortOrderPlacingFlow;

import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DSlotPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public DSlotPage(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void selectSlot() throws InterruptedException {

        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))"
                                + ".scrollIntoView(new UiSelector().description(\"Select Slot\"))"
                )
        );

        WebElement selectSlotBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Select Slot")
                )
        );

        selectSlotBtn.click();
        ExtentTestListener.getTest().pass("Clicked Select Slot");

        Thread.sleep(5000);

        WebElement timeSlot = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("11:00 AM - 11:58 PM")
                )
        );

        timeSlot.click();
        ExtentTestListener.getTest().pass("Selected Time Slot");

        WebElement continueBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Continue")
                )
        );

        continueBtn.click();
        ExtentTestListener.getTest().pass("Clicked Continue");

        WebElement confirmBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Confirm")
                )
        );

        confirmBtn.click();
        ExtentTestListener.getTest().pass("Clicked Confirm");

        Thread.sleep(2000);


        // CLICK FINAL OK BUTTON
        WebElement finalOkBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("OK")
                )
        );

        finalOkBtn.click();

        System.out.println("Final OK Button Clicked");

        if (ExtentTestListener.getTest() != null) {
            ExtentTestListener.getTest().pass("Final OK Button Clicked");
        }

        Thread.sleep(3000);
    }
}