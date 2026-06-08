package com.AndroidTest.BSmartSortOrderPlacingFlow;

import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ALoginPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public ALoginPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void login(String mobileNo, String passwordText) throws Exception {

        Thread.sleep(4000);


        // Click Log in button
        WebElement logInBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Log in")));

        logInBtn.click();

        System.out.println("Log In Button Clicked");

        if (ExtentTestListener.getTest() != null) {
            ExtentTestListener.getTest().pass("Log in button clicked");
        }

        Thread.sleep(2000);

        // Mobile Number
        WebElement mobile = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("(//android.widget.EditText)[1]")));

        mobile.click();
        mobile.sendKeys("0500123456");

        System.out.println("Mobile Number Entered");

        if (ExtentTestListener.getTest() != null) {
            ExtentTestListener.getTest().pass("Mobile number entered");
        }


        // Password
        WebElement password = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("(//android.widget.EditText)[2]")));

        password.click();
        password.sendKeys("Admin@194");

        System.out.println("Password Entered");

        if (ExtentTestListener.getTest() != null) {
            ExtentTestListener.getTest().pass("Password entered");
        }
        driver.hideKeyboard();
        Thread.sleep(2000);


        // LOGIN Button
        WebElement loginBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("LOGIN")));

        loginBtn.click();

        System.out.println("LOGIN Button Clicked");

        if (ExtentTestListener.getTest() != null) {
            ExtentTestListener.getTest().pass("Login button clicked");
        }

        Thread.sleep(5000);
    }
}