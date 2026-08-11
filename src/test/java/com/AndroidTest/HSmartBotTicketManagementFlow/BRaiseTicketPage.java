package com.AndroidTest.HSmartBotTicketManagementFlow;

import Base.BasePage;
import Base.ExtentTestListener;
import Utility.EOrderDataTicketManagement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BRaiseTicketPage extends BasePage {

    public BRaiseTicketPage(AndroidDriver driver) {
        super(driver);
    }

    //=========================================================
    // Locators
    //=========================================================

    private final By raiseTicketButton =
            AppiumBy.accessibilityId("Raise Ticket");

    private final By subjectDropdown =
            AppiumBy.accessibilityId("Select subject line");

    private final By orderRelated =
            AppiumBy.accessibilityId("Order Related");

    private final By descriptionBox =
            AppiumBy.className("android.widget.EditText");

    private final By submitTicket =
            AppiumBy.accessibilityId("Submit Ticket");

    // Dynamic success popup
    private final By ticketCreatedPopup =
            AppiumBy.xpath(
                    "//android.view.View[contains(@content-desc,'Ticket created successfully')]"
            );

    // OK button in popup
    private final By okButton =
            AppiumBy.accessibilityId("OK");


    //=========================================================
    // Raise Ticket
    //=========================================================

    public void raiseTicket() throws InterruptedException {

        //=====================================================
        // Click Raise Ticket
        //=====================================================

        wait.until(ExpectedConditions.elementToBeClickable(raiseTicketButton))
                .click();

        ExtentTestListener.logStep("Clicked Raise Ticket");


        //=====================================================
        // Click Subject Line
        //=====================================================

        wait.until(ExpectedConditions.elementToBeClickable(subjectDropdown))
                .click();

        ExtentTestListener.logStep("Clicked Subject Line Dropdown");


        //=====================================================
        // Select Order Related
        //=====================================================

        wait.until(ExpectedConditions.elementToBeClickable(orderRelated))
                .click();

        ExtentTestListener.logStep("Selected Reason : Order Related");


        //=====================================================
        // Enter Description
        //=====================================================

        WebElement description = wait.until(
                ExpectedConditions.visibilityOfElementLocated(descriptionBox));

        description.click();

        description.sendKeys(
                "Unable to track my order. Please check and update the status."
        );

        ExtentTestListener.logStep("Description Entered");



//=========================================================
// Submit Ticket
//=========================================================

        wait.until(ExpectedConditions.elementToBeClickable(submitTicket))
                .click();

        ExtentTestListener.logStep("Submit Ticket Clicked");


//=========================================================
// Wait for Ticket Created Popup
//=========================================================

        By ticketCreatedPopup =
                AppiumBy.xpath(
                        "//*[contains(@content-desc,'Ticket created successfully')]"
                );

        WebElement ticketPopup = wait.until(
                ExpectedConditions.visibilityOfElementLocated(ticketCreatedPopup)
        );


//=========================================================
// Get Popup Content Description
//=========================================================

        String popupText = ticketPopup.getAttribute("contentDescription");

        System.out.println("==============================================");
        System.out.println("TICKET CREATED POPUP");
        System.out.println("==============================================");
        System.out.println("Popup Text : " + popupText);


//=========================================================
// Extract Ticket ID
// Example:
// Ticket created successfully your ticket Id TCK-99686601
//=========================================================

        Pattern pattern = Pattern.compile("TCK-\\d+");

        Matcher matcher = pattern.matcher(popupText);

        if (matcher.find()) {

            String ticketID = matcher.group();

            //=====================================================
            // Save Ticket ID
            //=====================================================

            EOrderDataTicketManagement.ticketIDNo = ticketID;

            System.out.println("==============================================");
            System.out.println("SAVED TICKET DATA");
            System.out.println("==============================================");
            System.out.println("Ticket ID : "
                    + EOrderDataTicketManagement.ticketIDNo);
            System.out.println("==============================================");

            ExtentTestListener.logStep(
                    "Ticket ID Saved Successfully : "
                            + EOrderDataTicketManagement.ticketIDNo
            );

        } else {

            throw new RuntimeException(
                    "Ticket ID not found in popup. Popup text: "
                            + popupText
            );
        }


//=========================================================
// Click OK on Ticket Created Popup
//=========================================================

        By okButton =
                AppiumBy.xpath(
                        "//*[@content-desc='OK']"
                );

        WebElement okPopupButton = wait.until(
                ExpectedConditions.elementToBeClickable(okButton)
        );

        okPopupButton.click();

        ExtentTestListener.logStep(
                "Clicked OK on Ticket Created Popup"
        );


        driver.navigate().back();
        driver.navigate().back();
    }
}