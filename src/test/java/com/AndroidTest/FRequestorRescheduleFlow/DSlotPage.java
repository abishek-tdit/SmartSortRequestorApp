package com.AndroidTest.FRequestorRescheduleFlow;

import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.time.Duration;

public class DSlotPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public DSlotPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public void selectSlotTiming() throws Exception {

        Thread.sleep(5000);

        boolean clicked = false;

        for (int i = 0; i < 5; i++) {

            try {

                // ============================
                // Select Tomorrow's Date
                // ============================

                List<WebElement> dates = wait.until(
                        ExpectedConditions.visibilityOfAllElementsLocatedBy(
                                AppiumBy.xpath("//android.widget.HorizontalScrollView/android.view.View")
                        )
                );

                ExtentTestListener.logStep("Dates Found : " + dates.size());

                if (dates.size() < 2) {
                    throw new RuntimeException("Tomorrow date not found.");
                }

                WebElement tomorrow = dates.get(1);

                ExtentTestListener.logStep("Selecting Date : "
                        + tomorrow.getAttribute("content-desc"));

                tomorrow.click();

                Thread.sleep(2000);

                // ============================
                // Select First Available Slot
                // ============================

                List<WebElement> slots = wait.until(
                        ExpectedConditions.visibilityOfAllElementsLocatedBy(
                                AppiumBy.xpath("//android.view.View[contains(@content-desc,'AM') or contains(@content-desc,'PM')]")
                        )
                );

                if (slots.isEmpty()) {
                    throw new RuntimeException("No slot timings available.");
                }

                WebElement firstSlot = slots.get(0);

                ExtentTestListener.logStep("Selecting Slot : "
                        + firstSlot.getAttribute("content-desc"));

                wait.until(ExpectedConditions.elementToBeClickable(firstSlot));

                firstSlot.click();

                Thread.sleep(1000);

                ExtentTestListener.logStep("Tomorrow date and first slot selected successfully.");

                clicked = true;
                break;

            } catch (Exception e) {

                System.out.println("Retry : " + (i + 1));

                driver.executeScript("mobile: swipeGesture",
                        java.util.Map.of(
                                "left", 100,
                                "top", 300,
                                "width", 500,
                                "height", 1000,
                                "direction", "up",
                                "percent", 0.5
                        )
                );

                Thread.sleep(2000);
            }
        }

        if (!clicked) {
            throw new RuntimeException("Unable to select tomorrow's date or slot timing.");
        }
    }
    public void confirmReschedule() throws Exception {

        // CLICK CONFIRM BUTTON
        WebElement confirmBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Confirm")
                )
        );

        confirmBtn.click();

        ExtentTestListener.logStep("Confirm button clicked");

        // CLICK OK POPUP
        WebElement okBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("OK")
                )
        );

        okBtn.click();

        ExtentTestListener.logStep("OK popup clicked");
    }
}