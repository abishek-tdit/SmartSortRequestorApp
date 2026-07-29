package com.AndroidTest.CRequestorOrderPlacingFlow;

import Base.BasePage;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;
import java.util.Map;

public class DSlotPage extends BasePage {

    //=========================================================
    // Constructor
    //=========================================================

    public DSlotPage(AndroidDriver driver) {
        super(driver);
    }

    //=========================================================
    // Locators
    //=========================================================

    private final By SELECT_SLOT =
            AppiumBy.accessibilityId("Select Slot");

    private final By CONTINUE =
            AppiumBy.accessibilityId("Continue");

    private final By CONFIRM =
            AppiumBy.accessibilityId("Confirm");

    private final By OK =
            AppiumBy.accessibilityId("OK");

    //=========================================================
    // Select Slot
    //=========================================================

    public void selectSlot() throws InterruptedException {

        Thread.sleep(5000);
        // Scroll to Select Slot
        utility.scrollToDescription("Select Slot");

        // Click Select Slot
        WebElement selectSlotBtn = getElement(SELECT_SLOT);

        driver.executeScript(
                "mobile: clickGesture",
                Map.of(
                        "elementId",
                        ((RemoteWebElement) selectSlotBtn).getId()
                )
        );

        ExtentTestListener.logStep("Select Slot Clicked");

        if (ExtentTestListener.getTest() != null) {
            ExtentTestListener.getTest().pass("Clicked Select Slot");
        }

        try {
            Thread.sleep(3000);
        } catch (Exception ignored) {
        }

        boolean slotSelected = false;

        for (int retry = 1; retry <= 5 && !slotSelected; retry++) {

            List<WebElement> slots = driver.findElements(
                    AppiumBy.xpath(
                            "//android.view.View[contains(@content-desc,'AM') or contains(@content-desc,'PM')]"
                    )
            );

            ExtentTestListener.logStep("Slots Found : " + slots.size());

            for (WebElement slot : slots) {

                try {

                    String slotName = slot.getAttribute("content-desc");

                    driver.executeScript(
                            "mobile: clickGesture",
                            Map.of(
                                    "elementId",
                                    ((RemoteWebElement) slot).getId()
                            )
                    );

                    ExtentTestListener.logStep("Trying Slot : " + slotName);

                    Thread.sleep(2500);

                    List<WebElement> continueButtons =
                            driver.findElements(CONTINUE);

                    if (!continueButtons.isEmpty() &&
                            continueButtons.get(0).isDisplayed() &&
                            continueButtons.get(0).isEnabled()) {

                        ExtentTestListener.logStep("Selected Slot : " + slotName);

                        slotSelected = true;
                        break;
                    }

                } catch (Exception e) {

                    ExtentTestListener.logStep("Unable to select slot. Trying next.");

                }
            }

            if (!slotSelected) {

                ExtentTestListener.logStep("Retrying Slot Selection : " + retry);

                try {
                    Thread.sleep(1000);
                } catch (Exception ignored) {
                }
            }
        }

        if (!slotSelected) {
            throw new RuntimeException("No Available Slot Could Be Selected");
        }

        click(CONTINUE);

        if (ExtentTestListener.getTest() != null) {
            ExtentTestListener.getTest().pass("Clicked Continue");
        }

        click(CONFIRM);

        if (ExtentTestListener.getTest() != null) {
            ExtentTestListener.getTest().pass("Clicked Confirm");
        }

        click(OK);

        ExtentTestListener.logStep("Final OK Button Clicked");

        if (ExtentTestListener.getTest() != null) {
            ExtentTestListener.getTest().pass("Final OK Button Clicked");
        }
    }
}