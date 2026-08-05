package com.AndroidTest.N1ReferAndEarnFlow;

import Base.ExtentTestListener;
import Utility.MobileUtility;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class CASignUpPage {

    AndroidDriver driver;
    MobileUtility util;
    private final WebDriverWait wait;

    // CONSTRUCTOR
    public CASignUpPage(AndroidDriver driver) {

        this.driver = driver;
        this.util = new MobileUtility(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // SIGN UP FLOW
    public void signUp() throws Exception {


        // SIGN UP
        util.click(util.waitForAccessibilityId("Dont have an account? Sign Up"));

        ExtentTestListener.logStep("Sign Up button clicked");

        // SELECT CITY
        util.click(util.waitForAccessibilityId("Select City"));
        ExtentTestListener.logStep("Select City dropdown clicked");

        String city = "Bqaiq";

        util.click(util.waitForAccessibilityId(city));
        ExtentTestListener.logStep("City selected successfully");

        // REQUESTOR TYPE
        util.click(util.waitForAccessibilityId("Select Requestor Type"));
        ExtentTestListener.logStep("Requestor Type dropdown clicked");

        util.click(util.waitForAccessibilityId("Domestic Requestor"));
        ExtentTestListener.logStep("Requestor Type selected successfully");

        // FIRST NAME
        WebElement firstName = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.widget.EditText[@hint='First Name']")
                ));

        firstName.click();
        firstName.sendKeys("Vijay");

        ExtentTestListener.logStep("First Name entered successfully");

        try {
            driver.hideKeyboard();
        } catch (Exception ignored) {
        }

        // LAST NAME
        WebElement lastName = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.widget.EditText[@hint='Last Name']")
                ));

        lastName.click();
        lastName.sendKeys("Jose");

        ExtentTestListener.logStep("Last Name entered successfully");

        try {
            driver.hideKeyboard();
        } catch (Exception ignored) {
        }

        // GENDER
        util.click(util.waitForAccessibilityId("Select Gender"));
        ExtentTestListener.logStep("Gender dropdown clicked");

        util.click(util.waitForAccessibilityId("Male"));
        ExtentTestListener.logStep("Male selected successfully");

        // EMAIL
        try {

            WebElement email = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            AppiumBy.xpath("//android.widget.EditText[@hint='Email Address']")
                    ));

            email.click();
            email.clear();
            email.sendKeys("abishek251295@gmail.com");

            try {
                driver.hideKeyboard();
            } catch (Exception ignored) {
            }

            ExtentTestListener.logStep("Email Address entered successfully");

        } catch (Exception e) {

            ExtentTestListener.logStep("Email field not available. Skipping...");
        }

        // SWIPE UP
        driver.executeScript(
                "mobile: swipeGesture",
                Map.of(
                        "left", 300,
                        "top", 1200,
                        "width", 400,
                        "height", 600,
                        "direction", "up",
                        "percent", 0.50));

        // MOBILE NUMBER
        CBMobileNumber mobileUtil = new CBMobileNumber();

        String mobile = mobileUtil.getUniqueMobileNumber(city);

        // Store the generated mobile number for later use
        MobileUtility.generatedMobileNumber = mobile;

        ExtentTestListener.logStep("Generated Mobile Number : " + MobileUtility.generatedMobileNumber);

        WebElement mobileNumber = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.widget.EditText[@hint='Mobile Number']")
                ));

        mobileNumber.click();
        mobileNumber.clear();
        mobileNumber.sendKeys(MobileUtility.generatedMobileNumber);

        try {
            driver.hideKeyboard();
        } catch (Exception ignored) {
        }

        ExtentTestListener.logStep("Mobile Number entered successfully");

        wait.until(driver -> true);

        // PASSWORD
        WebElement password = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.widget.EditText[@hint='Password']")
                ));

        password.click();
        password.clear();
        password.sendKeys("Admin@194");

        try {
            driver.hideKeyboard();
        } catch (Exception ignored) {
        }

        ExtentTestListener.logStep("Password entered successfully");

        wait.until(driver -> true);

        // TAB
        driver.pressKey(new KeyEvent(AndroidKey.TAB));

        wait.until(driver -> true);

        // SCROLL
        driver.executeScript(
                "mobile: scrollGesture",
                Map.of(
                        "left", 100,
                        "top", 300,
                        "width", 600,
                        "height", 900,
                        "direction", "down",
                        "percent", 0.6));

        wait.until(driver -> true);

        // CONFIRM PASSWORD
        WebElement confirmPassword = driver.findElement(
                AppiumBy.xpath("//android.widget.ScrollView//android.widget.EditText[4]"));

        confirmPassword.click();
        confirmPassword.sendKeys("Admin@194");

        try {
            driver.hideKeyboard();
        } catch (Exception ignored) {
        }

        ExtentTestListener.logStep("Confirm Password entered successfully");

        // REFERRAL  CODE
        WebElement referralCode = wait.until(
                ExpectedConditions.elementToBeClickable(AppiumBy.xpath(
                                "//android.widget.EditText[contains(@hint,'Referral')]")));

        referralCode.click();
        referralCode.sendKeys(MobileUtility.referralCode);
        try {
            driver.hideKeyboard();
        } catch (Exception ignored) {
        }

        ExtentTestListener.logStep("Referral Code Entered successfully");



        // TERMS CHECKBOX
        WebElement checkbox = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.widget.ScrollView/android.view.View/android.view.View[5]")));

        checkbox.click();

        ExtentTestListener.logStep("Terms checkbox selected successfully");

        // REGISTER
        WebElement registerBtn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.accessibilityId("Register")));

        wait.until(ExpectedConditions.elementToBeClickable(registerBtn));

        registerBtn.click();

        ExtentTestListener.logStep("Register button clicked successfully");

        // OK POPUP
        WebElement okBtn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.accessibilityId("OK")));

        okBtn.click();

        ExtentTestListener.logStep("OTP sent successfully popup OK clicked");

        // GET OTP
        String otp = mobileUtil.getOTP(mobile);

        ExtentTestListener.logStep("Generated OTP : " + otp);

        ExtentTestListener.logStep("Please enter OTP manually");

        Thread.sleep(10000);

        // CONFIRM
        WebElement confirmBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Confirm")));

        confirmBtn.click();

        ExtentTestListener.logStep("OTP Confirm button clicked successfully");

        // SUCCESS OK
        WebElement successOkBtn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.accessibilityId("OK")));

        successOkBtn.click();

        ExtentTestListener.logStep("Registration Success OK button clicked");
    }
}