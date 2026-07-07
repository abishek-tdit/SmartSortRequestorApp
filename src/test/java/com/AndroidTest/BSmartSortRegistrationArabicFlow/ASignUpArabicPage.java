package com.AndroidTest.BSmartSortRegistrationArabicFlow;

import Utility.MobileUtility;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class ASignUpArabicPage {

    AndroidDriver driver;
    MobileUtility util;

    // CONSTRUCTOR
    public ASignUpArabicPage(AndroidDriver driver) {

        this.driver = driver;
        util = new MobileUtility(driver);
    }

    // SIGN UP FLOW
    public void signUp() throws Exception {

        // WAIT FOR APP LOAD
        Thread.sleep(5000);

        // CHANGE LANGUAGE ENGLISH TO ARABIC
        WebElement languageBtn = driver.findElement(
                AppiumBy.accessibilityId("EN"));

        languageBtn.click();

        System.out.println("Language button clicked");

        Thread.sleep(3000);


        // SELECT ARABIC
        WebElement arabicBtn = driver.findElement(
                AppiumBy.xpath("//android.widget.Button[@content-desc='ع\nعربي']"));
        arabicBtn.click();

        System.out.println("Arabic language selected");

        Thread.sleep(5000);


        // CLICK REGISTER BUTTON (ARABIC)
        WebElement registerBtnHome = driver.findElement(
                AppiumBy.accessibilityId("تسجيل"));

        assert ((org.openqa.selenium.remote.RemoteWebElement) registerBtnHome).getId() != null;
        driver.executeScript(
                "mobile: clickGesture",
                java.util.Map.of(
                        "elementId",
                        ((org.openqa.selenium.remote.RemoteWebElement) registerBtnHome).getId()));

        System.out.println("Arabic Register button clicked");

        Thread.sleep(3000);

        // CLICK CITY DROPDOWN (ARABIC)
        WebElement selectCityDropdown = driver.findElement(
                AppiumBy.accessibilityId("المدينة"));

        assert ((org.openqa.selenium.remote.RemoteWebElement)
                selectCityDropdown).getId() != null;
        driver.executeScript(
                "mobile: clickGesture",
                java.util.Map.of(
                        "elementId",
                        ((org.openqa.selenium.remote.RemoteWebElement)
                                selectCityDropdown).getId()));

        System.out.println("Arabic City dropdown clicked");

        Thread.sleep(2000);


        // SELECT BQAIQ (ARABIC)
        WebElement cityName = driver.findElement(
                AppiumBy.accessibilityId("بقيق"));

        assert ((org.openqa.selenium.remote.RemoteWebElement)
                cityName).getId() != null;
        driver.executeScript(
                "mobile: clickGesture",
                java.util.Map.of(
                        "elementId",
                        ((org.openqa.selenium.remote.RemoteWebElement)
                                cityName).getId()));

        System.out.println("Arabic city selected successfully");

        Thread.sleep(2000);

        // CLICK REQUESTOR TYPE DROPDOWN (ARABIC)
        WebElement requestorTypeDropdown = driver.findElement(
                AppiumBy.accessibilityId("نوع العميل"));

        assert ((org.openqa.selenium.remote.RemoteWebElement)
                requestorTypeDropdown).getId() != null;
        driver.executeScript(
                "mobile: clickGesture",
                java.util.Map.of(
                        "elementId",
                        ((org.openqa.selenium.remote.RemoteWebElement)
                                requestorTypeDropdown).getId()));

        System.out.println("Arabic Requestor Type dropdown clicked");

        Thread.sleep(2000);


        // SELECT DOMESTIC REQUESTOR (ARABIC)
        WebElement requestorType = driver.findElement(
                AppiumBy.accessibilityId("مستخدم فردي"));

        assert ((org.openqa.selenium.remote.RemoteWebElement)
                requestorType).getId() != null;
        driver.executeScript(
                "mobile: clickGesture",
                java.util.Map.of(
                        "elementId",
                        ((org.openqa.selenium.remote.RemoteWebElement)
                                requestorType).getId()));

        System.out.println("Arabic Domestic Requestor selected successfully");


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
        firstName.sendKeys("رام");

        System.out.println("Arabic First Name entered");

        Thread.sleep(2000);

        driver.hideKeyboard();

        Thread.sleep(2000);


        // ENTER MIDDLE NAME
        WebElement middleName = driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().className(\"android.widget.EditText\").instance(1)"
                )
        );

        middleName.click();
        middleName.sendKeys("كومار");

        System.out.println("Arabic Middle Name entered");

        Thread.sleep(2000);

        driver.hideKeyboard();

        Thread.sleep(2000);


        // ENTER LAST NAME
        WebElement lastName = driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().className(\"android.widget.EditText\").instance(2)"
                )
        );

        lastName.click();
        lastName.sendKeys("آر آر");

        System.out.println("Arabic Last Name entered");

        Thread.sleep(2000);

        //Hide-Keyboard
        try {
            driver.hideKeyboard();
        } catch (Exception e) {
            System.out.println("Keyboard not visible");
        }
        Thread.sleep(2000);


        // CLICK GENDER DROPDOWN (ARABIC)
        WebElement genderDropdown = driver.findElement(
                AppiumBy.accessibilityId("الجنس")
        );

        genderDropdown.click();

        System.out.println("Arabic Gender dropdown clicked");

        Thread.sleep(2000);


        // SELECT MALE (ARABIC)
        WebElement maleOption = driver.findElement(
                AppiumBy.accessibilityId("ذكر")
        );

        maleOption.click();

        System.out.println("Arabic Male selected successfully");

        Thread.sleep(3000);


        // SCROLL DOWN TO MOBILE SECTION
        driver.executeScript(
                "mobile: swipeGesture",
                java.util.Map.of(
                        "left", 300,
                        "top", 1200,
                        "width", 400,
                        "height", 700,
                        "direction", "up",
                        "percent", 0.80
                )
        );

        Thread.sleep(3000);


        // ENTER MOBILE NUMBER
        WebElement mobileNumber = driver.findElement(
                AppiumBy.xpath("//android.widget.EditText[@hint='رقم الجوال']")
        );

        mobileNumber.click();

        Thread.sleep(1000);
        // previous no used  0501020302, 0501020000
        mobileNumber.sendKeys("0500020001");

        System.out.println("Arabic Mobile Number entered successfully");

        Thread.sleep(2000);

        // HIDE KEYBOARD
        try {
            driver.hideKeyboard();
        } catch (Exception e) {
            System.out.println("Keyboard already hidden");
        }

        Thread.sleep(2000);

        // SCROLL LITTLE MORE TO PASSWORD SECTION
        driver.executeScript(
                "mobile: swipeGesture",
                java.util.Map.of(
                        "left", 300,
                        "top", 1200,
                        "width", 400,
                        "height", 500,
                        "direction", "up",
                        "percent", 0.40
                )
        );

        Thread.sleep(3000);

        // PASSWORD FIELD
        WebElement password = driver.findElement(
                AppiumBy.xpath("//android.widget.EditText[@password='true'][1]")
        );

        password.click();
        password.clear();
        password.sendKeys("Admin@194");

        System.out.println("Password entered successfully");

        Thread.sleep(2000);

        // HIDE KEYBOARD
        try {
            driver.hideKeyboard();
        } catch (Exception e) {
            System.out.println("Keyboard already hidden");
        }

        Thread.sleep(2000);

        // CONFIRM PASSWORD FIELD
        WebElement confirmPassword = driver.findElement(
                AppiumBy.xpath("(//android.widget.EditText[@password='true'])[2]")
        );

        confirmPassword.click();
        confirmPassword.clear();
        confirmPassword.sendKeys("Admin@194");

        System.out.println("Confirm Password entered successfully");

        Thread.sleep(2000);

        try {
            driver.hideKeyboard();
        } catch (Exception e) {
            System.out.println("Keyboard already hidden");
        }

        // CLICK CHECKBOX
        WebElement checkBox = driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().className(\"android.view.View\").instance(9)"
                )
        );

        checkBox.click();

        System.out.println("Checkbox selected");

        Thread.sleep(2000);

//        // CLICK REGISTER BUTTON
//        WebElement registerBtn = driver.findElement(
//                AppiumBy.accessibilityId("تسجيل")
//        );
//
//        registerBtn.click();
//
//        System.out.println("Arabic Register button clicked successfully");
//
//
//        Thread.sleep(5000);
//
//        // CLICK CONFIRMATION POPUP BUTTON
//        WebElement confirmBtn = driver.findElement(
//                AppiumBy.accessibilityId("تأكيد")
//        );
//
//        confirmBtn.click();
//
//        System.out.println("Arabic Confirmation popup clicked successfully");
//
//        Thread.sleep(3000);
//
//        // WAIT 30 SECONDS FOR MANUAL OTP ENTRY
//        System.out.println("Please enter OTP manually within 30 seconds");
//
//        Thread.sleep(30000);
//
//
//        // CLICK OTP CONFIRM BUTTON
//        WebElement otpConfirmBtn = driver.findElement(
//                AppiumBy.accessibilityId("تأكيد")
//        );
//
//        otpConfirmBtn.click();
//
//        System.out.println("OTP Confirm button clicked successfully");
//
//
//        // WAIT FOR SUCCESS POPUP
//        Thread.sleep(5000);
//
//
//        // CLICK SUCCESS POPUP OK BUTTON
//        WebElement successOkBtn = driver.findElement(
//                AppiumBy.accessibilityId("تأكيد")
//        );
//
//        successOkBtn.click();
//
//        System.out.println("Success popup OK button clicked successfully");

        Thread.sleep(3000);
    }
}
