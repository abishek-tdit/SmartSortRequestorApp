package com.AndroidTest.ASmartSortRegistrationFlow;

import Base.ExtentTestListener;
import Utility.MobileUtility;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.WebElement;

public class ASignUpPage {

    AndroidDriver driver;
    MobileUtility util;
    private final WebDriverWait wait;

    // CONSTRUCTOR
    public ASignUpPage(AndroidDriver driver) {

        this.driver = driver;
        util = new MobileUtility(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private WebElement waitForVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    private WebElement waitForClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // SIGN UP FLOW
    public void signUp() throws Exception {

        util.click(util.waitForAccessibilityId("Register"));

        ExtentTestListener.logStep("Home Register button clicked");

        util.click(util.waitForAccessibilityId("Select City"));

        ExtentTestListener.logStep("Select City dropdown clicked");
        String city = "Bqaiq";
        util.click(util.waitForAccessibilityId(city));

        ExtentTestListener.logStep("City selected successfully");


        util.click(util.waitForAccessibilityId("Select Requestor Type"));
        ExtentTestListener.logStep("Requestor Type dropdown clicked");
        util.click(util.waitForAccessibilityId("Domestic Requestor"));

        ExtentTestListener.logStep("Requestor Type selected successfully");

//		WebElement requestorType =
//      util.waitForAccessibilityId("Corporate Requestor");
//		util.click(requestorType);
//      ExtentTestListener.logStep("Requestor Type selected successfully");

        // ENTER FIRST NAME
        WebElement firstName = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.widget.EditText[@hint='First Name']")
                )
        );

        firstName.click();
        firstName.sendKeys("Kiran");

        ExtentTestListener.logStep("First Name entered successfully");

        // HIDE KEYBOARD
        driver.hideKeyboard();

        // ENTER LAST NAME
        WebElement lastName = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.widget.EditText[@hint='Last Name']")
                )
        );

        lastName.click();
        lastName.sendKeys("Khan");

        ExtentTestListener.logStep("Last Name entered successfully");

        // HIDE KEYBOARD
        try { driver.hideKeyboard(); } catch (Exception ignored) {}

        // CLICK GENDER DROPDOWN
        util.click(util.waitForAccessibilityId("Select Gender"));

        ExtentTestListener.logStep("Gender dropdown clicked");

        // SELECT MALE
        util.click(util.waitForAccessibilityId("Male"));

        ExtentTestListener.logStep("Male selected successfully");

        // ================= EMAIL =================
        try {
            WebElement email = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            AppiumBy.xpath("//android.widget.EditText[@hint='Email Address']")
                    )
            );

            util.click(email);
            email.clear();
            email.sendKeys("abishek251295@gmail.com");

            try {
                driver.hideKeyboard();
            } catch (Exception ignored) {}

            ExtentTestListener.logStep("Email Address entered successfully");

        } catch (Exception e) {
            ExtentTestListener.logStep("Email field not available. Skipping...");
        }


        // ================= SCROLL =================
        driver.executeScript(
                "mobile: swipeGesture",
                java.util.Map.of(
                        "left", 300,
                        "top", 1200,
                        "width", 400,
                        "height", 600,
                        "direction", "up",
                        "percent", 0.50));


        // ================= MOBILE =================
        BMobileNumber mobileUtil = new BMobileNumber();
        String mobile = mobileUtil.getUniqueMobileNumber(city);

        ExtentTestListener.logStep("Generated Mobile Number : " + mobile);

        WebElement mobileNumber = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.widget.EditText[@hint='Mobile Number']")
                )
        );


        util.click(mobileNumber);
        mobileNumber.clear();
        mobileNumber.sendKeys(mobile);

        try {
            driver.hideKeyboard();
        } catch (Exception ignored) {}

        ExtentTestListener.logStep("Mobile Number entered successfully");
        wait.until(driver -> true);
//
//        // PRESS TAB / NEXT
//        driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(
//                io.appium.java_client.android.nativekey.AndroidKey.TAB));
//
//        wait.until(driver -> true);


        // PASSWORD
        try {
            WebElement password = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            AppiumBy.xpath("//android.widget.EditText[@hint='Password']")
                    )
            );

            util.click(password);

            password.clear();

            password.sendKeys("Admin@194");

            try {
                driver.hideKeyboard();
            } catch (Exception ignored) {
            }

            ExtentTestListener.logStep("Password entered successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
        wait.until(driver -> true);

        // PRESS TAB / NEXT
        driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(
                io.appium.java_client.android.nativekey.AndroidKey.TAB));

        wait.until(driver -> true);

        // SCROLL DOWN (ENSURE FIELD IS VISIBLE)
        driver.executeScript(
                "mobile: scrollGesture",
                java.util.Map.of(
                        "left", 100,
                        "top", 300,
                        "width", 600,
                        "height", 900,
                        "direction", "down",
                        "percent", 0.6));

        wait.until(driver -> true);

        // CLICK CONFIRM PASSWORD DIRECTLY
        WebElement confirmPassword = driver.findElement(
                AppiumBy.xpath("//android.widget.ScrollView//android.widget.EditText[4]"));

        confirmPassword.click();
        wait.until(driver -> true);

        // ENTER CONFIRM PASSWORD
        confirmPassword.sendKeys("Admin@194");

        ExtentTestListener.logStep("Confirm Password entered successfully");
        wait.until(driver -> true);

        try { driver.hideKeyboard(); } catch (Exception ignored) {}

        ExtentTestListener.logStep("Confirm Password entered successfully");
        wait.until(driver -> true);

        // CLICK TERMS CHECKBOX
        WebElement checkbox = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.widget.ScrollView/android.view.View/android.view.View[5]")));

        checkbox.click();

        ExtentTestListener.logStep("Terms checkbox selected successfully");



        // CLICK REGISTER BUTTON
        WebElement registerBtn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.accessibilityId("Register")));

        wait.until(ExpectedConditions.elementToBeClickable(registerBtn));

        registerBtn.click();
        ExtentTestListener.logStep("Register button clicked successfully");

        wait.until(driver -> true);


        //CLICK OK BUTTON
        WebElement okBtn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.accessibilityId("OK")));

        okBtn.click();

        ExtentTestListener.logStep("OTP sent successfully popup OK clicked");

        String otp = mobileUtil.getOTP(mobile);

        ExtentTestListener.logStep("Generated OTP : " + otp);

        ExtentTestListener.logStep("Please enter OTP");

        Thread.sleep(6000);
        WebElement confirmBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Confirm")
                ));

        confirmBtn.click();

        ExtentTestListener.logStep("OTP Confirm button clicked successfully");


        // WAIT FOR REGISTRATION SUCCESS POPUP
        wait.until(driver -> true);


        // CLICK SUCCESS OK BUTTON
        WebElement successOkBtn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.accessibilityId("OK")));

        successOkBtn.click();

        ExtentTestListener.logStep("Registration Success OK button clicked");

    }
}