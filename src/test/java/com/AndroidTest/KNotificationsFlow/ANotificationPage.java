package com.AndroidTest.KNotificationsFlow;

import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ANotificationPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public ANotificationPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    // Notification Icon
    By notificationIcon = AppiumBy.androidUIAutomator(
            "new UiSelector().className(\"android.widget.ImageView\").instance(1)");

    // Notification Screen Title
    By notificationTitle = AppiumBy.accessibilityId("Notifications");

    // All Notification Cards
    By allNotifications = AppiumBy.xpath(
            "//android.view.View[@clickable='true' and @content-desc]");

    // Detail Screen
    By detailHeader = AppiumBy.xpath(
            "//android.view.View[contains(@content-desc,'Order Details')]");

    // Back Button
    By backButton = AppiumBy.androidUIAutomator(
            "new UiSelector().className(\"android.view.View\").clickable(true).instance(0)");

    // Delete Icon
    By deleteIcon = AppiumBy.xpath(
            "//android.widget.FrameLayout[@resource-id='android:id/content']" +
                    "/android.widget.FrameLayout/android.widget.FrameLayout" +
                    "/android.view.View/android.view.View/android.view.View" +
                    "/android.view.View/android.view.View[3]");

    // STEP 1
    public void clickNotificationIcon() {

        wait.until(ExpectedConditions.elementToBeClickable(notificationIcon)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(notificationTitle));

        ExtentTestListener.logStep("Notification screen opened");
    }

    // STEP 2
    public boolean isNotificationScreenDisplayed() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(allNotifications));
            ExtentTestListener.logStep("Notification screen opened");
            return true;
        } catch (Exception e) {
            ExtentTestListener.logStep("Notification screen NOT opened");
            return false;
        }
    }

    // STEP 3
    public void printAllNotifications() {

        List<WebElement> list = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(allNotifications));

        ExtentTestListener.logStep("Total Notifications : " + list.size());

        for (int i = 0; i < list.size(); i++) {

            String text = list.get(i).getAttribute("content-desc");

            ExtentTestListener.logStep("--------------------------------");

            ExtentTestListener.logStep("Notification " + (i + 1));

            ExtentTestListener.logStep(text);
        }
    }

    // STEP 4
    public String getFirstNotificationText() {

        List<WebElement> list = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(allNotifications));

        return list.get(0).getAttribute("content-desc");
    }

    // STEP 5
    public void clickFirstNotification() {

        List<WebElement> list = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(allNotifications));

        if (list.isEmpty()) {
            throw new RuntimeException("No notifications found.");
        }

        list.get(0).click();

        ExtentTestListener.logStep("First notification clicked");
    }

    // STEP 6
    public boolean isNotificationDetailDisplayed() {

        try {

            wait.until(ExpectedConditions.presenceOfElementLocated(detailHeader));

            ExtentTestListener.logStep("Notification detail screen opened");

            return true;

        } catch (Exception e) {

            ExtentTestListener.logStep("Notification detail screen NOT opened");

            return false;
        }
    }

    public boolean isStillOnNotificationScreen() {

        try {

            wait.until(ExpectedConditions.visibilityOfElementLocated(notificationTitle));

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    public boolean isHomeScreenDisplayed() {

        try {

            wait.until(ExpectedConditions.presenceOfElementLocated(
                    AppiumBy.xpath("//android.view.View[contains(@content-desc,'Welcome')]")));

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    // STEP 7
    public void goBack() {

        driver.navigate().back();

        wait.until(ExpectedConditions.visibilityOfElementLocated(notificationTitle));

        ExtentTestListener.logStep("Back to notification screen");
    }

    // STEP 8
    public void validateNotificationRead(String before, String after) {

        ExtentTestListener.logStep("========== READ VALIDATION ==========");

        if (before.equals(after)) {

            ExtentTestListener.logStep("Notification content unchanged");

        } else {

            ExtentTestListener.logStep("Notification updated");
        }
    }

    // STEP 9
    public void scrollDown() {

        driver.executeScript("mobile: scrollGesture",
                java.util.Map.of(
                        "left", 50,
                        "top", 250,
                        "width", 620,
                        "height", 1200,
                        "direction", "down",
                        "percent", 0.90));

        ExtentTestListener.logStep("Scrolled Down");
    }

    // STEP 10
    public int getNotificationCount() {

        return driver.findElements(allNotifications).size();
    }

    // Verify All Notifications
    public void verifyAllNotifications() throws Exception {

        Set<String> visited = new HashSet<>();

        while (true) {

            List<WebElement> notifications = wait.until(
                    ExpectedConditions.visibilityOfAllElementsLocatedBy(allNotifications));

            boolean foundNew = false;

            for (int i = 0; i < notifications.size(); i++) {

                // Reload elements every iteration to avoid stale element
                notifications = wait.until(
                        ExpectedConditions.visibilityOfAllElementsLocatedBy(allNotifications));

                WebElement notification = notifications.get(i);

                String text = notification.getAttribute("content-desc");

                if (visited.contains(text))
                    continue;

                foundNew = true;
                visited.add(text);

                ExtentTestListener.logStep("--------------------------------");
                ExtentTestListener.logStep("Notification : " + visited.size());
                ExtentTestListener.logStep(text);

                notification.click();

                Thread.sleep(2000);

                // If notification opened another screen,
                // keep pressing back until Notification page appears.
                while (!isStillOnNotificationScreen()) {

                    driver.navigate().back();

                    Thread.sleep(300);

                    if (isStillOnNotificationScreen()) {
                        break;
                    }
                }

                wait.until(ExpectedConditions.visibilityOfElementLocated(notificationTitle));

                Thread.sleep(300);
            }

            if (!foundNew)
                break;

            driver.executeScript("mobile: scrollGesture",
                    java.util.Map.of(
                            "left", 50,
                            "top", 250,
                            "width", 620,
                            "height", 1200,
                            "direction", "down",
                            "percent", 0.90));

            Thread.sleep(300);
        }

        ExtentTestListener.logStep("TOTAL VALIDATED : " + visited.size());
    }

    public void clickBackButton() {

        wait.until(ExpectedConditions.elementToBeClickable(backButton)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(notificationTitle));

        ExtentTestListener.logStep("Back button clicked");
    }


    public void deleteLastNotification() {

        List<WebElement> notifications = driver.findElements(allNotifications);

        if (notifications.isEmpty()) {
            throw new RuntimeException("No notifications available.");
        }

        notifications.get(notifications.size() - 1).click();

        wait.until(ExpectedConditions.elementToBeClickable(deleteIcon)).click();

        ExtentTestListener.logStep("Last notification deleted");
    }


    public void goToHomeFromNotification() {

        driver.navigate().back();

        try {

            wait.until(ExpectedConditions.visibilityOfElementLocated(notificationTitle));

            driver.navigate().back();

        }
        catch (Exception ignored) {
        }

        ExtentTestListener.logStep("Returned to Home Screen");
    }
}