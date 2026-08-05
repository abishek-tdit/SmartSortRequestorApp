package com.AndroidTest.C5CollectorNavigateToCollectionCenterFlow;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ALoginPage extends BaseClassMobile{

    public void login(String mobileNumber, String password) throws InterruptedException {

        try {
            //Mob-no
            ExtentTestListener.logStep("Entering Mobile Number...");

            WebElement mobileField = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.androidUIAutomator(
                                    "new UiSelector().className(\"android.widget.EditText\").instance(0)")));

            mobileField.click();
            mobileField.clear();
            mobileField.sendKeys(mobileNumber);

            //PASSWORD
            ExtentTestListener.logStep("Entering Password...");

            WebElement passwordField = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.androidUIAutomator(
                                    "new UiSelector().className(\"android.widget.EditText\").instance(1)")));

            passwordField.click();
            passwordField.clear();
            passwordField.sendKeys(password);
            driver.hideKeyboard();


            //Click Sign In
            ExtentTestListener.logStep("Clicking Sign In Button...");

            WebElement signInButton = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            AppiumBy.accessibilityId("Sign In")));

            signInButton.click();

            ExtentTestListener.logStep("Login Button Clicked Successfully");

        }
        catch (Exception e)
        {
            ExtentTestListener.logStep("Login Failed : " + e.getMessage());
            throw new RuntimeException("Login Flow Failed", e);
        }
    }
}

