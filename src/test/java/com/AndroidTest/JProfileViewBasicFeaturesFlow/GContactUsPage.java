package com.AndroidTest.JProfileViewBasicFeaturesFlow;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GContactUsPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public GContactUsPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void submitContactUsForm() throws InterruptedException {

        // Click Contact Us
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Contact us")
        )).click();

        System.out.println("Contact Us Clicked");

        Thread.sleep(3000);

        // Name
        WebElement nameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().className(\"android.widget.EditText\").instance(0)")
                ));

        nameField.click();
        nameField.clear();
        nameField.sendKeys("Abishek");

        System.out.println("Name Entered");

        Thread.sleep(1000);

        // Email
        WebElement emailField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().className(\"android.widget.EditText\").instance(1)")
                ));

        emailField.click();
        emailField.clear();
        emailField.sendKeys("abishek251295@gmail.com");

        System.out.println("Email Entered");

        Thread.sleep(1000);

        // Mobile Number
        WebElement mobileField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().className(\"android.widget.EditText\").instance(2)")
                ));

        mobileField.click();
        mobileField.clear();
        mobileField.sendKeys("0500123456");

        System.out.println("Mobile Number Entered");

        Thread.sleep(1000);

        // Message
        WebElement messageField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().className(\"android.widget.EditText\").instance(3)")
                ));

        messageField.click();
        messageField.clear();
        messageField.sendKeys("This is a test message from mobile automation.");

        System.out.println("Message Entered");

        Thread.sleep(2000);

        // Close Keyboard
        try {
            driver.hideKeyboard();
            System.out.println("Keyboard Closed");
        } catch (Exception e) {
            System.out.println("Keyboard Already Closed");
        }

        Thread.sleep(2000);

        // Send Button
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().className(\"android.widget.Button\").instance(1)")
        )).click();

        System.out.println("Send Button Clicked");

        Thread.sleep(7000);

        // Click OK Popup
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("OK")
        )).click();

        System.out.println("OK Popup Clicked");

        Thread.sleep(3000);
    }
}