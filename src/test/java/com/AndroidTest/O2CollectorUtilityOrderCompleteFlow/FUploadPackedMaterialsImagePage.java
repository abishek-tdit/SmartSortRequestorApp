package com.AndroidTest.O2CollectorUtilityOrderCompleteFlow;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FUploadPackedMaterialsImagePage extends BaseClassMobile {

    public void uploadImage() throws InterruptedException {

        //Enter Weight
        WebElement weightField = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        AppiumBy.className("android.widget.EditText")));

        weightField.click();
        Thread.sleep(800);
        weightField.clear();
        weightField.sendKeys("15");

        ExtentTestListener.logStep("Weight entered: 15 KG");

        try {
            driver.hideKeyboard();
        }
        catch (Exception ignored) {
        }

        Thread.sleep(2000);

        ExtentTestListener.logStep("Please manually take photo and return to app...");

        Thread.sleep(10000);

        boolean sessionRestarted = false;

        try {
            ExtentTestListener.logStep("Package = " + driver.getCurrentPackage());
            driver.getPageSource();

            ExtentTestListener.logStep("UiAutomator2 Alive");

        }
        catch (Exception e)
        {
            ExtentTestListener.logStep("UiAutomator2 Crashed");
            BaseClassMobile.restartSession();
            sessionRestarted = true;


        }

        try {
            wait.until(
                    ExpectedConditions.elementToBeClickable(
                            AppiumBy.accessibilityId("Submit"))).click();

            if (sessionRestarted) {
                ExtentTestListener.logStep("Submit Clicked After Restart");
            } else {
                ExtentTestListener.logStep("Submit Clicked");
            }
        }
        catch (Exception e)
        {
            ExtentTestListener.logStep("Submit button not found");
            throw new RuntimeException(
                    "Submit button not found after session recovery");
        }
        Thread.sleep(5000);

        // Dashboard
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Go to Dashboard"))).click();

        ExtentTestListener.logStep("Dashboard Clicked");
    }
}