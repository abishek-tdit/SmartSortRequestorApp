package com.AndroidTest.JProfileViewBasicFeaturesFlow;

import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class LWhatsNewPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public LWhatsNewPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void verifyWhatsNewFeature() throws InterruptedException {

        Thread.sleep(1500);
        //Click More Dropdown
        WebElement moreBtn = driver.findElement(AppiumBy.accessibilityId("More"));

        ((JavascriptExecutor) driver).executeScript(
                "mobile: clickGesture",
                Map.of(
                        "x", 70,
                        "y", 670
                )
        );

        ExtentTestListener.logStep("More Clicked");

        // CLICK WHAT'S NEW
        WebElement whatsNew = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("What's New")));

        whatsNew.click();

        ExtentTestListener.logStep("What's New Clicked");
        Thread.sleep(5000);

        // SWIPE LEFT 4 TIMES
        for (int i = 1; i <= 4; i++) {

            driver.executeScript("mobile: swipeGesture",
                    java.util.Map.of(
                            "left", 50,
                            "top", 600,
                            "width", 600,
                            "height", 300,
                            "direction", "left",
                            "percent", 0.75));

            ExtentTestListener.logStep("Swipe Left Count : " + i);

            Thread.sleep(2000);
        }

        // CLICK BACK BUTTON
        wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.xpath("//android.widget.Button")));

        driver.findElement(
                AppiumBy.xpath("//android.widget.Button")).click();

        ExtentTestListener.logStep("Back Button Clicked");
        Thread.sleep(3000);
    }
}