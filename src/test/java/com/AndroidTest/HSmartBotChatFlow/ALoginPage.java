package com.AndroidTest.HSmartBotChatFlow;
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


        // Click Log in button
        WebElement logInBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Log in")));

        logInBtn.click();

        ExtentTestListener.logStep("Log In Button Clicked");

        Thread.sleep(2000);


        // Mobile Number
        WebElement mobile = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("(//android.widget.EditText)[1]")
                )
        );

        mobile.click();
        mobile.sendKeys("0500098765");

        ExtentTestListener.logStep("Mobile number entered");


        // Password
        WebElement password = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("(//android.widget.EditText)[2]")
                )
        );

        password.click();
        password.sendKeys("Admin@194");
        ExtentTestListener.logStep("Password entered");


        // Hide Keyboard
        driver.hideKeyboard();
        Thread.sleep(2000);

        // LOGIN BUTTON
        WebElement loginBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("LOGIN")
                )
        );

        loginBtn.click();

        ExtentTestListener.logStep("Login button clicked");


        // WAIT AFTER LOGIN
        Thread.sleep(7000);
    }
}