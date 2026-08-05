package com.AndroidTest.DRequestorRedeemFlow;

import Base.BasePage;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CAvailablePointsPage extends BasePage {

    public CAvailablePointsPage(AndroidDriver driver) {
        super(driver);

    }
    //=========================================================
    // Locator
    //=========================================================

    private final By availablePointsForRedeem =
            AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc,'Available Points For Redeem')]");

    //=========================================================
    // Redeem Points
    //=========================================================

    public void availablePoints() throws InterruptedException {


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