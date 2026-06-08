package com.AndroidTest.BSmartSortOrderPlacingFlow;

import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CPickupPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public CPickupPage(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public void selectPickup() throws Exception {

        Thread.sleep(5000);


        // SCROLL TO DOOR PICKUP
        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))"
                                + ".scrollIntoView(new UiSelector().descriptionContains(\"Door Pickup\"))"
                )
        );

        ExtentTestListener.getTest().pass("Scrolled to Door Pickup");


        // CLICK DOOR PICKUP
        WebElement doorPickup = driver.findElement(
                By.xpath("//android.widget.ImageView[contains(@content-desc,'Door Pickup')]")
        );

        doorPickup.click();
        ExtentTestListener.getTest().pass("Clicked Door Pickup");


        // WAIT AFTER DOOR PICKUP
        Thread.sleep(3000);


        // CLICK "SELECT YOUR PICKUP LOCATION ON MAP"
        WebElement pickupLocation = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]")
                )
        );

        pickupLocation.click();

        System.out.println("Pickup Location Clicked");

        Thread.sleep(6000);

        ExtentTestListener.getTest().pass("Clicked Select Pickup Location On Map");


        // WAIT 5 SECONDS
        Thread.sleep(5000);

        WebElement savedAddress = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().descriptionContains(\"King Abdulaziz Rd\")"
                        )
                )
        );

        savedAddress.click();

        System.out.println("Saved Address Selected");
        ExtentTestListener.getTest().pass("Selected Saved Address");


        // WAIT FOR OK POPUP

        WebElement okButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("OK")
                )
        );

        okButton.click();

        System.out.println("OK Popup Clicked");
        ExtentTestListener.getTest().pass("Clicked OK Popup");

        Thread.sleep(3000);

        WebElement dryMaterialCheckbox = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId(
                                "I confirm that I submitted only Dry Materials. We are not accepting Wet items, Tea bags & Organic items *"
                        )
                )
        );

        dryMaterialCheckbox.click();

        System.out.println("Dry Material Checkbox Selected");
        ExtentTestListener.getTest().pass("Dry Material Checkbox Selected");

        Thread.sleep(2000);
    }
}