package com.AndroidTest.CRequestorOrderPlacingFlow;

import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.testng.Reporter.log;

public class DSlotPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public DSlotPage(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void selectSlot() throws InterruptedException {
        // Wait for page to load
        Thread.sleep(5000);

        // Scroll until Select Slot is visible
        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scrollIntoView(new UiSelector().description(\"Select Slot\"))"));

        Thread.sleep(1000);

        // Find Select Slot button
        WebElement selectSlotBtn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.accessibilityId("Select Slot")));

        // Click using gesture
        assert ((RemoteWebElement) selectSlotBtn).getId() != null;
        driver.executeScript(
                "mobile: clickGesture",
                Map.of(
                        "elementId",
                        ((RemoteWebElement) selectSlotBtn).getId()));

        ExtentTestListener.logStep("Select Slot Clicked");

        if (ExtentTestListener.getTest() != null) {
            ExtentTestListener.getTest().pass("Clicked Select Slot");
        }

        Thread.sleep(3000);

        //Get all time slots
        List<WebElement> timeSlots = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(
                        AppiumBy.xpath("//android.view.View[contains(@content-desc, 'PM') or contains(@content-desc, 'AM')]")));

        //Click first available slot
        if (!timeSlots.isEmpty()) {

            // Filter visible + clickable slot
            WebElement firstSlot = timeSlots.getFirst();

            wait.until(ExpectedConditions.elementToBeClickable(firstSlot)).click();

            log("First Time Slot Selected");

        }
        else
        {
            throw new RuntimeException("No Time Slots Available");
        }

        WebElement continueBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Continue")));

        continueBtn.click();
        ExtentTestListener.getTest().pass("Clicked Continue");

        WebElement confirmBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Confirm")));

        confirmBtn.click();
        ExtentTestListener.getTest().pass("Clicked Confirm");

        Thread.sleep(2000);


        // CLICK FINAL OK BUTTON
        WebElement finalOkBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("OK")));

        finalOkBtn.click();

        ExtentTestListener.logStep("Final OK Button Clicked");

        if (ExtentTestListener.getTest() != null) {
            ExtentTestListener.getTest().pass("Final OK Button Clicked");
        }

        Thread.sleep(3000);
    }
}