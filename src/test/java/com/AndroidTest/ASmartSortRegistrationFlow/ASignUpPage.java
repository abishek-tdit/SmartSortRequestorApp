package com.AndroidTest.ASmartSortRegistrationFlow;

import Base.ExtentTestListener;
import Utility.MobileUtility;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;

public class ASignUpPage {

    AndroidDriver driver;
    MobileUtility util;

    // CONSTRUCTOR
    public ASignUpPage(AndroidDriver driver) {

        this.driver = driver;
        util = new MobileUtility(driver);
    }

    // SIGN UP FLOW
    public void signUp() throws Exception {


//		WebElement registerBtnHome = util.waitForAccessibilityId("Register");

//		util.click(registerBtnHome);
        util.click(util.waitForAccessibilityId("Register"));
        ExtentTestListener.logStep("Home Register button clicked");
        util.click(util.waitForAccessibilityId("Select City"));

        ExtentTestListener.logStep("Select City dropdown clicked");
        String city = "Chennai";

        util.click(util.waitForAccessibilityId(city));

        ExtentTestListener.logStep("City selected successfully");

        util.click(util.waitForAccessibilityId("Select Requestor Type"));

        ExtentTestListener.logStep("Requestor Type dropdown clicked");

        util.click(util.waitForAccessibilityId("Domestic Requestor"));

        ExtentTestListener.logStep("Requestor Type selected successfully");

//		WebElement requestorType =
//        util.waitForAccessibilityId("Corporate Requestor");

//		util.click(requestorType);

//      ExtentTestListener.logStep("Requestor Type selected successfully");

//        // SCROLL DOWN LITTLE
//        driver.executeScript(
//                "mobile: swipeGesture",
//                java.util.Map.of(
//                        "left", 500,
//                        "top", 1500,
//                        "width", 300,
//                        "height", 600,
//                        "direction", "up",
//                        "percent", 0.75 ));
//
//        util.delay(1);

        // ENTER FIRST NAME
        WebElement firstName = driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().className(\"android.widget.EditText\").instance(0)"));

        util.click(firstName);
        firstName.sendKeys("Krish");

        ExtentTestListener.logStep("First Name entered successfully");

        // HIDE KEYBOARD
        driver.hideKeyboard();

        // ENTER LAST NAME
        WebElement lastName = driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().className(\"android.widget.EditText\").instance(2)"
                )
        );
        util.click(lastName);

        lastName.sendKeys("Krishnan");

        ExtentTestListener.logStep("Last Name entered successfully");

        // HIDE KEYBOARD
        try {
            driver.hideKeyboard();
        } catch (Exception e) {
            ExtentTestListener.logStep("Keyboard not visible");
        }


        // CLICK GENDER DROPDOWN
        util.click(util.waitForAccessibilityId("Select Gender"));

        ExtentTestListener.logStep("Gender dropdown clicked");

        // SELECT MALE
        util.click(util.waitForAccessibilityId("Male"));

        ExtentTestListener.logStep("Male selected successfully");

        // SCROLL LITTLE DOWN
        driver.executeScript(
                "mobile: swipeGesture",
                java.util.Map.of(
                        "left", 300,
                        "top", 1200,
                        "width", 400,
                        "height", 600,
                        "direction", "up",
                        "percent", 0.50
                )
        );

        MobileNumber mobileUtil = new MobileNumber();

        String mobile = mobileUtil.getUniqueMobileNumber(city);

        ExtentTestListener.logStep("Generated Mobile Number : " + mobile);

        // ENTER MOBILE NUMBER
        WebElement mobileNumber = driver.findElement(
                AppiumBy.xpath("(//android.widget.EditText)[4]")
        );
        util.waitForElement(mobileNumber);

        util.click(mobileNumber);

        mobileNumber.sendKeys(mobile);

        //previous no used for registration        0500121212
        //                                         0500098765
        // mobileNumber.sendKeys("0500987654");

        ExtentTestListener.logStep("Mobile Number entered successfully");

        Thread.sleep(2000);


        // PRESS TAB / NEXT
        driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(
                io.appium.java_client.android.nativekey.AndroidKey.TAB));

        Thread.sleep(2000);

        // ENTER PASSWORD
        driver.switchTo().activeElement().sendKeys("Admin@194");

        ExtentTestListener.logStep("Password entered successfully");
        Thread.sleep(2000);


        // PRESS TAB / NEXT
        driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(
                io.appium.java_client.android.nativekey.AndroidKey.TAB
        ));

        Thread.sleep(2000);


        // SCROLL DOWN (ENSURE FIELD IS VISIBLE)
        driver.executeScript(
                "mobile: scrollGesture",
                java.util.Map.of(
                        "left", 100,
                        "top", 300,
                        "width", 600,
                        "height", 900,
                        "direction", "down",
                        "percent", 0.6
                )
        );

        Thread.sleep(2000);


        // CLICK CONFIRM PASSWORD DIRECTLY
        WebElement confirmPassword = driver.findElement(
                AppiumBy.xpath("//android.widget.ScrollView//android.widget.EditText[4]")
        );

        confirmPassword.click();

        Thread.sleep(2000);


        // ENTER CONFIRM PASSWORD
        confirmPassword.sendKeys("Admin@194");

        ExtentTestListener.logStep("Confirm Password entered successfully");

        Thread.sleep(2000);

        try {
            driver.hideKeyboard();
        } catch (Exception e) {
            System.out.println("Keyboard not visible");
        }

        // CLICK TERMS CHECKBOX
        WebElement checkbox = driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().className(\"android.view.View\").instance(9)"
                )
        );

        checkbox.click();

        ExtentTestListener.logStep("Terms checkbox selected successfully");


        // CLICK REGISTER BUTTON
        WebElement registerBtn = driver.findElement(
                AppiumBy.accessibilityId("Register")
        );

        registerBtn.click();

        ExtentTestListener.logStep("Register button clicked successfully");

        Thread.sleep(5000);


        //CLICK OK BUTTON
        WebElement okBtn = driver.findElement(
                AppiumBy.accessibilityId("OK")
        );

        okBtn.click();

        ExtentTestListener.logStep("OTP sent successfully popup OK clicked");

        String otp = mobileUtil.getOTP(mobile);

        ExtentTestListener.logStep("Generated OTP : " + otp);

        // WAIT 30 SECONDS FOR MANUAL OTP ENTRY
        ExtentTestListener.logStep("Please enter OTP manually within 30 seconds");

        Thread.sleep(30000);


        // CLICK CONFIRM BUTTON
        WebElement confirmBtn = driver.findElement(
                AppiumBy.accessibilityId("Confirm")
        );

        confirmBtn.click();

        ExtentTestListener.logStep("OTP Confirm button clicked successfully");


        // WAIT FOR REGISTRATION SUCCESS POPUP
        Thread.sleep(5000);


        // CLICK SUCCESS OK BUTTON
        WebElement successOkBtn = driver.findElement(
                AppiumBy.accessibilityId("OK")
        );

        successOkBtn.click();

        ExtentTestListener.logStep("Registration Success OK button clicked");

    }
}