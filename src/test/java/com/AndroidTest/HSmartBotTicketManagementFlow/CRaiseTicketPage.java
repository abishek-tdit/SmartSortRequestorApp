package com.AndroidTest.HSmartBotTicketManagementFlow;

import Base.BasePage;
import Base.ExtentTestListener;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class CRaiseTicketPage extends BasePage {

    //=========================================================
    // Constructor
    //=========================================================

    public CRaiseTicketPage(AndroidDriver driver) {
        super(driver);
    }

    //=========================================================
    // Locators
    //=========================================================

    private final By raiseTicketButton =
            AppiumBy.accessibilityId("Raise Ticket");

    private final By subjectDropdown =
            AppiumBy.accessibilityId("Select subject line");

    private final By  orderRelated =
            (AppiumBy) AppiumBy.accessibilityId("Order Related");

    private final By descriptionBox =
            AppiumBy.className("android.widget.EditText");

    private final By  submitTicket =
            (AppiumBy) AppiumBy.accessibilityId("Submit Ticket");

    private final By  okButton =
            (AppiumBy) AppiumBy.accessibilityId("OK");

    private final By backButton =
            AppiumBy.xpath(
                    "//android.view.View[@content-desc='Smart Bot']/android.view.View[3]");

    //=========================================================
    // Raise Ticket
    //=========================================================

    public void raiseTicket() {

        wait.until(ExpectedConditions.elementToBeClickable(raiseTicketButton))
                .click();

        ExtentTestListener.logStep("Clicked Raise Ticket");

        wait.until(ExpectedConditions.elementToBeClickable(subjectDropdown))
                .click();

        ExtentTestListener.logStep("Clicked Subject Line Dropdown");

        wait.until(ExpectedConditions.elementToBeClickable(orderRelated))
                .click();

        ExtentTestListener.logStep("Selected Reason : Order Related");

        WebElement description = wait.until(
                ExpectedConditions.visibilityOfElementLocated(descriptionBox));

        description.click();

        description.sendKeys(
                "Unable to track my order. Please check and update the status.");

        ExtentTestListener.logStep("Description Entered");

        wait.until(ExpectedConditions.elementToBeClickable(submitTicket))
                .click();

        ExtentTestListener.logStep("Submit Ticket Clicked");

        wait.until(ExpectedConditions.elementToBeClickable(okButton))
                .click();
        wait.until(driver -> true);
        ExtentTestListener.logStep("Ticket Raised Successfully");

        wait.until(ExpectedConditions.elementToBeClickable(backButton))
                .click();

        ExtentTestListener.logStep("Back Button Clicked");

        if (ExtentTestListener.getTest() != null) {
            ExtentTestListener.getTest().pass("Raise Ticket Flow Completed Successfully");
        }
    }
}