package com.AndroidTest.JProfileViewBasicFeaturesFlow;

import Base.BasePage;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MThemeAndLanguagePage extends BasePage {

    public MThemeAndLanguagePage(AndroidDriver driver) {
        super(driver);
    }

    public void verifySettingsFeatures() {

        //===========================
        // DARK MODE ON
        //===========================

        wait.until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Off")))
                .click();

        ExtentTestListener.logStep("Dark Mode Clicked");

        wait.until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("On")))
                .click();

        ExtentTestListener.logStep("Dark Mode ON Clicked");

        //===========================
        // DARK MODE OFF
        //===========================

        wait.until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("On")))
                .click();

        ExtentTestListener.logStep("Dark Mode Clicked Again");

        wait.until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Off")))
                .click();

        ExtentTestListener.logStep("Dark Mode OFF Clicked");

        //===========================
        // CHANGE TO ARABIC
        //===========================

        WebElement languageBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.widget.Button[@content-desc='EN\nLanguage']")));

        languageBtn.click();

        ExtentTestListener.logStep("Language Option Clicked");

        WebElement arabicBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.widget.Button[@content-desc='ع\nعربي']")));

        arabicBtn.click();

        ExtentTestListener.logStep("Arabic Language Selected");

        //===========================
        // CHANGE BACK TO ENGLISH
        //===========================

        WebElement arabicLanguageMenu = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.widget.Button[@content-desc='ع\nاللغة']")));

        arabicLanguageMenu.click();

        ExtentTestListener.logStep("Arabic Language Menu Clicked");

        WebElement englishBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.widget.Button[@content-desc='EN\nEnglish']")));

        englishBtn.click();

        ExtentTestListener.logStep("English Language Selected");

        //===========================
        // BACK
        //===========================

        driver.navigate().back();

        ExtentTestListener.logStep("Navigated Back");
    }
}