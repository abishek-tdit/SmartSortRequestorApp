package com.AndroidTest.C3CollectorUtilityOrderCompleteFlow;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.Map;
import static Utility.AOrderDataDoorPickup.orderNumberDoorPickup;

public class GDeliveryOrderAssignToCollectionCenterPage extends BaseClassMobile {

    AndroidDriver driver;

    public GDeliveryOrderAssignToCollectionCenterPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void openRequestOrdersAndRODO() {

        // Click Request Orders (RO)
        WebElement requestOrders = waitUntilClickable(
                AppiumBy.accessibilityId("Request Orders (RO)"), 20);
        requestOrders.click();

        ExtentTestListener.logStep("Clicked Request Orders (RO)");

        // Click RO - DO Tab
        WebElement roDoTab = waitUntilClickable(
                AppiumBy.accessibilityId("RO - DO\nTab 3 of 3"), 20);
        roDoTab.click();

        ExtentTestListener.logStep("Clicked RO - DO Tab");

        ExtentTestListener.getTest().info("Request Orders and RO-DO Tab clicked successfully");


        // TIC-CHECKBOX
        WebElement firstOrderCheckbox = waitUntilClickable(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().className(\"android.widget.CheckBox\").instance(0)"), 20);

        firstOrderCheckbox.click();

        ExtentTestListener.logStep("Checkbox clicked for Order : " + orderNumberDoorPickup);


        // Click Assign to CC
        WebElement assignToCC = waitUntilClickable(
                AppiumBy.accessibilityId("Assign to CC"), 20);
        assignToCC.click();

        ExtentTestListener.logStep("Clicked Assign to CC");

        // Select Collection Center
        WebElement cc = waitUntilClickable(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().descriptionContains(\"TTFVaasan\")"), 20);

        driver.executeScript(
                "mobile: clickGesture",
                Map.of(
                        "elementId",
                        ((RemoteWebElement) cc).getId()));

        ExtentTestListener.logStep("Selected Collection Center - TTFVaasan");

        // Click Assign Button
        WebElement assignBtn = waitUntilClickable(
                AppiumBy.accessibilityId("Assign"), 20);
        assignBtn.click();

        ExtentTestListener.logStep("Clicked Assign");

        // Click OK Popup
        WebElement okBtn = waitUntilVisible(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().description(\"OK\")"), 20);

        okBtn.click();

        ExtentTestListener.logStep("Clicked OK Popup");

        // Back Button
        WebElement backBtn = waitUntilClickable(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().className(\"android.view.View\").instance(6)"), 20);

        backBtn.click();

        ExtentTestListener.logStep("Clicked Back Button");

        ExtentTestListener.getTest().info("Order selected, assigned to Collection Center, and confirmed successfully");
    }
}