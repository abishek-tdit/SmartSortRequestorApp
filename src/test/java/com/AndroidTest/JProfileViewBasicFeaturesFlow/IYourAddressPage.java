package com.AndroidTest.JProfileViewBasicFeaturesFlow;

import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class IYourAddressPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public IYourAddressPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void validateYourAddressPage() throws InterruptedException {

        // Profile Icon Page
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath(
                        "//android.widget.FrameLayout[@resource-id='android:id/content']" +
                                "/android.widget.FrameLayout/android.widget.FrameLayout" +
                                "/android.view.View/android.view.View/android.view.View" +
                                "/android.view.View/android.view.View[1]" +
                                "/android.view.View/android.widget.ImageView[1]"))).click();

        ExtentTestListener.logStep("Profile Icon Clicked");
        Thread.sleep(3000);

        //Click View Profile
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("View Profile"))).click();


        ExtentTestListener.logStep("Clicked View Profile, waiting for next screen...");
        Thread.sleep(5000);

        // Click Your Address (using your locator)
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Your Address"))).click();

        ExtentTestListener.logStep("Your Address Clicked");

        Thread.sleep(3000);

        //Select City
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Select City"))).click();
        ExtentTestListener.logStep("Select City Clicked");

        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Bqaiq"))).click();
        ExtentTestListener.logStep("City Selected (Bqaiq)");

        Thread.sleep(2000);

        //Select District
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Select district"))).click();
        ExtentTestListener.logStep("Select District Clicked");

        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("AlAndalus"))).click();
        ExtentTestListener.logStep("District Selected (AlAndalus)");

        Thread.sleep(2000);

        //Search Location Field
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.className("android.widget.EditText")));

        if (searchField.isDisplayed()) {
            ExtentTestListener.logStep("Search Location Field Visible");
        }
        else
        {
            ExtentTestListener.logStep("Search Location Field NOT Visible");
        }

        //Choose Location From Map
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().descriptionContains(\"Choose location from map\")"))).click();

        ExtentTestListener.logStep("Choose Location From Map Clicked");

        Thread.sleep(4000);

        // Click Search Location Text Box
        WebElement searchBox = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.className("android.widget.EditText")));

        searchBox.click();
        searchBox.sendKeys("Bqaiq");

        ExtentTestListener.logStep("Entered Location : Bqaiq");

        Thread.sleep(3000);

        // Select Vellore, Tamil Nadu, India
        WebElement vellore = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Abqaiq Saudi Arabia")));

        vellore.click();

        ExtentTestListener.logStep("Selected : Abqaiq Saudi Arabia");

        Thread.sleep(2000);

        try {
            driver.hideKeyboard();
            ExtentTestListener.logStep("Keyboard Hidden");
        } catch (Exception e) {
            System.out.println("Keyboard already hidden");
        }

        Thread.sleep(2000);

        // Click OK Button
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("OK"))).click();

        ExtentTestListener.logStep("Location Confirmed (OK Clicked)");

        Thread.sleep(3000);


        //Click Popup Save Button
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Save")
        )).click();

        ExtentTestListener.logStep("Popup Save Button Clicked");

        Thread.sleep(3000);

        //Click Your Address
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Your Address")
        )).click();

        ExtentTestListener.logStep("Again Your Address Clicked");

        Thread.sleep(3000);


        // Scroll down to the bottom
        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(5)"
                )
        );

        Thread.sleep(2000);

// Get all delete buttons
        List<WebElement> deleteButtons = driver.findElements(
                AppiumBy.className("android.widget.Button")
        );

        ExtentTestListener.logStep("Delete Buttons Found : " + deleteButtons.size());

        if (deleteButtons.isEmpty()) {
            throw new RuntimeException("No delete button found.");
        }

// Click the last delete button
        WebElement lastDelete = deleteButtons.get(deleteButtons.size() - 1);

        wait.until(ExpectedConditions.elementToBeClickable(lastDelete)).click();

        ExtentTestListener.logStep("Last Address Deleted Successfully");

        Thread.sleep(2000);

        //OK POPUP
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("OK")
        )).click();

        ExtentTestListener.logStep("First OK Popup Clicked");

        Thread.sleep(2000);

        //Second ok popup
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("OK")
        )).click();

        ExtentTestListener.logStep("Second OK Popup Clicked");

        Thread.sleep(3000);


        //goback
        driver.navigate().back();
        ExtentTestListener.logStep("Navigated Back");


    }
}
