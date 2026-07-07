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

                System.out.println("Dates Found : " + dates.size());

                if (dates.size() < 2) {
                    throw new RuntimeException("Tomorrow date not found.");
                }

                WebElement tomorrow = dates.get(1);

                System.out.println("Selecting Date : "
                        + tomorrow.getAttribute("content-desc"));

                tomorrow.click();

                Thread.sleep(2000);

                // ============================
                // Select First Available Slot
                // ============================

                List<WebElement> slots = wait.until(
                        ExpectedConditions.visibilityOfAllElementsLocatedBy(
                                AppiumBy.xpath("//android.view.View[contains(@content-desc,' - ')]")
                        )
                );

                if (slots.isEmpty()) {
                    throw new RuntimeException("No slot timings available.");
                }

                WebElement firstSlot = slots.get(0);

                System.out.println("Selecting Slot : "
                        + firstSlot.getAttribute("content-desc"));

                firstSlot.click();

                System.out.println("Tomorrow date and first slot selected successfully.");

                if (ExtentTestListener.getTest() != null) {
                    ExtentTestListener.getTest().pass("Tomorrow date and first slot selected");
                }

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

        Thread.sleep(3000);
    }
    public void confirmReschedule() throws Exception {

        Thread.sleep(4000);

        // CLICK CONFIRM BUTTON
        WebElement confirmBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Confirm")
                )
        );

        confirmBtn.click();

        System.out.println("Confirm button clicked");

        if (ExtentTestListener.getTest() != null) {
            ExtentTestListener.getTest().pass("Clicked Confirm button");
        }

        Thread.sleep(3000);

        // CLICK OK POPUP
        WebElement okBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("OK")
                )
        );

        okBtn.click();

        System.out.println("OK popup clicked");

        if (ExtentTestListener.getTest() != null) {
            ExtentTestListener.getTest().pass("Clicked OK popup");
        }

        Thread.sleep(3000);
    }
}