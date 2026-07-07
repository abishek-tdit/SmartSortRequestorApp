package com.AndroidTest.JProfileViewBasicFeaturesFlow;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class KFreeUpSpacePage {
    AndroidDriver driver;
    WebDriverWait wait;

    public KFreeUpSpacePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void scrollAndOptimize() throws InterruptedException {

        System.out.println("Start Free Up Space Flow");

        boolean found = false;

        //Scroll max 5 times
        for (int i = 0; i < 5; i++) {

            List<WebElement> elements =
                    driver.findElements(AppiumBy.accessibilityId("Free up space"));

            if (!elements.isEmpty()) {
                System.out.println("Free up space Found");
                found = true;
                break;
            }

            swipeUp();
            System.out.println("Swiping...");
            Thread.sleep(2000);
        }

        if (!found)
        {
            throw new RuntimeException("Free up space NOT found after scrolling");
        }

        //CLICK FREE UP SPACE
        WebElement freeUpBtn = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Free up space")));
        freeUpBtn.click();

        Thread.sleep(3000);

        clickOptimizeAndReset();
    }

    //SWIPE METHOD
    public void swipeUp() {

        Dimension size = driver.manage().window().getSize();

        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);

        driver.executeScript("mobile: swipeGesture", Map.of(
                "left", startX,
                "top", startY,
                "width", 300,
                "height", 600,
                "direction", "up",
                "percent", 0.8 ));
    }

    //OPTIMIZE + RESET FLOW
    public void clickOptimizeAndReset() throws InterruptedException {


        //OPTIMIZE
        System.out.println("Optimize Step Started");

        WebElement optimizeBtn = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Optimize")));

        optimizeBtn.click();
        System.out.println("Optimize Clicked");
        Thread.sleep(5000);


        //RESET
        System.out.println("Reset Step Started");

        WebElement resetBtn = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Reset")));

        resetBtn.click();

        System.out.println("Reset Clicked");
        Thread.sleep(2000);


        //POPUP HANDLING
        System.out.println("Handling Popup");

//        //  OPTION 1 → CLICK OK
//        try {
//            WebElement okBtn = wait.until(ExpectedConditions.elementToBeClickable(
//                    AppiumBy.accessibilityId("OK")
//            ));
//            okBtn.click();
//            System.out.println("OK Clicked");
//        } catch (Exception e) {
//            System.out.println("OK button not found");
//        }

        // OPTION 2 → CLICK CANCEL
    try {
        WebElement cancelBtn = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Cancel")
        ));
        cancelBtn.click();
        System.out.println("Cancel Clicked");
    }
    catch (Exception e)
    {
        System.out.println("Cancel button not found");
    }
        Thread.sleep(2000);

       // BACK NAVIGATION
        System.out.println("Navigating Back");

        // BACK 1
        try {
            WebElement backBtn1 = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.className("android.widget.Button")
            ));
            backBtn1.click();
            System.out.println("Back Button Clicked (1st time)");
        } catch (Exception e) {
            System.out.println("First back button not found, using driver.navigate().back()");
            driver.navigate().back();  // fallback
        }

        Thread.sleep(2000);

        //BACK 2
        try {
            WebElement backBtn2 = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(0)")
            ));
            backBtn2.click();
            System.out.println("Back Button Clicked (2nd time)");
        } catch (Exception e) {
            System.out.println("Second back button not found, using driver.navigate().back()");
            driver.navigate().back();  // fallback
        }

        Thread.sleep(2000);

        System.out.println("Navigation Completed");

    }
}