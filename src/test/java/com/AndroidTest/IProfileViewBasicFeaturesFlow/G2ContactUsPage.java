package com.AndroidTest.IProfileViewBasicFeaturesFlow;

import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class G2ContactUsPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public G2ContactUsPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void submitContactUsForm() throws InterruptedException {

        // Click Contact Us
        WebElement contactUs = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.accessibilityId("Contact us")));

        wait.until(ExpectedConditions.elementToBeClickable(contactUs)).click();

        ExtentTestListener.logStep("Contact Us Clicked");

        // Name
        WebElement nameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().className(\"android.widget.EditText\").instance(0)")
                ));

        nameField.click();
        nameField.clear();
        nameField.sendKeys("Abishek");

        ExtentTestListener.logStep("Name Entered");


        // Email
        WebElement emailField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().className(\"android.widget.EditText\").instance(1)")
                ));

        emailField.click();
        emailField.clear();
        emailField.sendKeys("abishek251295@gmail.com");

        ExtentTestListener.logStep("Email Entered");


        // Mobile Number
        WebElement mobileField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().className(\"android.widget.EditText\").instance(2)")
                ));

        mobileField.click();
        mobileField.clear();
        mobileField.sendKeys("0500147456");

        ExtentTestListener.logStep("Mobile Number Entered");


        // Message
        WebElement messageField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().className(\"android.widget.EditText\").instance(3)")
                ));

        messageField.click();
        messageField.clear();
        messageField.sendKeys("This is a test message from mobile automation.");

        ExtentTestListener.logStep("Message Entered");


        // Close Keyboard
        try {
            driver.hideKeyboard();
            ExtentTestListener.logStep("Keyboard Closed");
        } catch (Exception e) {
            System.out.println("Keyboard Already Closed");
        }

        Thread.sleep(2000);

        // Send Button
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().className(\"android.widget.Button\").instance(1)")
        )).click();

        ExtentTestListener.logStep("Send Button Clicked");

        // Click OK Popup
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("OK")
        )).click();

        ExtentTestListener.logStep("OK Popup Clicked");

    }
}