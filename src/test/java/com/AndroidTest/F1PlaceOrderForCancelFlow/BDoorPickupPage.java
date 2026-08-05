package com.AndroidTest.F1PlaceOrderForCancelFlow;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class BDoorPickupPage extends BaseClassMobile {

    AndroidDriver driver;
    WebDriverWait wait;

    public BDoorPickupPage(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public void selectPickup() throws Exception {

        // Wait until loading completes and Door Pickup is clickable
        WebElement doorPickup = new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Door Pickup")));

        doorPickup.click();

        ExtentTestListener.logStep("Door Pickup Clicked");

        // CLICK "SELECT YOUR PICKUP LOCATION ON MAP"
        WebElement pickupLocation = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]")));

        pickupLocation.click();

        ExtentTestListener.logStep("Pickup Location Clicked");
        ExtentTestListener.getTest().pass("Clicked Select Pickup Location On Map");

        // Click Saved Address
        WebElement savedAddress = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.view.View[contains(@content-desc,'Buqayq')]")));

        savedAddress.click();

        ExtentTestListener.logStep("Saved Address Clicked");

        // WAIT FOR OK POPUP
        WebElement okButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("OK")));

        okButton.click();

        ExtentTestListener.logStep("OK Popup Clicked");
        ExtentTestListener.getTest().pass("Clicked OK Popup");

        // Wait until popup disappears
        wait.until(ExpectedConditions.invisibilityOf(okButton));

        Thread.sleep(1000);

        scrollDown();

        //Tic checkbox
        WebElement checkBox = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath(
                                "//android.widget.CheckBox[@content-desc='I confirm that my request contains only the accepted materials and meets the above conditions *']")));

        driver.executeScript(
                "mobile: clickGesture",
                Map.of(
                        "elementId",
                        ((RemoteWebElement) checkBox).getId()));

        ExtentTestListener.logStep("Checkbox Selected");
        ExtentTestListener.getTest().pass("Checkbox Selected");


    }
}