package com.AndroidTest.FProfileViewBasicFeaturesFlow;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import java.util.List;

public class DProfileUserDetailsPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public DProfileUserDetailsPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void updateUserDetails() throws InterruptedException {

        // Navigate back to Profile Page
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().className(\"android.widget.ImageView\").instance(0)")
        )).click();

        System.out.println("Profile Icon Clicked");

        Thread.sleep(5000);


        // Click View Profile
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("View Profile")
        )).click();

        System.out.println("View Profile Clicked");

        Thread.sleep(5000);


        // Click User Name Edit Icon
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.ScrollView/android.view.View[3]")
        )).click();

        System.out.println("User Name Edit Icon Clicked");

        Thread.sleep(5000);

        List<WebElement> fields =
                driver.findElements(
                        AppiumBy.className("android.widget.EditText"));

        System.out.println("Total Fields = " + fields.size());

        // First Name
        fields.get(0).clear();
        fields.get(0).sendKeys("Abishek");

        System.out.println("First Name Updated");

        // Last Name
        fields.get(1).clear();
        fields.get(1).sendKeys("DD");

        System.out.println("Last Name Updated");

        Thread.sleep(2000);


        // Update Button
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Update")
        )).click();

        System.out.println("Update Button Clicked");

        Thread.sleep(5000);


        // Email Edit Icon
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.ScrollView/android.view.View[7]")
        )).click();

        System.out.println("Email Edit Icon Clicked");

        Thread.sleep(3000);

        WebElement emailField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.className("android.widget.EditText")
                ));

        emailField.click();
        emailField.clear();
        Thread.sleep(1000);

        emailField.sendKeys("abishek251295@gmail.com");

        Thread.sleep(2000);

        System.out.println("Email Value = " + emailField.getText());

        Thread.sleep(2000);


        // Send OTP
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Send OTP")
        )).click();

        System.out.println("Send OTP Clicked");

        Thread.sleep(3000);


        // OK Popup
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("OK")
        )).click();

        System.out.println("OTP Sent Popup OK Clicked");

        System.out.println("Waiting 30 seconds for OTP entry...");

        Thread.sleep(30000);


        // Verify OTP
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Verify OTP")
        )).click();

        System.out.println("Verify OTP Clicked");

        Thread.sleep(5000);


        // Success OK
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("OK")
        )).click();

        System.out.println("Success Popup OK Clicked");

        Thread.sleep(3000);

        System.out.println("User Details Updated Successfully");
    }
}