package com.AndroidTest.ERequestorRedeemFlow;
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

        // Wait App Open
        Thread.sleep(5000);


        // Click Log In button
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
        mobile.clear();
        mobile.sendKeys(mobileNo);

        System.out.println("Mobile Number Entered");

        // Password
        WebElement password = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("(//android.widget.EditText)[2]")));

        password.click();
        password.clear();
        password.sendKeys(passwordText);

        System.out.println("Password Entered");

        // Close keyboard safely
        try {
            driver.navigate().back();
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Keyboard already hidden");
        }

        // Login Button
        WebElement loginBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("LOGIN")));

        loginBtn.click();

        System.out.println("Login Button Clicked");


        // WAIT AFTER LOGIN
        Thread.sleep(5000);
    }
}