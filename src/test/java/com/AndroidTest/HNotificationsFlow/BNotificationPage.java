package com.AndroidTest.HNotificationsFlow;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BNotificationPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public BNotificationPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    //FIXED ICON LOCATOR (BEST FOR YOUR CASE)
    By notificationIcon = AppiumBy.androidUIAutomator(
            "new UiSelector().className(\"android.widget.ImageView\").instance(1)"
    );

    //Only real notifications
    By allNotifications = AppiumBy.xpath("//android.view.View[contains(@content-desc,'Dear')]");

    By detailHeader = AppiumBy.xpath("//android.view.View[contains(@content-desc,'Detail')]");


    //STEP 1
    public void clickNotificationIcon() {

        try {
            Thread.sleep(2000);
        } catch (Exception ignored) {
        }

        wait.until(ExpectedConditions.elementToBeClickable(notificationIcon));
        driver.findElement(notificationIcon).click();

        System.out.println("Notification icon clicked");

        //VERIFY page changed (VERY IMPORTANT)
        try {
            Thread.sleep(3000);
        } catch (Exception ignored) {
        }
    }

    //STEP 2 (STRONG VALIDATION)
    public boolean isNotificationScreenDisplayed() {
        try {

            wait.until(ExpectedConditions.presenceOfElementLocated(allNotifications));

            System.out.println("Notification screen opened");
            return true;

        } catch (Exception e) {
            System.out.println("Notification screen NOT opened");
            System.out.println(driver.getPageSource());
            return false;
        }
    }

    //STEP 3
    public void printAllNotifications() {

        List<org.openqa.selenium.WebElement> list = driver.findElements(allNotifications);

        System.out.println("Total notifications: " + list.size());

        for (int i = 0; i < list.size(); i++) {

            System.out.println("Notification " + (i + 1));
            System.out.println(list.get(i).getAttribute("content-desc"));
            System.out.println("----------------------");
        }
    }

    //STEP 4
    public String getFirstNotificationText() {
        return driver.findElements(allNotifications)
                .get(0)
                .getAttribute("content-desc");
    }

    //STEP 5
    public void clickFirstNotification() {

        List<org.openqa.selenium.WebElement> list = driver.findElements(allNotifications);

        if (list.isEmpty()) {
            throw new RuntimeException("No notifications found");
        }

        list.get(0).click();
        System.out.println("First notification clicked");

        try {
            Thread.sleep(2000);
        } catch (Exception ignored) {
        }
    }

    //STEP 6
    public boolean isNotificationDetailDisplayed() {
        try {

            wait.until(ExpectedConditions.presenceOfElementLocated(detailHeader));

            System.out.println("Detail screen opened");
            return true;

        } catch (Exception e) {
            System.out.println("Detail screen NOT opened");
            System.out.println(driver.getPageSource());
            return false;
        }
    }

    //STEP 7

    public void goBack() {
        driver.navigate().back();
        System.out.println("Back to list");

        try { Thread.sleep(2000); } catch (Exception ignored) {}
    }


    //STEP 8
    public void validateNotificationRead(String before, String after) {

        System.out.println("========== READ VALIDATION ==========");
        System.out.println("Before:\n" + before);
        System.out.println("After:\n" + after);

        if (before.equals(after)) {
            System.out.println("⚠️ Same content → UI may not change");
        } else {
            System.out.println("Notification updated");
        }
    }

    //STEP 9
    public void scrollDown() {

        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"
        ));

        System.out.println("Scrolled down");

        try {
            Thread.sleep(2000);
        } catch (Exception ignored) {
        }
    }

    //STEP 10
    public int getNotificationCount() {
        return driver.findElements(allNotifications).size();


    }

    //LOOP THROUGH ALL NOTIFICATIONS
    public void verifyAllNotifications() {

        System.out.println("Starting loop verification...");

        for (int i = 0; i < driver.findElements(allNotifications).size(); i++) {

            //Always get fresh list
            List<org.openqa.selenium.WebElement> list = driver.findElements(allNotifications);

            //Safety check
            if (i >= list.size()) break;

            System.out.println("➡️ Opening Notification " + (i + 1));

            list.get(i).click();

            try {
                Thread.sleep(2000);
            } catch (Exception ignored) {
            }

            //Validate detail page
            if (isNotificationDetailDisplayed()) {
                System.out.println("Detail opened for item " + (i + 1));
            } else {
                System.out.println("❌ Detail failed for item " + (i + 1));
            }

            //Go back
            goBack();

            //Wait for list again
            isNotificationScreenDisplayed();
        }

        System.out.println("ALL NOTIFICATIONS LOOP COMPLETED");
    }


    // ✅ METHOD SHOULD BE OUTSIDE ABOVE METHOD
    public void clickBackButton() {

        By backButton = AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.view.View\").clickable(true).instance(0)"
        );

        wait.until(ExpectedConditions.elementToBeClickable(backButton)).click();

        System.out.println("✅ Back button clicked");
    }

}