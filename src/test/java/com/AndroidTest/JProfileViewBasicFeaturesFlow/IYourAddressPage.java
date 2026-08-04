package com.AndroidTest.JProfileViewBasicFeaturesFlow;

import Base.BasePage;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class IYourAddressPage extends BasePage {

    public IYourAddressPage(AndroidDriver driver) {
        super(driver);
    }

    public void validateYourAddressPage() {

        // Profile Icon
        wait.until(driver -> true);
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath(
                        "//android.widget.FrameLayout[@resource-id='android:id/content']" +
                                "/android.widget.FrameLayout/android.widget.FrameLayout" +
                                "/android.view.View/android.view.View/android.view.View" +
                                "/android.view.View/android.view.View[1]" +
                                "/android.view.View/android.widget.ImageView[1]"
                ))).click();

        ExtentTestListener.logStep("Profile Icon Clicked");

        // View Profile
        wait.until(driver -> true);
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("View Profile"))).click();

        ExtentTestListener.logStep("Clicked View Profile");

        // Your Address
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Your Address"))).click();

        ExtentTestListener.logStep("Your Address Clicked");

        // Select City
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Select City"))).click();

        ExtentTestListener.logStep("Select City Clicked");

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Bqaiq"))).click();

        ExtentTestListener.logStep("City Selected : Bqaiq");

        // Select District
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Select district"))).click();

        ExtentTestListener.logStep("Select District Clicked");

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("AlAndalus"))).click();

        ExtentTestListener.logStep("District Selected : AlAndalus");

        // Search Location Field
        WebElement searchField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.className("android.widget.EditText")));

        if (searchField.isDisplayed()) {
            ExtentTestListener.logStep("Search Location Field Visible");
        }

        // Choose Location From Map
        wait.until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().descriptionContains(\"Choose location from map\")")))
                .click();

        ExtentTestListener.logStep("Choose Location From Map Clicked");

        // Search Location
        WebElement searchBox = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.className("android.widget.EditText")));

        searchBox.click();
        searchBox.clear();
        searchBox.sendKeys("Bqaiq");

        ExtentTestListener.logStep("Entered Location : Bqaiq");

        // Select Address
        wait.until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Abqaiq Saudi Arabia")))
                .click();

        ExtentTestListener.logStep("Selected : Abqaiq Saudi Arabia");

        // Hide Keyboard
        try {
            driver.hideKeyboard();
            ExtentTestListener.logStep("Keyboard Hidden");
        } catch (Exception ignored) {
        }

        // OK
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("OK"))).click();

        ExtentTestListener.logStep("Location Confirmed");

        // Save
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Save"))).click();

        ExtentTestListener.logStep("Popup Save Button Clicked");

        // Open Address Again
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Your Address"))).click();

        ExtentTestListener.logStep("Again Your Address Clicked");

        //scroll down
        scrollDown();
        //scroll down
        scrollDown();

        // Delete Buttons
        List<WebElement> deleteButtons = driver.findElements(
                AppiumBy.className("android.widget.Button"));

        ExtentTestListener.logStep("Delete Buttons Found : " + deleteButtons.size());

        if (deleteButtons.isEmpty()) {
            throw new RuntimeException("No delete button found.");
        }

        WebElement lastDelete = deleteButtons.get(deleteButtons.size() - 1);

        wait.until(ExpectedConditions.elementToBeClickable(lastDelete)).click();

        ExtentTestListener.logStep("Last Address Deleted Successfully");

        //First OK
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("OK"))).click();

        ExtentTestListener.logStep("First OK Popup Clicked");

        //Second OK
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("OK"))).click();

        ExtentTestListener.logStep("Second OK Popup Clicked");

        //Back
        driver.navigate().back();

        ExtentTestListener.logStep("Navigated Back");
    }
}