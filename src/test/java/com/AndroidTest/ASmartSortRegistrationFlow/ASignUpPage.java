package com.AndroidTest.ASmartSortRegistrationFlow;

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


        // WAIT FOR APP LOAD
        Thread.sleep(5000);


        // CLICK REGISTER BUTTON
        WebElement registerBtnHome = driver.findElement(
                AppiumBy.accessibilityId("Register")
        );

        driver.executeScript(
                "mobile: clickGesture",
                java.util.Map.of(
                        "elementId",
                        ((org.openqa.selenium.remote.RemoteWebElement) registerBtnHome).getId()
                )
        );

        System.out.println("Home Register button clicked");

        Thread.sleep(3000);


        // CLICK SELECT CITY DROPDOWN
        WebElement selectCityDropdown = driver.findElement(
                AppiumBy.accessibilityId("Select City")
        );

        driver.executeScript(
                "mobile: clickGesture",
                java.util.Map.of(
                        "elementId",
                        ((org.openqa.selenium.remote.RemoteWebElement) selectCityDropdown).getId()
                )
        );

        System.out.println("Select City dropdown clicked");


        // WAIT FOR DROPDOWN OPTIONS
        Thread.sleep(2000);


        // SELECT CITY NAME
        WebElement cityName = driver.findElement(
                AppiumBy.accessibilityId("Bqaiq")
        );

        driver.executeScript(
                "mobile: clickGesture",
                java.util.Map.of(
                        "elementId",
                        ((org.openqa.selenium.remote.RemoteWebElement) cityName).getId()
                )
        );

        System.out.println("City selected successfully");


        // WAIT AFTER CITY SELECTION
        Thread.sleep(2000);


        // CLICK REQUESTOR TYPE DROPDOWN
        WebElement requestorTypeDropdown = driver.findElement(
                AppiumBy.accessibilityId("Select Requestor Type")
        );

        driver.executeScript(
                "mobile: clickGesture",
                java.util.Map.of(
                        "elementId",
                        ((org.openqa.selenium.remote.RemoteWebElement)
                                requestorTypeDropdown).getId()
                )
        );

        System.out.println("Requestor Type dropdown clicked");


        // WAIT FOR DROPDOWN OPTIONS
        Thread.sleep(2000);


        // SELECT REQUESTOR TYPE
        WebElement requestorType = driver.findElement(
                AppiumBy.accessibilityId("Domestic Requestor")
        );

        driver.executeScript(
                "mobile: clickGesture",
                java.util.Map.of(
                        "elementId",
                        ((org.openqa.selenium.remote.RemoteWebElement)
                                requestorType).getId()
                )
        );

        System.out.println("Domestic Requestor selected successfully");

        // WAIT AFTER REQUESTOR TYPE SELECTION
        Thread.sleep(4000);


        // SCROLL DOWN LITTLE
        driver.executeScript(
                "mobile: swipeGesture",
                java.util.Map.of(
                        "left", 500,
                        "top", 1500,
                        "width", 300,
                        "height", 600,
                        "direction", "up",
                        "percent", 0.75
                )
        );

        Thread.sleep(3000);


        // ENTER FIRST NAME
        WebElement firstName = driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().className(\"android.widget.EditText\").instance(0)"
                )
        );

        firstName.click();
        firstName.sendKeys("Ram");

        System.out.println("First Name entered");

        Thread.sleep(2000);


        // HIDE KEYBOARD
        driver.hideKeyboard();

        Thread.sleep(2000);


        // ENTER MIDDLE NAME
        WebElement middleName = driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().className(\"android.widget.EditText\").instance(1)"
                )
        );

        middleName.click();
        middleName.sendKeys("Kumar");

        System.out.println("Middle Name entered");

        Thread.sleep(2000);


        // HIDE KEYBOARD
        driver.hideKeyboard();

        Thread.sleep(2000);


        // ENTER LAST NAME
        WebElement lastName = driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().className(\"android.widget.EditText\").instance(2)"
                )
        );

        lastName.click();
        lastName.sendKeys("RR");

        System.out.println("Last Name entered successfully");

        Thread.sleep(2000);


        // HIDE KEYBOARD
        try {
            driver.hideKeyboard();
        } catch (Exception e) {
            System.out.println("Keyboard not visible");
        }

        Thread.sleep(2000);


        // CLICK GENDER DROPDOWN
        WebElement genderDropdown = driver.findElement(
                AppiumBy.accessibilityId("Select Gender")
        );

        genderDropdown.click();

        System.out.println("Gender dropdown clicked");

        Thread.sleep(2000);


        // SELECT MALE
        WebElement maleOption = driver.findElement(
                AppiumBy.accessibilityId("Male")
        );

        maleOption.click();

        System.out.println("Male selected successfully");

        Thread.sleep(2000);


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

        Thread.sleep(3000);


        // ENTER MOBILE NUMBER
        WebElement mobileNumber = driver.findElement(
                AppiumBy.xpath("(//android.widget.EditText)[4]")
        );

        mobileNumber.click();

        Thread.sleep(2000);


        //previous no used for registration        0500121212
        mobileNumber.sendKeys("0500120101");

        System.out.println("Mobile Number entered successfully");

        Thread.sleep(2000);


        // PRESS TAB / NEXT
        driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(
                io.appium.java_client.android.nativekey.AndroidKey.TAB
        ));

        Thread.sleep(2000);


        // ENTER PASSWORD
        driver.switchTo().activeElement().sendKeys("Admin@194");

        System.out.println("Password entered successfully");

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

        System.out.println("Confirm Password entered successfully");

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

        System.out.println("Terms checkbox selected successfully");


        // CLICK REGISTER BUTTON
        WebElement registerBtn = driver.findElement(
                AppiumBy.accessibilityId("Register")
        );

        registerBtn.click();

        System.out.println("Register button clicked successfully");


        // WAIT FOR OTP SUCCESS POPUP
        Thread.sleep(5000);


        // CLICK OK BUTTON
        WebElement okBtn = driver.findElement(
                AppiumBy.accessibilityId("OK")
        );

        okBtn.click();

        System.out.println("OTP sent successfully popup OK clicked");


        // WAIT 30 SECONDS FOR MANUAL OTP ENTRY
        System.out.println("Please enter OTP manually within 30 seconds");

        Thread.sleep(30000);


        // CLICK CONFIRM BUTTON
        WebElement confirmBtn = driver.findElement(
                AppiumBy.accessibilityId("Confirm")
        );

        confirmBtn.click();

        System.out.println("OTP Confirm button clicked successfully");


        // WAIT FOR REGISTRATION SUCCESS POPUP
        Thread.sleep(5000);


        // CLICK SUCCESS OK BUTTON
        WebElement successOkBtn = driver.findElement(
                AppiumBy.accessibilityId("OK")
        );

        successOkBtn.click();

        System.out.println("Registration Success OK button clicked");
    }
}