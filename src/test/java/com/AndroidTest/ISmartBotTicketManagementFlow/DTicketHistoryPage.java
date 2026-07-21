package com.AndroidTest.ISmartBotTicketManagementFlow;

import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;
public class DTicketHistoryPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public DTicketHistoryPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void viewTicketHistory() throws InterruptedException {

        //ScrollDown
        driver.executeScript("mobile: scrollGesture", Map.of(
                "left", 100,
                "top", 300,
                "width", 500,
                "height", 1000,
                "direction", "down",
                "percent", 0.8 ));

        // Click Ticket History
        wait.until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Ticket History"))).click();

        ExtentTestListener.logStep("Clicked Ticket History");
        Thread.sleep(3000);

        //click view ticket details
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath(
                        "(//android.view.View[contains(@content-desc,'View Ticket Details')])[1]"))).click();

        ExtentTestListener.logStep("Clicked View Ticket");
        Thread.sleep(3000);


        //Validate Ticket Details Page
        WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated
                                         (AppiumBy.accessibilityId("Ticket Details")));

        if (pageTitle.isDisplayed()) {
            System.out.println("====================================");
            System.out.println("Ticket Details Page Opened Successfully");
        }

        //Ticket ID
        WebElement ticketId = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.view.View[@content-desc[contains(.,'TCK-')]]")));

        //Created Date
        WebElement createdDate = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.view.View[@content-desc[contains(.,'July')]]")));

        //Print values
        System.out.println("Ticket ID      : " + ticketId.getAttribute("content-desc"));
        System.out.println("Created Date   : " + createdDate.getAttribute("content-desc"));

        ExtentTestListener.logStep("Validation PASSED");

        //Click Back
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath(
                        "(//android.widget.Button[@content-desc='Back'])[2]"))).click();

        ExtentTestListener.logStep("Clicked Back Button");
        Thread.sleep(3000);

        //Click Completed Tab
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath(
                        "//android.view.View[contains(@content-desc,'Completed')]"))).click();

        ExtentTestListener.logStep("Clicked Completed Tab");
        Thread.sleep(5000);

        //Click Back
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.Button[@content-desc='Back']"))).click();

        ExtentTestListener.logStep("Clicked Back Button");
        Thread.sleep(3000);
    }
}