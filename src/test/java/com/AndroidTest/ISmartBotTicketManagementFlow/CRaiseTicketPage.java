package com.AndroidTest.ISmartBotTicketManagementFlow;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CRaiseTicketPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public CRaiseTicketPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void raiseTicket() throws InterruptedException {

        // Click Raise Ticket
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Raise Ticket")
        )).click();

        System.out.println("Clicked Raise Ticket");

        Thread.sleep(3000);


        // Click Subject Line Dropdown
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Select subject line")
        )).click();

        System.out.println("Clicked Subject Line Dropdown");

        Thread.sleep(2000);


        // Select Reason - Order Related
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Order Related")
        )).click();

        System.out.println("Selected Reason : Order Related");

        Thread.sleep(2000);


        // Enter Description
        WebElement descriptionBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.className("android.widget.EditText")
                ));

        descriptionBox.click();

        descriptionBox.sendKeys(
                "Unable to track my order. Please check and update the status."
        );

        System.out.println("Description Entered");

        Thread.sleep(2000);


        // Click Submit Ticket
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Submit Ticket")
        )).click();

        System.out.println("Submit Ticket Clicked");

        Thread.sleep(3000);


        // Click OK Popup
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("OK")
        )).click();

        System.out.println("OK Popup Clicked");

        Thread.sleep(3000);

        System.out.println("Ticket Raised Successfully");

        Thread.sleep(3000);


        // Click Back Button
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath(
                        "//android.view.View[@content-desc='Smart Bot']/android.view.View[3]"
                )
        )).click();

        System.out.println("Back Button Clicked");

        Thread.sleep(3000);

        System.out.println("Returned to Home Page");
    }
}