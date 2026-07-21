package com.AndroidTest.JProfileViewBasicFeaturesFlow;

import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MThemeAndLanguagePage {

    AndroidDriver driver;
    WebDriverWait wait;

    public MThemeAndLanguagePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void verifySettingsFeatures() throws InterruptedException {

        // CLICK DARK MODE
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Off")
        )).click();

        ExtentTestListener.logStep("Dark Mode Clicked");

        Thread.sleep(3000);

        // CLICK ON
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("On")
        )).click();

        ExtentTestListener.logStep("Dark Mode ON Clicked");

        Thread.sleep(3000);

        // CLICK DARK MODE AGAIN
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("On")
        )).click();

        ExtentTestListener.logStep("Dark Mode Clicked Again");

        Thread.sleep(3000);

        // CLICK OFF
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Off")
        )).click();

        ExtentTestListener.logStep("Dark Mode OFF Clicked");

        Thread.sleep(3000);


        // CLICK LANGUAGE (EN)
        WebElement languageBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.widget.Button[@content-desc='EN\nLanguage']")
                )
        );

        languageBtn.click();

        ExtentTestListener.logStep("Language Option Clicked");

        Thread.sleep(3000);

        // CHANGE TO ARABIC
        WebElement arabicBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.widget.Button[@content-desc='ع\nعربي']")
                )
        );

        arabicBtn.click();

        ExtentTestListener.logStep("Arabic Language Selected");

        Thread.sleep(5000);

        // CLICK LANGUAGE AGAIN (ARABIC SCREEN)
        WebElement arabicLanguageMenu = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.widget.Button[@content-desc='ع\nاللغة']")
                )
        );

        arabicLanguageMenu.click();

        ExtentTestListener.logStep("Arabic Language Menu Clicked");

        Thread.sleep(3000);

        // CHANGE BACK TO ENGLISH
        WebElement englishBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.widget.Button[@content-desc='EN\nEnglish']")
                )
        );

        englishBtn.click();

        ExtentTestListener.logStep("English Language Selected");

        Thread.sleep(5000);
        driver.navigate().back();
    }
}
