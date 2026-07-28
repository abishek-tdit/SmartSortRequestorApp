package com.AndroidTest.FProfileViewBasicFeaturesFlow;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LThemeAndLanguagePage {

    AndroidDriver driver;
    WebDriverWait wait;

    public LThemeAndLanguagePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void verifySettingsFeatures() throws InterruptedException {

        // CLICK DARK MODE
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Off")
        )).click();

        System.out.println("Dark Mode Clicked");

        Thread.sleep(3000);

        // CLICK ON
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("On")
        )).click();

        System.out.println("Dark Mode ON Clicked");

        Thread.sleep(3000);

        // CLICK DARK MODE AGAIN
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("On")
        )).click();

        System.out.println("Dark Mode Clicked Again");

        Thread.sleep(3000);

        // CLICK OFF
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Off")
        )).click();

        System.out.println("Dark Mode OFF Clicked");

        Thread.sleep(3000);


        // CLICK LANGUAGE (EN)
        WebElement languageBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.widget.Button[@content-desc='EN\nLanguage']")
                )
        );

        languageBtn.click();

        System.out.println("Language Option Clicked");

        Thread.sleep(3000);

        // CHANGE TO ARABIC
        WebElement arabicBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.widget.Button[@content-desc='ع\nعربي']")
                )
        );

        arabicBtn.click();

        System.out.println("Arabic Language Selected");

        Thread.sleep(5000);

        // CLICK LANGUAGE AGAIN (ARABIC SCREEN)
        WebElement arabicLanguageMenu = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.widget.Button[@content-desc='ع\nاللغة']")
                )
        );

        arabicLanguageMenu.click();

        System.out.println("Arabic Language Menu Clicked");

        Thread.sleep(3000);

        // CHANGE BACK TO ENGLISH
        WebElement englishBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.widget.Button[@content-desc='EN\nEnglish']")
                )
        );

        englishBtn.click();

        System.out.println("English Language Selected");

        Thread.sleep(5000);


        // Click Logout
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("log out")
        )).click();

        System.out.println("Logout Clicked");

        Thread.sleep(5000);

        System.out.println("User Logged Out Successfully");

        // CLICK YES BUTTON ON LOGOUT POPUP
        try {

            WebElement yesBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            AppiumBy.accessibilityId("Yes")
                    )
            );

            yesBtn.click();

            System.out.println("Yes Button Clicked");

        } catch (Exception e) {

            System.out.println("Yes Button Not Found");
            e.printStackTrace();
        }

        Thread.sleep(3000);
    }
}