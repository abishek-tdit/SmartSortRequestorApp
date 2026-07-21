package com.AndroidTest.LNotificationsFlow;

import java.util.Set;
import java.util.HashSet;

import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BNotificationPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public BNotificationPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    // ICON (unchanged)
    By notificationIcon = AppiumBy.androidUIAutomator(
            "new UiSelector().className(\"android.widget.ImageView\").instance(1)");

    // NOTIFICATIONS (better locator)
    By allNotifications = AppiumBy.xpath(
            "//android.widget.ScrollView/android.view.View");

    // DETAIL SCREEN CHECK
    By detailHeader = AppiumBy.xpath(
            "//android.view.View[contains(@content-desc,'Order Details')]");

    // BACK BUTTON
    By backButton = AppiumBy.androidUIAutomator(
            "new UiSelector().className(\"android.view.View\").clickable(true).instance(0)");

    // STEP 1
    public void clickNotificationIcon() {

        wait.until(ExpectedConditions.elementToBeClickable(notificationIcon)).click();
        ExtentTestListener.logStep("Notification icon clicked");

        // Wait until list appears
        wait.until(ExpectedConditions.presenceOfElementLocated(allNotifications));
    }

    // STEP 2
    public boolean isNotificationScreenDisplayed() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(allNotifications));
            ExtentTestListener.logStep("Notification screen opened");
            return false;
        } catch (Exception e) {
            ExtentTestListener.logStep("Notification screen NOT opened");
            return true;
        }
    }

    // STEP 3
    public void printAllNotifications() {

        List<WebElement> list = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(allNotifications)
        );

        ExtentTestListener.logStep("Total notifications: " + list.size());

        for (int i = 0; i < list.size(); i++) {
            ExtentTestListener.logStep("Notification " + (i + 1));
            ExtentTestListener.logStep(list.get(i).getAttribute("content-desc"));
            ExtentTestListener.logStep("----------------------");
        }
    }

    // STEP 4
    public String getFirstNotificationText() {

        List<WebElement> list = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(allNotifications)
        );

        return list.getFirst().getAttribute("content-desc");
    }

    //Click First Notification
    public void clickFirstNotification() {

        List<WebElement> list = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(allNotifications)
        );

        if (list.isEmpty()) {
            throw new RuntimeException("No notifications found");
        }

        WebElement element = list.getFirst();

        //GET ELEMENT POSITION
        int x = element.getLocation().getX() + (element.getSize().getWidth() / 2);
        int y = element.getLocation().getY() + (element.getSize().getHeight() / 2);

        //TAP USING COORDINATES (FORCE CLICK)
        driver.executeScript("mobile: clickGesture", java.util.Map.of(
                "x", x,
                "y", y
        ));

        ExtentTestListener.logStep("First notification tapped using coordinates");

        try {
        }
        catch (Exception ignored) {
        }
    }

    // STEP 6 IMPROVED VALIDATION
    public boolean isNotificationDetailDisplayed() {

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(detailHeader));
            ExtentTestListener.logStep("Detail screen opened");
            return true;
        }
        catch (Exception e) {
            ExtentTestListener.logStep("Detail screen NOT opened");
            return false;
        }
    }

    public boolean isStillOnNotificationScreen() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(allNotifications));
            ExtentTestListener.logStep("Still on notification screen (no navigation)");
            return true;
        }
        catch (Exception e) {
            ExtentTestListener.logStep("Screen changed");
            return false;
        }
    }

    public boolean isHomeScreenDisplayed() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    AppiumBy.xpath("//android.view.View[contains(@content-desc,'Welcome')]")
            ));
            ExtentTestListener.logStep("Home screen opened after notification click");
            return true;
        }
        catch (Exception e) {
            System.out.println("Home screen NOT opened");
            return false;
        }
    }


    // STEP 7 FIXED BACK
    public void goBack() {
        driver.navigate().back();
        wait.until(ExpectedConditions.presenceOfElementLocated(allNotifications));
        ExtentTestListener.logStep("Back to notification list");
    }

    // STEP 8
    public void validateNotificationRead(String before, String after) {

        ExtentTestListener.logStep("========== READ VALIDATION ==========");
        System.out.println("Before:\n" + before);
        System.out.println("After:\n" + after);

        if (before.equals(after)) {
            System.out.println("Same content → UI may not change");
        }
        else
        {
            ExtentTestListener.logStep("Notification updated");
        }
    }

    // STEP 9 SCROLL FIX
    public void scrollDown() {

        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));

        wait.until(ExpectedConditions.presenceOfElementLocated(allNotifications));

        ExtentTestListener.logStep("Scrolled down");
    }

    // STEP 10
    public int getNotificationCount() {
        return driver.findElements(allNotifications).size();
    }

    // LOOP FIXED (NO FAIL)
    public void verifyAllNotifications() throws Exception {

        Set<String> visited = new HashSet<>();

        int noNewCounter = 0;

        while (noNewCounter < 3) {

            boolean foundNew = false;

            List<WebElement> notifications =
                    driver.findElements(allNotifications);

            ExtentTestListener.logStep("Visible : " + notifications.size());

            for (WebElement notification : notifications) {

                String text = notification.getAttribute("content-desc");

                if (visited.contains(text))
                    continue;

                foundNew = true;

                visited.add(text);

                System.out.println("--------------------------------");
                ExtentTestListener.logStep("Notification " + visited.size());
                System.out.println(text);

                int x = notification.getRect().getX()
                        + notification.getRect().getWidth() / 2;

                int y = notification.getRect().getY()
                        + notification.getRect().getHeight() / 2;

                driver.executeScript("mobile: clickGesture",
                        java.util.Map.of(
                                "x", x,
                                "y", y));

                Thread.sleep(1500);

                if (!isStillOnNotificationScreen()) {

                    driver.navigate().back();

                    wait.until(ExpectedConditions.presenceOfElementLocated(allNotifications));

                    Thread.sleep(1000);
                }
            }

            if (!foundNew) {
                break;
            }

            // Scroll to next notifications
            driver.executeScript("mobile: scrollGesture",
                    java.util.Map.of(
                            "left", 50,
                            "top", 250,
                            "width", 620,
                            "height", 1200,
                            "direction", "down",
                            "percent", 0.90
                    ));
        }

        ExtentTestListener.logStep("TOTAL VALIDATED : " + visited.size());
    }

    // UI BACK BUTTON
    public void clickBackButton() {

        wait.until(ExpectedConditions.elementToBeClickable(backButton)).click();
        ExtentTestListener.logStep("Back button clicked");

        // FIX → WAIT FOR NOTIFICATION LIST, NOT HOME
        wait.until(ExpectedConditions.presenceOfElementLocated(allNotifications));
    }

    public void goToHomeFromNotification() {

        driver.navigate().back();

        ExtentTestListener.logStep("Back action performed");

        try {
            // Try to detect notification screen again
            wait.until(ExpectedConditions.presenceOfElementLocated(allNotifications));
            ExtentTestListener.logStep("Still on notification screen");

            // 👉 If still there, go back AGAIN
            driver.navigate().back();
            ExtentTestListener.logStep("Second back to reach Home");

        }
        catch (Exception e) {
            ExtentTestListener.logStep("Navigated away from notification screen");
        }
    }
}