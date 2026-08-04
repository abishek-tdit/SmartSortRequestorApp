package com.AndroidTest.BSmartSortRegistrationArabicFlow;

import Base.ExtentTestListener;
import Utility.MobileUtility;
import com.AndroidTest.BSmartSortRegistrationArabicFlow.BMobileNumber;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.Map;
import java.util.Scanner;

public class ASignUpArabicPage {

    AndroidDriver driver;
    MobileUtility util;
    WebDriverWait wait;
    BMobileNumber mobileUtil;

    // Constructor
    public ASignUpArabicPage(AndroidDriver driver) {

        this.driver = driver;
        this.util = new MobileUtility(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        mobileUtil = new BMobileNumber();
    }

    // Wait until visible
    private WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait and Click
    private void waitAndClick(By locator) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));

        wait.until(ExpectedConditions.elementToBeClickable(element));

        try {
            element.click();
        } catch (Exception e) {
            clickGesture(element);
        }

    }
    // Wait and SendKeys
    private void waitAndSendKeys(By locator, String text) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));

        element.click();
        element.clear();
        element.sendKeys(text);
    }

    // Hide Keyboard
    private void hideKeyboard() {

        try {
            driver.hideKeyboard();
        } catch (Exception e) {
            System.out.println("Keyboard already hidden");
        }
    }

    // Click Gesture
    private void clickGesture(WebElement element) {

        driver.executeScript(
                "mobile: clickGesture",
                Map.of(
                        "elementId",
                        ((RemoteWebElement) element).getId()
                )
        );
        wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.className("android.widget.EditText")));

    }

    public void signUp() throws Exception {

        // LANGUAGE SELECTION
        waitAndClick(AppiumBy.accessibilityId("EN"));
        ExtentTestListener.logStep("Language button clicked");

        driver.findElement(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().descriptionContains(\"AR\")"))
                .click();
        ExtentTestListener.logStep("Arabic language selected");



        // SIGN-UP BUTTON
        WebElement registerBtnHome = waitForElement(
                AppiumBy.accessibilityId("ليس لديك حساب؟ تسجيل جديد"));

        clickGesture(registerBtnHome);

        ExtentTestListener.logStep("Arabic 'Sign Up' button clicked");


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

        ExtentTestListener.logStep("Arabic City dropdown clicked");

        wait.until(driver -> true);


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

        ExtentTestListener.logStep("Arabic city selected successfully");
        wait.until(driver -> true);


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

        ExtentTestListener.logStep("Arabic Requestor Type dropdown clicked");

        wait.until(driver -> true);


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

        ExtentTestListener.logStep("Arabic Domestic Requestor selected successfully");


        // WAIT AFTER REQUESTOR TYPE SELECTION
        wait.until(driver -> true);



        // SCROLL
        driver.executeScript(
                "mobile: swipeGesture",
                Map.of(
                        "left", 500,
                        "top", 1500,
                        "width", 300,
                        "height", 600,
                        "direction", "up",
                        "percent", 0.75
                )
        );
        wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.className("android.widget.EditText")));



        // FIRST NAME
        waitAndSendKeys(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().className(\"android.widget.EditText\").instance(0)"
                ),
                "رام"
        );

        ExtentTestListener.logStep("First Name entered");

        hideKeyboard();



        // MIDDLE NAME
        waitAndSendKeys(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().className(\"android.widget.EditText\").instance(1)"
                ),
                "كومار"
        );

        ExtentTestListener.logStep("Middle Name entered");

        hideKeyboard();



        // LAST NAME
        waitAndSendKeys(
                AppiumBy.xpath("//android.widget.EditText[@hint='اسم العائلة']"),
                "آر آر"
        );

        ExtentTestListener.logStep("Last Name entered");

        hideKeyboard();



        // GENDER
        waitAndClick(AppiumBy.accessibilityId("الجنس"));

        ExtentTestListener.logStep("Gender dropdown clicked");


        waitAndClick(AppiumBy.accessibilityId("ذكر"));

        ExtentTestListener.logStep("Male selected");


        // ENTER EMAIL ADDRESS (Optional)
        try {
            WebElement email = new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.presenceOfElementLocated(
                            AppiumBy.xpath("//android.widget.ScrollView/android.view.View/android.widget.EditText[4]")
                    ));

            if (email.isDisplayed()) {
                util.click(email);
                email.sendKeys("abishek251295@gmail.com");

                try { driver.hideKeyboard(); } catch (Exception ignored) {}

                ExtentTestListener.logStep("Email Address entered successfully");
            }

        } catch (Exception ignored) {
            ExtentTestListener.logStep("Email field not present. Continuing...");
        }


        // SCROLL TO MOBILE SECTION
        driver.executeScript(
                "mobile: swipeGesture",
                Map.of(
                        "left", 300,
                        "top", 1200,
                        "width", 400,
                        "height", 700,
                        "direction", "up",
                        "percent", 0.80
                )
        );
        wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.className("android.widget.EditText")));



        // MOBILE NUMBER
        String mobile = mobileUtil.getUniqueMobileNumber("bqaiq");

        waitAndSendKeys(
                AppiumBy.xpath("//android.widget.EditText[@hint='رقم الجوال']"),
                mobile
        );

        ExtentTestListener.logStep("Generated Mobile Number : " + mobile);
        ExtentTestListener.logStep("Arabic Mobile Number entered successfully");

        hideKeyboard();



        // SCROLL TO PASSWORD SECTION
        driver.executeScript(
                "mobile: swipeGesture",
                Map.of(
                        "left", 300,
                        "top", 1200,
                        "width", 400,
                        "height", 500,
                        "direction", "up",
                        "percent", 0.40
                )
        );
        wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.className("android.widget.EditText")));



        // PASSWORD
        waitAndSendKeys(
                AppiumBy.xpath("(//android.widget.EditText[@password='true'])[1]"),
                "Admin@194"
        );

        ExtentTestListener.logStep("Password entered successfully");

        hideKeyboard();



        // CONFIRM PASSWORD
        waitAndSendKeys(
                AppiumBy.xpath("(//android.widget.EditText[@password='true'])[2]"),
                "Admin@194"
        );

        ExtentTestListener.logStep("Confirm Password entered successfully");

        hideKeyboard();



        // CHECKBOX
        waitAndClick(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().className(\"android.view.View\").instance(9)"
                )
        );

        ExtentTestListener.logStep("Checkbox selected");



        // REGISTER BUTTON
        waitAndClick(AppiumBy.accessibilityId("تسجيل"));

        ExtentTestListener.logStep("Arabic Register button clicked successfully");



        // CONFIRM POPUP
        waitAndClick(AppiumBy.accessibilityId("تأكيد"));

        ExtentTestListener.logStep("Confirmation popup clicked successfully");
        Thread.sleep(5000);
        String otp = mobileUtil.getOTP(mobile);

        ExtentTestListener.logStep("OTP from DB : " + otp);


        Thread.sleep(6000);

        // OTP CONFIRM
        WebElement confirmButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("تأكيد")));

        confirmButton.click();

        ExtentTestListener.logStep("OTP Confirm button clicked");
        Thread.sleep(6000);


        // SUCCESS POPUP
        WebElement confirmBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("تأكيد")));

        confirmBtn.click();

        ExtentTestListener.logStep("Success popup Confirm button clicked");

        ExtentTestListener.logStep("======Arabic Registration Flow completed successfully======");
    }
}

