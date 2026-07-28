package com.AndroidTest.JProfileViewBasicFeaturesFlow;

import Base.BasePage;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

public class LWhatsNewPage extends BasePage {

    public LWhatsNewPage(AndroidDriver driver) {
        super(driver);
    }

    public void verifyWhatsNewFeature() {

        // Click More
        wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.accessibilityId("More")));

        ((JavascriptExecutor) driver).executeScript(
                "mobile: clickGesture",
                Map.of(
                        "x", 70,
                        "y", 670
                )
        );

        ExtentTestListener.logStep("More Clicked");

        // Click What's New
        WebElement whatsNew = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("What's New")));

        whatsNew.click();

        ExtentTestListener.logStep("What's New Clicked");

        // Swipe Left 4 Times
        for (int i = 1; i <= 4; i++) {

            driver.executeScript(
                    "mobile: swipeGesture",
                    Map.of(
                            "left", 50,
                            "top", 600,
                            "width", 600,
                            "height", 300,
                            "direction", "left",
                            "percent", 0.75
                    )
            );

            ExtentTestListener.logStep("Swipe Left Count : " + i);
        }

        // Click Back Button
        wait.until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.widget.Button")))
                .click();

        ExtentTestListener.logStep("Back Button Clicked");
    }
}