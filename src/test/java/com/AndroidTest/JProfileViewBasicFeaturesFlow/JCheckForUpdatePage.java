package com.AndroidTest.JProfileViewBasicFeaturesFlow;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JCheckForUpdatePage extends BaseClassMobile {

    AndroidDriver driver;
    WebDriverWait wait;

    public JCheckForUpdatePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickCheckForUpdate() throws Exception {
        //scroll down
        scrollDown();
        // Click Check for Update
        WebElement checkForUpdate = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Check for update"))
        );

        checkForUpdate.click();
        ExtentTestListener.logStep("Check for Update Clicked");

        // Wait for page/dialog to load
        Thread.sleep(3000);

        // Navigate back
        driver.navigate().back();

        ExtentTestListener.logStep("Navigated Back");
    }
}