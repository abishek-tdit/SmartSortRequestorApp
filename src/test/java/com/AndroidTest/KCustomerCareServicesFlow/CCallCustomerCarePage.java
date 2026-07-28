package com.AndroidTest.KCustomerCareServicesFlow;

import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CCallCustomerCarePage {


    AndroidDriver driver;
    WebDriverWait wait;


    // Constructor
    public CCallCustomerCarePage(AndroidDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    }


    // =====================================================
    // Click Call Icon
    // =====================================================

    public void clickCallIcon() {

        try {

            WebElement callIcon = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            AppiumBy.androidUIAutomator(
                                    "new UiSelector().className(\"android.widget.ImageView\").instance(7)")));

            callIcon.click();
            ExtentTestListener.logStep("Call Icon Clicked Successfully");

        } catch (Exception e) {
            ExtentTestListener.logStep(
                    "Failed to click Call Icon : " + e.getMessage());
            throw e;
        }
    }



    // =====================================================
    // Click Call Popup Button
    // =====================================================

    public void clickCallButton() {


        try {


            WebElement callButton = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            AppiumBy.accessibilityId("Call")
                    )
            );


            callButton.click();


            ExtentTestListener.logStep(
                    "Call Popup Button Clicked"
            );


            // Wait for Phone App Opening
            wait.until(
                    ExpectedConditions.presenceOfElementLocated(
                            By.xpath("//android.widget.TextView")
                    )
            );


            ExtentTestListener.logStep(
                    "Phone Dialer Opened"
            );


        } catch (Exception e) {


            ExtentTestListener.logStep(
                    "Failed to click Call Popup : " + e.getMessage()
            );


            throw e;
        }

    }



    // =====================================================
    // Return Back To SmartSort App
    // =====================================================

    public void navigateBackToHomePage() {


        try {


            driver.pressKey(
                    new KeyEvent(AndroidKey.BACK)
            );


            ExtentTestListener.logStep(
                    "Returned Back From Phone App"
            );


        } catch (Exception e) {


            ExtentTestListener.logStep(
                    "Back Navigation Failed : " + e.getMessage()
            );

        }



        // Activate SmartSort App Again

        try {


            driver.activateApp(
                    "com.abqaiq.smartsort"
            );


            ExtentTestListener.logStep(
                    "SmartSort App Activated Successfully"
            );


        } catch (Exception e) {


            ExtentTestListener.logStep(
                    "Unable To Activate SmartSort App : " + e.getMessage()
            );


            throw e;
        }

    }


}