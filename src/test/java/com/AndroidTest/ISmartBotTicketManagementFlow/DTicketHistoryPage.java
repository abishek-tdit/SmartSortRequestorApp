package com.AndroidTest.ISmartBotTicketManagementFlow;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DTicketHistoryPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public DTicketHistoryPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void viewTicketHistory() throws InterruptedException {

        // Scroll Down
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().description(\"Ticket History\"))"));

        System.out.println("Scrolled to Ticket History");

        Thread.sleep(2000);


        // Click Ticket History
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Ticket History")
        )).click();

        System.out.println("Clicked Ticket History");

        Thread.sleep(3000);


        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath(
                        "(//android.view.View[contains(@content-desc,'View Ticket Details')])[1]"
                )
        )).click();

        System.out.println("Clicked First Ticket");


        // Click Back
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath(
                        "(//android.widget.Button[@content-desc='Back'])[2]"
                )
        )).click();

        System.out.println("Clicked Back Button");

        Thread.sleep(3000);

        System.out.println("Returned from Ticket Details Page");
        System.out.println(driver.getPageSource());

        //Click Completed Tab
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath(
                        "//android.view.View[contains(@content-desc,'Completed')]"
                )
        )).click();

        System.out.println("Clicked Completed Tab");

        Thread.sleep(5000);


       // Click Back
         wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.Button[@content-desc='Back']")
        )).click();

        System.out.println("Clicked Back Button");

        Thread.sleep(3000);

        System.out.println("Returned to Previous Page");
    }
}