package com.AndroidTest.IOrderDetailsFlow;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class BOrderDetailsPage {

    private AndroidDriver driver;

    public BOrderDetailsPage(AndroidDriver driver) {
        this.driver = driver;
    }

    //OPEN PENDING TAB ONLY
     public void openPendingTabOnly() {

        System.out.println("🔄 Opening Pending tab...");

        WebElement pending = driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scrollIntoView(new UiSelector().descriptionContains(\"Pending\"))"
                )
        );

        pending.click();

        sleep(2000);

        System.out.println("✅ Pending list screen ready");
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
                    System.out.println("📋 Found Order: " + cleanId);
                }
            }
        }

        return orderIds;
    }

    //CLICK ORDER USING ID
    public void clickOrderById(String orderId) {

        System.out.println("🔎 Clicking order: " + orderId);

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
                        System.out.println("📄 Detail ID: " + id);
                        return id;
                    }
                }
            }
        }

        return "";
    }

    //BACK NAVIGATION
    public void clickBackButton() {

        System.out.println("🔙 Going back...");

        driver.navigate().back();

        sleep(1500);
    }


    //MAIN VALIDATION METHOD
    public void validateAllOrders(String tabName, int count) {

        System.out.println("🔄 Validating orders in " + tabName + " tab...");

        List<String> orderIds = getAllOrderIdsFromList();

        if (orderIds.isEmpty()) {
            System.out.println("⚠️ No orders in this tab");
            return;
        }


        int limit = Math.min(count, orderIds.size());

        for (int i = 0; i < limit; i++) {

            String listId = orderIds.get(i);

            System.out.println("➡️ Processing: " + listId);

            // ✅ click order
            clickOrderById(listId);

            // ✅ get detail ID
            String detailId = getOrderIdFromDetail();

            try {
                Assert.assertEquals(detailId, listId);

            } catch (AssertionError e) {

                System.out.println("📸 Taking screenshot for failure...");

                //OPTIONAL: call screenshot method if you have one
                // takeScreenshot("OrderMismatch_" + listId);

                throw e;
            }

            System.out.println("✅ MATCH ✅");

            //go back to list
            clickBackButton();
        }

        System.out.println("✅ All orders validated ✅");
    }

    //UTILITY
    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception ignored) {}
    }

    public void openTab(String tabName) {

        System.out.println("🔄 Opening tab: " + tabName);

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