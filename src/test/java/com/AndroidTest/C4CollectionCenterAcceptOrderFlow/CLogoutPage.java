package com.AndroidTest.C4CollectionCenterAcceptOrderFlow;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class CLogoutPage extends BaseClassMobile {

    AndroidDriver driver;
    WebDriverWait wait;

    public CLogoutPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void logout() throws Exception {

        // Scroll down once
        scrollDown();
        scrollDown();

        // Click Account
        WebElement account = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Account")));

        account.click();

        ExtentTestListener.logStep("Clicked Account");

        // Scroll until "logout" is visible
        WebElement logoutBtn = driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))"
                                + ".scrollIntoView(new UiSelector().description(\"logout\"))"));

        ExtentTestListener.logStep("Scrolled to logout");

        Thread.sleep(3000);

        // Click logout
        wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));

        driver.executeScript(
                "mobile: clickGesture",
                Map.of(
                        "elementId",
                        ((RemoteWebElement) logoutBtn).getId()));

        ExtentTestListener.logStep("Clicked logout");
    }
}