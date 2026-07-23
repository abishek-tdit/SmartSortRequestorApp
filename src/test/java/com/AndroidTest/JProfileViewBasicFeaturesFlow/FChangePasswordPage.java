package com.AndroidTest.JProfileViewBasicFeaturesFlow;

import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FChangePasswordPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public FChangePasswordPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void changePassword() throws InterruptedException {

        // Click Change Password
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Change Password")
        )).click();

        ExtentTestListener.logStep("Change Password Clicked");



        // Current Password
        WebElement currentPassword = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().className(\"android.widget.EditText\").instance(0)")
                ));

        currentPassword.click();
        currentPassword.clear();
        currentPassword.sendKeys("Admin@194");

        ExtentTestListener.logStep("Current Password Entered");



        // New Password
        WebElement newPassword = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().className(\"android.widget.EditText\").instance(1)")
                ));

        newPassword.click();
        newPassword.clear();
        newPassword.sendKeys("Admin@199");

        ExtentTestListener.logStep("New Password Entered");



        // Scroll Down
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));



        ExtentTestListener.logStep("Scrolled Down");


        // Confirm New Password
        WebElement confirmPassword = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().className(\"android.widget.EditText\").instance(2)")
                ));

        confirmPassword.click();
        confirmPassword.clear();
        confirmPassword.sendKeys("Admin@199");

        ExtentTestListener.logStep("Confirm New Password Entered");



        // Click UPDATE
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("UPDATE")
        )).click();
        Thread.sleep(3000);




        // Click Change Password Again
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Change Password")
        )).click();

        ExtentTestListener.logStep("Change Password Clicked Again");



        // Current Password
        WebElement currentPasswordAgain = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().className(\"android.widget.EditText\").instance(0)")
                ));

        currentPasswordAgain.click();
        currentPasswordAgain.clear();
        currentPasswordAgain.sendKeys("Admin@199");

        ExtentTestListener.logStep("Current Password Entered Again");




        // New Password
        WebElement newPasswordAgain = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().className(\"android.widget.EditText\").instance(1)")
                ));

        newPasswordAgain.click();
        newPasswordAgain.clear();
        newPasswordAgain.sendKeys("Admin@194");

        ExtentTestListener.logStep("New Password Entered Again");




        // Scroll Down
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));



        ExtentTestListener.logStep("Scrolled Down");


        // Confirm Password
        WebElement confirmPasswordAgain = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().className(\"android.widget.EditText\").instance(2)")
                ));

        confirmPasswordAgain.click();
        confirmPasswordAgain.clear();
        confirmPasswordAgain.sendKeys("Admin@194");

        ExtentTestListener.logStep("Confirm Password Entered Again");



        //Final Click UPDATE
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("UPDATE")
        )).click();



        ExtentTestListener.logStep("Password Changed Back Successfully");
    }
}
