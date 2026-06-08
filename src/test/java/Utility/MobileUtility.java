package Utility;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.RemoteWebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class MobileUtility {

    private AndroidDriver driver;
    private WebDriverWait wait;

    public MobileUtility(AndroidDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    /* ======================================================
                       SEND KEYS
    ====================================================== */

    public void sendKeys(By locator, String value) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );

        element.click();
        element.clear();
        element.sendKeys(value);
    }

    /* ======================================================
                       NORMAL CLICK
    ====================================================== */

    public void click(By locator) {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );

        element.click();
    }

    /* ======================================================
                    MOBILE STRONG CLICK
    ====================================================== */

    public void mobileClick(By locator) {

        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(locator)
        );

        driver.executeScript(
                "mobile: clickGesture",
                Map.of(
                        "elementId",
                        ((RemoteWebElement) element).getId()
                )
        );
    }

    /* ======================================================
                       WAIT METHODS
    ====================================================== */

    public void waitForVisible(By locator) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    public void waitForClickable(By locator) {

        wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }

    /* ======================================================
                        HIDE KEYBOARD
    ====================================================== */

    public void hideKeyboard() {

        try {
            driver.hideKeyboard();
        }
        catch (Exception e) {

            System.out.println("Keyboard not visible");
        }
    }

    /* ======================================================
                          SCROLL TEXT
    ====================================================== */

    public void scrollToText(String text) {

        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))"
                                + ".setMaxSearchSwipes(10)"
                                + ".scrollIntoView(new UiSelector().textContains(\""
                                + text + "\"))"
                )
        );
    }

    /* ======================================================
                    SCROLL ACCESSIBILITY ID
    ====================================================== */

    public void scrollToDescription(String description) {

        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))"
                                + ".setMaxSearchSwipes(10)"
                                + ".scrollIntoView(new UiSelector().descriptionContains(\""
                                + description + "\"))"
                )
        );
    }

    /* ======================================================
                         SWIPE UP
    ====================================================== */

    public void swipeUp() {

        Dimension size = driver.manage().window().getSize();

        int startX = size.width / 2;

        int startY = (int) (size.height * 0.80);

        int endY = (int) (size.height * 0.30);

        driver.executeScript(
                "mobile: swipeGesture",
                Map.of(
                        "left", startX,
                        "top", startY,
                        "width", 100,
                        "height", 600,
                        "direction", "up",
                        "percent", 0.75
                )
        );
    }

    /* ======================================================
                         SWIPE DOWN
    ====================================================== */

    public void swipeDown() {

        Dimension size = driver.manage().window().getSize();

        int startX = size.width / 2;

        int startY = (int) (size.height * 0.30);

        int endY = (int) (size.height * 0.80);

        driver.executeScript(
                "mobile: swipeGesture",
                Map.of(
                        "left", startX,
                        "top", startY,
                        "width", 100,
                        "height", 600,
                        "direction", "down",
                        "percent", 0.75
                )
        );
    }

    /* ======================================================
                            LONG PRESS
    ====================================================== */

    public void longPress(By locator) {

        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(locator)
        );

        driver.executeScript(
                "mobile: longClickGesture",
                Map.of(
                        "elementId",
                        ((RemoteWebElement) element).getId(),
                        "duration", 2000
                )
        );
    }

    /* ======================================================
                              DELAY
    ====================================================== */

    public void delay(int seconds) {

        try {

            Thread.sleep(seconds * 1000L);
        }
        catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }
    }
}