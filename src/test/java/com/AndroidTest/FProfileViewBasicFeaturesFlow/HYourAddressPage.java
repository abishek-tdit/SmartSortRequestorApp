package com.AndroidTest.FProfileViewBasicFeaturesFlow;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HYourAddressPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public HYourAddressPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void validateYourAddressPage() throws InterruptedException {

        //Click View Profile FIRST
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("View Profile")
        )).click();

        Thread.sleep(3000);

        System.out.println("Clicked View Profile, waiting for next screen...");
        Thread.sleep(5000);

        // Click Your Address (using your locator)
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Your Address")
        )).click();

        System.out.println("Your Address Clicked");

        Thread.sleep(3000);


        //Select City
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Select City"))).click();
        System.out.println("Select City Clicked");

        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Chennai"))).click();
        System.out.println("City Selected (Chennai)");

        Thread.sleep(2000);

        //Select District
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Select district"))).click();
        System.out.println("Select District Clicked");

        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Ambattur"))).click();
        System.out.println("District Selected (Ambattur)");

        Thread.sleep(2000);

        //Search Location Field
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.className("android.widget.EditText")));

        if (searchField.isDisplayed()) {
            System.out.println("Search Location Field Visible");
        } else {
            System.out.println("❌ Search Location Field NOT Visible");
        }

        //Choose Location From Map
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().descriptionContains(\"Choose location from map\")"
                ))).click();

        System.out.println("Choose Location From Map Clicked");

        Thread.sleep(4000);

        // Click OK Button
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("OK"))).click();

        System.out.println("Location Confirmed (OK Clicked)");

        Thread.sleep(3000);


        //Click Popup Save Button
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Save")
        )).click();

        System.out.println("Popup Save Button Clicked");

        Thread.sleep(3000);

        //Click Your Address
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Your Address")
        )).click();

        System.out.println("Again Your Address Clicked");

        Thread.sleep(3000);

        //Click Delete Icon
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("(//android.widget.Button)[2]")
        )).click();

        System.out.println("First Address Delete Clicked");

        Thread.sleep(2000);


        //OK POPUP
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("OK")
        )).click();

        System.out.println("First OK Popup Clicked");

        Thread.sleep(2000);

        //Second ok popup
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("OK")
        )).click();

        System.out.println("Second OK Popup Clicked");

        Thread.sleep(3000);


        //goback
        driver.navigate().back();
        System.out.println("Navigated Back");


    }
}
