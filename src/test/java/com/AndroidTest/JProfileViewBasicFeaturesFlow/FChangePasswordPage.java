package com.AndroidTest.JProfileViewBasicFeaturesFlow;

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

        System.out.println("Change Password Clicked");

        Thread.sleep(3000);

        // Current Password
        WebElement currentPassword = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().className(\"android.widget.EditText\").instance(0)")
                ));

        currentPassword.click();
        currentPassword.clear();
        currentPassword.sendKeys("Admin@194");

        System.out.println("Current Password Entered");

        Thread.sleep(2000);

        // New Password
        WebElement newPassword = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().className(\"android.widget.EditText\").instance(1)")
                ));

        newPassword.click();
        newPassword.clear();
        newPassword.sendKeys("Admin@199");

        System.out.println("New Password Entered");

        Thread.sleep(2000);

        // Scroll Down
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));

        Thread.sleep(3000);

        System.out.println("Scrolled Down");


        // Confirm New Password
        WebElement confirmPassword = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().className(\"android.widget.EditText\").instance(2)")
                ));

        confirmPassword.click();
        confirmPassword.clear();
        confirmPassword.sendKeys("Admin@199");

        System.out.println("Confirm New Password Entered");

        Thread.sleep(3000);

        // Click UPDATE
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("UPDATE")
        )).click();

        Thread.sleep(5000);


        // Click Change Password Again
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Change Password")
        )).click();

        System.out.println("Change Password Clicked Again");

        Thread.sleep(3000);

        // Current Password
        WebElement currentPasswordAgain = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().className(\"android.widget.EditText\").instance(0)")
                ));

        currentPasswordAgain.click();
        currentPasswordAgain.clear();
        currentPasswordAgain.sendKeys("Admin@199");

        System.out.println("Current Password Entered Again");

        Thread.sleep(2000);


        // New Password
        WebElement newPasswordAgain = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().className(\"android.widget.EditText\").instance(1)")
                ));

        newPasswordAgain.click();
        newPasswordAgain.clear();
        newPasswordAgain.sendKeys("Admin@194");

        System.out.println("New Password Entered Again");

        Thread.sleep(2000);


        // Scroll Down
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));

        Thread.sleep(3000);

        System.out.println("Scrolled Down");


        // Confirm Password
        WebElement confirmPasswordAgain = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().className(\"android.widget.EditText\").instance(2)")
                ));

        confirmPasswordAgain.click();
        confirmPasswordAgain.clear();
        confirmPasswordAgain.sendKeys("Admin@194");

        System.out.println("Confirm Password Entered Again");

        Thread.sleep(3000);

        //Final Click UPDATE
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("UPDATE")
        )).click();

        Thread.sleep(5000);

        System.out.println("Password Changed Back Successfully");
    }
}
