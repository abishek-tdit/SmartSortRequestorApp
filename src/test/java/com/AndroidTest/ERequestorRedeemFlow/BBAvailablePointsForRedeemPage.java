package com.AndroidTest.ERequestorRedeemFlow;

import Base.BasePage;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BBAvailablePointsForRedeemPage extends BasePage {

    public BBAvailablePointsForRedeemPage(AndroidDriver driver) {
        super(driver);

    }
    //=========================================================
    // Locator
    //=========================================================

    private final By redeemCashOutButton =
            AppiumBy.xpath("//*[@content-desc='Redeem & cash it out']");

    private final By availablePointsForRedeem =
            AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc,'Available Points For Redeem')]");
    //=========================================================
    // Business Point History
    //=========================================================

    //=========================================================
    // Redeem Points
    //=========================================================

    public void redeemPoints1() throws InterruptedException {

        ExtentTestListener.logStep("========== REDEEM CASH OUT STARTED ==========");

        boolean isFound = false;

        // Small scroll until Redeem button is visible
        for (int i = 0; i < 5; i++) {

            if (!driver.findElements(redeemCashOutButton).isEmpty()) {
                isFound = true;
                ExtentTestListener.logStep("Redeem & Cash Out button found");
                break;
            }

            driver.executeScript("mobile: scrollGesture", java.util.Map.of(
                    "left", 100,
                    "top", 400,
                    "width", 800,
                    "height", 600,
                    "direction", "down",
                    "percent", 0.3
            ));

            ExtentTestListener.logStep("Small scroll performed");

        }

        if (!isFound) {
            throw new RuntimeException("Redeem & Cash It Out button not found.");
        }

        // Click Redeem & Cash Out
        WebElement redeemButton = wait.until(
                ExpectedConditions.elementToBeClickable(redeemCashOutButton));
        redeemButton.click();

        ExtentTestListener.logStep("Clicked 'Redeem & Cash It Out'");

        // Click Available Points For Redeem
        WebElement availablePoints = wait.until(
                ExpectedConditions.elementToBeClickable(availablePointsForRedeem));
        availablePoints.click();

        ExtentTestListener.logStep("Available Points For Redeem Clicked");

        // Validate Redeem History Page

    // 1. Validate Page Title
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("Redeem History")));

        ExtentTestListener.logStep("Verified : Redeem History Page");

    // 2. Validate Redeem Points
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.view.View[contains(@content-desc,'Redeem Points')]")));

        ExtentTestListener.logStep("Verified : Redeem Points");

    // 3. Validate Redeem Type
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.view.View[contains(@content-desc,'Redeem Type')]")));

        ExtentTestListener.logStep("Verified : Redeem Type");

    // 4. Validate Partner Name
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.view.View[contains(@content-desc,'Partner Name')]")));

        ExtentTestListener.logStep("Verified : Partner Name");

    // 5. Validate Payment Status
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.view.View[contains(@content-desc,'Payment Status')]")));

        ExtentTestListener.logStep("Verified : Payment Status");
        Thread.sleep(3000);
        driver.navigate().back();
    }
}