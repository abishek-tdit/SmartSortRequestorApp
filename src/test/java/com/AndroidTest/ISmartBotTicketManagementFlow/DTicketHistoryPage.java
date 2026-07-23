package com.AndroidTest.ISmartBotTicketManagementFlow;

import Base.BasePage;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

public class DTicketHistoryPage extends BasePage {

    //=========================================================
    // Constructor
    //=========================================================

    public DTicketHistoryPage(AndroidDriver driver) {
        super(driver);
    }

    //=========================================================
    // Locators
    //=========================================================

    private final By ticketHistoryButton =
            AppiumBy.accessibilityId("Ticket History");

    private final By viewTicketDetailsButton =
            AppiumBy.xpath("(//android.view.View[contains(@content-desc,'View Ticket Details')])[1]");

    private final By ticketDetailsTitle =
            AppiumBy.accessibilityId("Ticket Details");

    private final By ticketId =
            AppiumBy.xpath("//android.view.View[contains(@content-desc,'TCK-')]");

    private final By createdDate =
            AppiumBy.xpath("//android.view.View[contains(@content-desc,'July')]");

    private final By backButtonInsideTicket =
            AppiumBy.xpath("(//android.widget.Button[@content-desc='Back'])[2]");

    private final By completedTab =
            AppiumBy.xpath("//android.view.View[contains(@content-desc,'Completed')]");

    private final By backButton =
            AppiumBy.xpath("//android.widget.Button[@content-desc='Back']");

    //=========================================================
    // View Ticket History
    //=========================================================

    public void viewTicketHistory() {

        scrollTillEnd(0.80);

        wait.until(ExpectedConditions.elementToBeClickable(ticketHistoryButton))
                .click();

        ExtentTestListener.logStep("Clicked Ticket History");

        wait.until(ExpectedConditions.elementToBeClickable(viewTicketDetailsButton))
                .click();

        ExtentTestListener.logStep("Clicked View Ticket Details");

        WebElement title = wait.until(
                ExpectedConditions.visibilityOfElementLocated(ticketDetailsTitle));

        if (title.isDisplayed()) {
            ExtentTestListener.logStep("Ticket Details Page Opened Successfully");
        }

        WebElement ticket = wait.until(
                ExpectedConditions.visibilityOfElementLocated(ticketId));

        WebElement date = wait.until(
                ExpectedConditions.visibilityOfElementLocated(createdDate));

        ExtentTestListener.logStep(
                "Ticket ID : " + ticket.getAttribute("content-desc"));

        ExtentTestListener.logStep(
                "Created Date : " + date.getAttribute("content-desc"));

        if (ExtentTestListener.getTest() != null) {
            ExtentTestListener.getTest().pass("Ticket Details validated successfully");
        }

        wait.until(ExpectedConditions.elementToBeClickable(backButtonInsideTicket))
                .click();

        ExtentTestListener.logStep("Clicked Back Button");

        wait.until(ExpectedConditions.elementToBeClickable(completedTab))
                .click();

        ExtentTestListener.logStep("Clicked Completed Tab");

        wait.until(ExpectedConditions.elementToBeClickable(backButton))
                .click();

        ExtentTestListener.logStep("Returned from Ticket History");
    }

    //=========================================================
    // Reusable Scroll Down
    //=========================================================

    private void scrollTillEnd(double v) {
        boolean canScrollMore = true;
        while (canScrollMore) {
            canScrollMore = (Boolean) driver.executeScript(
                    "mobile: scrollGesture",
                    Map.of(
                            "left", 100,
                            "top", 300,
                            "width", 500,
                            "height", 1000,
                            "direction", "down",
                            "percent", 1.0
                    ));

        }

        System.out.println("Reached end of page");
    }
}