package com.AndroidTest.MOrderDetailsFlow;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class BOrderDetailsPage {

    private final AndroidDriver driver;

    public BOrderDetailsPage(AndroidDriver driver) {
        this.driver = driver;
    }


    //GET ALL ORDER IDs (VERY IMPORTANT)
    public List<String> getAllOrderIdsFromList() {

        List<String> orderIds = new ArrayList<>();

        List<WebElement> elements = driver.findElements(AppiumBy.xpath("//*"));

        String fullText = "";

        for (WebElement el : elements) {
            String desc = el.getAttribute("content-desc");
            if (desc != null) {
                fullText += desc + "\n";
            }
        }

        String[] lines = fullText.split("\n");

        for (String line : lines) {
            if (line.contains("AB-RO")) {
                String cleanId = line.trim();

                if (!orderIds.contains(cleanId)) {
                    orderIds.add(cleanId);
                    System.out.println("Found Order: " + cleanId);
                }
            }
        }

        return orderIds;
    }

    //CLICK ORDER USING ID
    public void clickOrderById(String orderId) {

        System.out.println("Clicking order: " + orderId);

        WebElement order = driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scrollIntoView(new UiSelector().descriptionContains(\"" + orderId + "\"))"
                )
        );

        order.click();

        sleep(2000);
    }

    //GET ORDER ID FROM DETAIL SCREEN
    public String getOrderIdFromDetail() {

        List<WebElement> elements = driver.findElements(AppiumBy.xpath("//*"));

        for (WebElement el : elements) {

            String desc = el.getAttribute("content-desc");

            if (desc != null && desc.contains("AB-RO")) {

                String[] lines = desc.split("\n");

                for (String line : lines) {
                    if (line.contains("AB-RO")) {
                        String id = line.trim();
                        System.out.println("Detail ID: " + id);
                        return id;
                    }
                }
            }
        }

        return "";
    }

    //BACK NAVIGATION
    public void clickBackButton() {

        System.out.println("Going back...");

        driver.navigate().back();

        sleep(1500);
    }


    //MAIN VALIDATION METHOD
    public void validateAllOrders(String tabName, int count) {

        System.out.println("========== " + tabName + " ==========");

        int validated = 0;

        while (validated < count) {

            // Refresh the list every time after returning
            List<String> orderIds = getAllOrderIdsFromList();

            if (validated >= orderIds.size()) {
                break;
            }

            String expectedId = orderIds.get(validated);

            System.out.println("--------------------------------");
            System.out.println("Opening : " + expectedId);

            clickOrderById(expectedId);

            String actualId = getOrderIdFromDetail();

            Assert.assertEquals(actualId, expectedId,
                    "Order ID mismatch!");

            System.out.println("PASS : " + actualId);

            clickBackButton();

            validated++;
        }

        System.out.println("Validated " + validated + " orders from " + tabName);
    }

    //UTILITY
    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception ignored) {}
    }

    public void openTab(String tabName) {

        System.out.println("Opening tab: " + tabName);

        WebElement tab = driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scrollIntoView(new UiSelector().descriptionContains(\"" + tabName + "\"))"
                )
        );

        tab.click();

        sleep(2000);

        System.out.println("✅ " + tabName + " tab opened");
    }

}