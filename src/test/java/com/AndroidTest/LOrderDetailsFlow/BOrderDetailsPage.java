package com.AndroidTest.LOrderDetailsFlow;

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

    //=========================================================
    // GET VISIBLE ORDERS
    //=========================================================

    public List<String> getVisibleOrders() {

        List<String> ids = new ArrayList<>();

        for (int retry = 0; retry < 5; retry++) {

            try {

                List<WebElement> elements =
                        driver.findElements(
                                AppiumBy.xpath(
                                        "//*[contains(@content-desc,'AB-RO')]"
                                )
                        );

                for (WebElement el : elements) {

                    try {

                        String desc = el.getAttribute("content-desc");

                        if (desc == null || desc.isBlank()) {
                            continue;
                        }

                        String[] lines = desc.split("\\R");

                        for (String line : lines) {

                            String value = line.trim();

                            if (value.startsWith("AB-RO")) {

                                // Remove anything after the order number
                                // if the content-desc contains extra information.
                                String orderId = extractOrderId(value);

                                if (!orderId.isEmpty() && !ids.contains(orderId)) {

                                    ids.add(orderId);

                                    ExtentTestListener.logStep(
                                            "Visible Order : " + orderId
                                    );
                                }
                            }
                        }

                    } catch (StaleElementReferenceException ignored) {
                    }
                }

                if (!ids.isEmpty()) {
                    return ids;
                }

            } catch (Exception e) {

                ExtentTestListener.logStep(
                        "Unable to read visible orders. Retrying..."
                );
            }

            sleep(1000);
        }

        return ids;
    }

    //=========================================================
    // EXTRACT ORDER NUMBER
    //=========================================================

    private String extractOrderId(String value) {

        if (value == null) {
            return "";
        }

        value = value.trim();

        int start = value.indexOf("AB-RO-");

        if (start == -1) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        for (int i = start; i < value.length(); i++) {

            char c = value.charAt(i);

            if (Character.isLetterOrDigit(c) || c == '-') {
                result.append(c);
            } else {
                break;
            }
        }

        return result.toString();
    }

    //=========================================================
    // CLICK ORDER AND VERIFY DETAIL PAGE
    //=========================================================

    public String openOrderAndGetDetailId(String orderId) {

        for (int attempt = 1; attempt <= 3; attempt++) {

            ExtentTestListener.logStep(
                    "Opening : " + orderId +
                            " | Attempt : " + attempt
            );

            boolean clicked = clickOrderById(orderId);

            if (!clicked) {

                ExtentTestListener.logStep(
                        "Unable to click : " + orderId
                );

                sleep(1000);

                continue;
            }

            // Wait for expected order to appear
            String actual = waitForExpectedOrderId(orderId, 10);

            if (orderId.equals(actual)) {

                ExtentTestListener.logStep(
                        "Detail ID : " + actual
                );

                return actual;
            }

            ExtentTestListener.logStep(
                    "Detail page not opened correctly for : "
                            + orderId
            );

            /*
             * IMPORTANT:
             *
             * If we are actually on another screen/detail screen,
             * go back before retrying.
             *
             * If we're still on the list, don't press back.
             */
            if (isAnyDetailPageOpen()) {

                ExtentTestListener.logStep(
                        "Returning to order list before retry..."
                );

                driver.navigate().back();

                waitForOrderList();
            }

            sleep(1000);
        }

        return "";
    }

    //=========================================================
    // CLICK ORDER
    //=========================================================

    public boolean clickOrderById(String orderId) {

        for (int retry = 0; retry < 5; retry++) {

            try {

                /*
                 * First try to locate elements specifically containing
                 * this order number instead of scanning //*.
                 */
                List<WebElement> matches =
                        driver.findElements(
                                AppiumBy.xpath(
                                        "//*[contains(@content-desc,\""
                                                + orderId +
                                                "\")]"
                                )
                        );

                if (matches.isEmpty()) {

                    ExtentTestListener.logStep(
                            "Order element not found yet : "
                                    + orderId
                    );

                    sleep(1000);

                    continue;
                }

                /*
                 * Prefer the smallest matching element.
                 *
                 * Parent containers can also contain the same
                 * content-desc. The smaller element is normally
                 * closer to the actual order/card.
                 */
                WebElement bestElement = null;

                long smallestArea = Long.MAX_VALUE;

                for (WebElement element : matches) {

                    try {

                        String desc =
                                element.getAttribute("content-desc");

                        if (desc == null ||
                                !desc.contains(orderId)) {
                            continue;
                        }

                        int width =
                                element.getSize().getWidth();

                        int height =
                                element.getSize().getHeight();

                        long area =
                                (long) width * height;

                        if (area > 0 && area < smallestArea) {

                            smallestArea = area;
                            bestElement = element;
                        }

                    } catch (StaleElementReferenceException ignored) {
                    }
                }

                if (bestElement != null) {

                    try {

                        bestElement.click();

                        ExtentTestListener.logStep(
                                "Clicked : " + orderId
                        );

                        sleep(1500);

                        return true;

                    } catch (Exception clickException) {

                        ExtentTestListener.logStep(
                                "Normal click failed for "
                                        + orderId
                                        + ". Trying center tap..."
                        );

                        try {

                            int centerX =
                                    bestElement.getRect().getX()
                                            + bestElement.getRect().getWidth() / 2;

                            int centerY =
                                    bestElement.getRect().getY()
                                            + bestElement.getRect().getHeight() / 2;

                            tap(centerX, centerY);

                            ExtentTestListener.logStep(
                                    "Center tapped : "
                                            + orderId
                            );

                            sleep(1500);

                            return true;

                        } catch (Exception ignored) {
                        }
                    }
                }

            } catch (Exception ignored) {
            }

            sleep(1000);
        }

        return false;
    }

    //=========================================================
    // WAIT FOR EXPECTED ORDER ID
    //=========================================================

    private String waitForExpectedOrderId(
            String expectedOrderId,
            int timeoutSeconds) {

        for (int second = 0;
             second < timeoutSeconds;
             second++) {

            try {

                /*
                 * Search content-desc first.
                 */
                List<WebElement> descMatches =
                        driver.findElements(
                                AppiumBy.xpath(
                                        "//*[contains(@content-desc,\""
                                                + expectedOrderId +
                                                "\")]"
                                )
                        );

                for (WebElement element : descMatches) {

                    try {

                        String desc =
                                element.getAttribute(
                                        "content-desc"
                                );

                        String extracted =
                                extractOrderId(desc);

                        if (expectedOrderId.equals(extracted)) {

                            /*
                             * We need to distinguish the detail page
                             * from the order list.
                             *
                             * Give the navigation a moment to settle.
                             */
                            if (second > 0) {
                                return extracted;
                            }
                        }

                    } catch (Exception ignored) {
                    }
                }

                /*
                 * Search text also.
                 */
                List<WebElement> textMatches =
                        driver.findElements(
                                AppiumBy.xpath(
                                        "//*[contains(@text,\""
                                                + expectedOrderId +
                                                "\")]"
                                )
                        );

                for (WebElement element : textMatches) {

                    try {

                        String text = element.getText();

                        String extracted =
                                extractOrderId(text);

                        if (expectedOrderId.equals(extracted)) {
                            return extracted;
                        }

                    } catch (Exception ignored) {
                    }
                }

            } catch (Exception ignored) {
            }

            sleep(1000);
        }

        return "";
    }

    //=========================================================
    // CHECK WHETHER DETAIL PAGE OPENED
    //=========================================================

    private boolean isAnyDetailPageOpen() {

        try {

            /*
             * If list has multiple order IDs visible,
             * we're probably still on the list.
             */
            List<String> orders = getVisibleOrdersSilently();

            return orders.size() <= 1;

        } catch (Exception ignored) {

            return false;
        }
    }

    //=========================================================
    // GET ORDERS WITHOUT LOGGING
    //=========================================================

    private List<String> getVisibleOrdersSilently() {

        List<String> ids = new ArrayList<>();

        try {

            List<WebElement> elements =
                    driver.findElements(
                            AppiumBy.xpath(
                                    "//*[contains(@content-desc,'AB-RO')]"
                            )
                    );

            for (WebElement element : elements) {

                try {

                    String desc =
                            element.getAttribute(
                                    "content-desc"
                            );

                    if (desc == null) {
                        continue;
                    }

                    String[] lines =
                            desc.split("\\R");

                    for (String line : lines) {

                        String orderId =
                                extractOrderId(line);

                        if (!orderId.isEmpty()
                                && !ids.contains(orderId)) {

                            ids.add(orderId);
                        }
                    }

                } catch (Exception ignored) {
                }
            }

        } catch (Exception ignored) {
        }

        return ids;
    }

    //=========================================================
    // WAIT FOR ORDER LIST
    //=========================================================

    private void waitForOrderList() {

        for (int retry = 0; retry < 10; retry++) {

            List<String> orders =
                    getVisibleOrdersSilently();

            if (!orders.isEmpty()) {
                return;
            }

            sleep(500);
        }
    }

    //=========================================================
    // BACK
    //=========================================================

    public void clickBackButton() {

        ExtentTestListener.logStep(
                "Returning to order list..."
        );

        driver.navigate().back();

        waitForOrderList();

        sleep(500);
    }

    //=========================================================
    // TAP
    //=========================================================

    private void tap(int x, int y) {

        PointerInput finger =
                new PointerInput(
                        PointerInput.Kind.TOUCH,
                        "finger"
                );

        Sequence tap =
                new Sequence(finger, 1);

        tap.addAction(
                finger.createPointerMove(
                        Duration.ZERO,
                        PointerInput.Origin.viewport(),
                        x,
                        y
                )
        );

        tap.addAction(
                finger.createPointerDown(
                        PointerInput.MouseButton.LEFT.asArg()
                )
        );

        tap.addAction(
                finger.createPointerUp(
                        PointerInput.MouseButton.LEFT.asArg()
                )
        );

        driver.perform(
                Collections.singletonList(tap)
        );
    }

    //=========================================================
    // SWIPE UP
    //=========================================================

    public void swipeUp() {

        Dimension size =
                driver.manage()
                        .window()
                        .getSize();

        int startX =
                size.width / 2;

        int startY =
                (int) (size.height * 0.80);

        int endY =
                (int) (size.height * 0.30);

        PointerInput finger =
                new PointerInput(
                        PointerInput.Kind.TOUCH,
                        "finger"
                );

        Sequence swipe =
                new Sequence(finger, 1);

        swipe.addAction(
                finger.createPointerMove(
                        Duration.ZERO,
                        PointerInput.Origin.viewport(),
                        startX,
                        startY
                )
        );

        swipe.addAction(
                finger.createPointerDown(
                        PointerInput.MouseButton.LEFT.asArg()
                )
        );

        swipe.addAction(
                finger.createPointerMove(
                        Duration.ofMillis(600),
                        PointerInput.Origin.viewport(),
                        startX,
                        endY
                )
        );

        swipe.addAction(
                finger.createPointerUp(
                        PointerInput.MouseButton.LEFT.asArg()
                )
        );

        driver.perform(
                Collections.singletonList(swipe)
        );

        sleep(1200);
    }

    //=========================================================
    // VALIDATE ALL ORDERS
    //=========================================================

    public void validateAllOrders(
            String tabName,
            int maxOrders) {

        ExtentTestListener.logStep(
                "========== "
                        + tabName
                        + " =========="
        );

        Set<String> validatedOrders =
                new HashSet<>();

        int validated = 0;

        int consecutiveNoNewOrders = 0;

        while (validated < maxOrders) {

            List<String> visibleOrders =
                    getVisibleOrders();

            boolean foundNewOrder = false;

            for (String orderId : visibleOrders) {

                if (validatedOrders.contains(orderId)) {
                    continue;
                }

                foundNewOrder = true;

                String actual =
                        openOrderAndGetDetailId(orderId);

                ExtentTestListener.logStep(
                        "Expected : " + orderId
                );

                ExtentTestListener.logStep(
                        "Actual   : " + actual
                );

                Assert.assertFalse(
                        actual.isEmpty(),
                        "Order detail page did not open "
                                + "correctly for : "
                                + orderId
                );

                Assert.assertEquals(
                        actual,
                        orderId,
                        "Order ID mismatch"
                );

                ExtentTestListener.logStep(
                        "PASS : " + actual
                );

                validatedOrders.add(orderId);

                validated++;

                clickBackButton();

                if (validated >= maxOrders) {
                    break;
                }
            }

            if (validated >= maxOrders) {
                break;
            }

            /*
             * No new order found on current screen.
             * Scroll for more.
             */
            if (!foundNewOrder) {

                ExtentTestListener.logStep(
                        "No new order visible. Scrolling..."
                );

                swipeUp();

                List<String> afterOrders =
                        getVisibleOrders();

                boolean hasNewOrder = false;

                for (String id : afterOrders) {

                    if (!validatedOrders.contains(id)) {

                        hasNewOrder = true;

                        break;
                    }
                }

                if (!hasNewOrder) {

                    consecutiveNoNewOrders++;

                    if (consecutiveNoNewOrders >= 2) {

                        ExtentTestListener.logStep(
                                "Reached End Of "
                                        + tabName
                                        + " Orders"
                        );

                        break;
                    }

                } else {

                    consecutiveNoNewOrders = 0;
                }
            }
        }

        ExtentTestListener.logStep(
                tabName
                        + " Validated Orders : "
                        + validated
        );
    }

    //=========================================================
    // OPEN TAB
    //=========================================================

    public void openTab(String tabName) {

        ExtentTestListener.logStep(
                "Opening tab : " + tabName
        );

        for (int attempt = 1;
             attempt <= 3;
             attempt++) {

            try {

                WebElement tab =
                        driver.findElement(
                                AppiumBy.androidUIAutomator(
                                        "new UiScrollable("
                                                + "new UiSelector().scrollable(true))"
                                                + ".scrollIntoView("
                                                + "new UiSelector()"
                                                + ".descriptionContains(\""
                                                + tabName
                                                + "\"))"
                                )
                        );

                tab.click();

                sleep(1500);

                ExtentTestListener.logStep(
                        tabName + " tab opened"
                );

                return;

            } catch (Exception e) {

                ExtentTestListener.logStep(
                        "Retrying tab : "
                                + tabName
                );

                swipeUp();
            }
        }

        throw new RuntimeException(
                "Unable to open tab : "
                        + tabName
        );
    }

    //=========================================================
    // SLEEP
    //=========================================================

    private void sleep(int ms) {

        try {

            Thread.sleep(ms);

        } catch (InterruptedException e) {

            Thread.currentThread()
                    .interrupt();
        }
    }
}