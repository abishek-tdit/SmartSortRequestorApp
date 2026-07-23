package com.AndroidTest.DRequestorDirectDeliveryOrderPlacingFlow;

import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;

public class DScheduleDatePage {

    AndroidDriver driver;
    WebDriverWait wait;

    public DScheduleDatePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickScheduleDate() {

        //Scroll down
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));

        WebElement scheduleDate = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        AppiumBy.xpath(
                                "//android.view.View[@hint='Schedule Date *']")));

        scheduleDate.click();
    }

    public void selectTodayDateAndClickOK() {

        String today = String.valueOf(LocalDate.now().getDayOfMonth());

        By todayDate = AppiumBy.xpath(
                "//*[contains(@content-desc,'" + today + ",')]");

        WebElement date = wait.until(
                ExpectedConditions.elementToBeClickable(todayDate));

        date.click();

        WebElement ok = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("OK")));

        ok.click();
    }


    public void clickScheduleTime() {

        WebElement timeField = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        AppiumBy.xpath("//android.view.View[@hint='Schedule Time *']")));

        timeField.click();

        ExtentTestListener.logStep("Schedule Time clicked");
    }


    public void selectScheduleTime() throws InterruptedException {

        try {



            // Check if keyboard icon exists
            if (!driver.findElements(
                    AppiumBy.accessibilityId("Switch to text input mode")
            ).isEmpty()) {

                driver.findElement(
                        AppiumBy.accessibilityId("Switch to text input mode")
                ).click();

                ExtentTestListener.logStep("Time Picker opened");

            }else {

                System.out.println("Time Picker NOT opened");
                return;
            }

            //Hour
            WebElement hour = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("(//android.widget.EditText)[1]")));

            // Clear existing value
            hour.click();
            hour.clear();
            hour.sendKeys("9");

            ExtentTestListener.logStep("Hour changed to 9");

            // Minute
            WebElement minute = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("(//android.widget.EditText)[2]")));

            minute.click();
            minute.clear();
            minute.sendKeys("00");

            ExtentTestListener.logStep("Minutes changed to 00");

            // PM
            driver.findElement(
                            AppiumBy.accessibilityId("PM"))
                    .click();

            // OK
            driver.findElement(
                    AppiumBy.accessibilityId("OK")
            ).click();

            System.out.println("Time selected");

        }
        catch (Exception e) {

            System.out.println("Time Picker not displayed");
            e.printStackTrace();
        }
    }

    public void clickContinue() {

        try {

        } catch (Exception ignored){
        }

        // Scroll down once
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));

        // Wait for Continue
        WebElement continueBtn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.accessibilityId("Continue")));

        // Click Continue
        continueBtn.click();

        System.out.println("Continue clicked");
    }

    public void clickConfirmAndOK() {

        // Click Confirm
        wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.accessibilityId("Confirm")));

        driver.findElement(
                        AppiumBy.accessibilityId("Confirm"))
                .click();

        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Click OK popup
        wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.accessibilityId("OK")));

        driver.findElement(
                        AppiumBy.accessibilityId("OK"))
                .click();

        System.out.println("Ok Popup clicked");
    }
}