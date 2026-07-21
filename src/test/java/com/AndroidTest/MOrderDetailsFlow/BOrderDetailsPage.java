package com.AndroidTest.MOrderDetailsFlow;

import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BOrderDetailsPage {

    private final AndroidDriver driver;

    public BOrderDetailsPage(AndroidDriver driver) {
        this.driver = driver;
    }

    //=========================
    // GET VISIBLE ORDERS
    //=========================

    public List<String> getVisibleOrders() {

        List<String> ids = new ArrayList<>();

        for (int retry = 0; retry < 3; retry++) {

            try {

                List<WebElement> elements = driver.findElements(AppiumBy.xpath("//*"));

                for (WebElement el : elements) {

                    String desc = el.getAttribute("content-desc");

                    if (desc == null)
                        continue;

                    if (desc.contains("AB-RO")) {

                        String[] lines = desc.split("\n");

                        for (String line : lines) {

                            line = line.trim();

                            if (line.startsWith("AB-RO")) {

                                if (!ids.contains(line)) {

                                    ids.add(line);
                                    ExtentTestListener.logStep("Visible Order : " + line);
                                }
                            }
                        }
                    }
                }

                return ids;

            } catch (StaleElementReferenceException e) {

                ExtentTestListener.logStep("Refreshing list...");
                sleep(1000);
            }
        }

        return ids;
    }

    //=========================
    // CLICK VISIBLE ORDER
    //=========================

    public void clickOrderById(String orderId) {

        List<WebElement> elements = driver.findElements(AppiumBy.xpath("//*"));

        for (WebElement el : elements) {

            try {

                String desc = el.getAttribute("content-desc");

                if (desc != null && desc.contains(orderId)) {

                    el.click();

                    ExtentTestListener.logStep("Clicked : " + orderId);

                    sleep(2000);

                    return;
                }

            } catch (StaleElementReferenceException ignored) {
            }
        }

        throw new RuntimeException("Order not visible : " + orderId);
    }

    //=========================
    // GET ORDER ID FROM DETAIL
    //=========================

    public String getOrderIdFromDetail() {

        List<WebElement> elements = driver.findElements(AppiumBy.xpath("//*"));

        for (WebElement el : elements) {

            try {

                String text = el.getText();

                if (text != null && text.startsWith("AB-RO")) {

                    ExtentTestListener.logStep("Detail ID : " + text);

                    return text;
                }

                String desc = el.getAttribute("content-desc");

                if (desc != null && desc.startsWith("AB-RO")) {

                    ExtentTestListener.logStep("Detail ID : " + desc);

                    return desc;
                }

            } catch (Exception ignored) {
            }
        }

        return "";
    }
    //=========================
    // BACK
    //=========================

    public void clickBackButton() {

        driver.navigate().back();

        sleep(2000);
    }

    //=========================
    // SWIPE UP
    //=========================

    public void swipeUp() {

        Dimension size = driver.manage().window().getSize();

        int startX = size.width / 2;

        int startY = (int) (size.height * 0.80);

        int endY = (int) (size.height * 0.30);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(
                Duration.ZERO,
                PointerInput.Origin.viewport(),
                startX,
                startY));

        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        swipe.addAction(finger.createPointerMove(
                Duration.ofMillis(600),
                PointerInput.Origin.viewport(),
                startX,
                endY));

        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));

        sleep(1500);
    }

    //=========================
    // VALIDATE ALL ORDERS
    //=========================

    public void validateAllOrders(String tabName, int maxOrders) {

        System.out.println();
        ExtentTestListener.logStep("========== " + tabName + " ==========");

        Set<String> validatedOrders = new HashSet<>();

        int validated = 0;

        while (validated < maxOrders) {

            List<String> visibleOrders = getVisibleOrders();

            boolean clickedAny = false;

            for (String orderId : visibleOrders) {

                if (validatedOrders.contains(orderId))
                    continue;

                System.out.println("--------------------------------");
                ExtentTestListener.logStep("Opening : " + orderId);

                clickOrderById(orderId);

                String actual = getOrderIdFromDetail();

                Assert.assertEquals(actual, orderId);

                ExtentTestListener.logStep("PASS : " + actual);

                validatedOrders.add(orderId);

                validated++;

                clickBackButton();

                clickedAny = true;

                if (validated >= maxOrders)
                    break;
            }

            if (validated >= maxOrders)
                break;

            if (!clickedAny) {

                List<String> before = getVisibleOrders();

                swipeUp();

                List<String> after = getVisibleOrders();

                if (before.equals(after)) {

                    System.out.println("Reached End of List");

                    break;
                }
            }
        }

        System.out.println();
        ExtentTestListener.logStep("Validated Orders : " + validated);
    }

    //=========================
    // OPEN TAB
    //=========================

    public void openTab(String tabName) {

        ExtentTestListener.logStep("Opening tab : " + tabName);

        WebElement tab = driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))"
                                + ".scrollIntoView(new UiSelector().descriptionContains(\""
                                + tabName + "\"))"));

        tab.click();

        sleep(2000);

        ExtentTestListener.logStep(tabName + " tab opened");
    }

    //=========================
    // SLEEP
    //=========================

    private void sleep(int ms) {

        try {
            Thread.sleep(ms);
        }
        catch (Exception ignored) {
        }
    }
}