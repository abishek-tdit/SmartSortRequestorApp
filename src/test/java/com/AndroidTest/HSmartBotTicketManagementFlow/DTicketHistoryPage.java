package com.AndroidTest.HSmartBotTicketManagementFlow;

import Base.BasePage;
import Base.ExtentTestListener;
import Utility.EOrderDataTicketManagement;

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

    private final By ticketDetailsTitle =
            AppiumBy.accessibilityId("Ticket Details");

    private final By ticketId =
            AppiumBy.xpath(
                    "//android.view.View[contains(@content-desc,'TCK-')]"
            );

    private final By createdDate =
            AppiumBy.xpath(
                    "//android.view.View[contains(@content-desc,'August')]"
            );

    private final By backButtonInsideTicket =
            AppiumBy.xpath(
                    "(//android.widget.Button[@content-desc='Back'])[2]"
            );

    private final By completedTab =
            AppiumBy.xpath(
                    "//android.view.View[contains(@content-desc,'Completed')]"
            );

    private final By backButton =
            AppiumBy.xpath(
                    "//android.widget.Button[@content-desc='Back']"
            );


    //=========================================================
    // View Ticket History
    //=========================================================

    public void viewTicketHistory() {

        //=====================================================
        // Scroll Till End
        //=====================================================

        scrollTillEnd();


        //=====================================================
        // Click Ticket History
        //=====================================================

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        ticketHistoryButton
                )
        ).click();

        ExtentTestListener.logStep(
                "Clicked Ticket History"
        );


        //=====================================================
        // Get Saved Ticket ID
        //=====================================================

        String savedTicketID =
                EOrderDataTicketManagement.ticketIDNo;

        if (savedTicketID == null ||
                savedTicketID.trim().isEmpty()) {

            throw new RuntimeException(
                    "Saved Ticket ID is empty. "
                            + "EOrderDataTicketManagement.ticketIDNo "
                            + "was not populated."
            );
        }

        savedTicketID = savedTicketID.trim();

        System.out.println("==============================================");
        System.out.println("TICKET HISTORY");
        System.out.println("Saved Ticket ID : " + savedTicketID);
        System.out.println("==============================================");

        ExtentTestListener.logStep(
                "Searching Ticket History for : "
                        + savedTicketID
        );


        //=====================================================
        // Find View Ticket Details for Saved Ticket
        //=====================================================
        //
        // Find the element containing the saved ticket ID,
        // then look inside its parent container for
        // "View Ticket Details".
        //
        //=====================================================

        String viewTicketDetailsXpath =
                "//*[contains(@content-desc,'"
                        + savedTicketID
                        + "')]"
                        + "/ancestor::android.view.View[1]"
                        + "//*[contains(@content-desc,"
                        + "'View Ticket Details')]";


        System.out.println(
                "View Ticket Details XPath : "
                        + viewTicketDetailsXpath
        );


        //=====================================================
        // Click View Ticket Details
        //=====================================================

        WebElement viewTicketDetails = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath(
                                viewTicketDetailsXpath
                        )
                )
        );

        viewTicketDetails.click();

        ExtentTestListener.logStep(
                "Clicked View Ticket Details for Ticket : "
                        + savedTicketID
        );


        //=====================================================
        // Verify Ticket Details Page
        //=====================================================

        WebElement title = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        ticketDetailsTitle
                )
        );

        if (title.isDisplayed()) {

            ExtentTestListener.logStep(
                    "Ticket Details Page Opened Successfully"
            );
        }


        //=====================================================
        // Get Displayed Ticket ID
        //=====================================================

        WebElement ticket = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        ticketId
                )
        );

        String displayedTicketID =
                ticket.getAttribute("content-desc");


        System.out.println("==============================================");
        System.out.println("TICKET DETAILS");
        System.out.println("Expected Ticket ID : " + savedTicketID);
        System.out.println("Displayed Ticket ID : " + displayedTicketID);
        System.out.println("==============================================");


        ExtentTestListener.logStep(
                "Ticket ID : "
                        + displayedTicketID
        );


        //=====================================================
        // Validate Ticket ID
        //=====================================================

        if (displayedTicketID == null ||
                !displayedTicketID.contains(savedTicketID)) {

            throw new AssertionError(
                    "Ticket ID mismatch. Expected : "
                            + savedTicketID
                            + " | Actual : "
                            + displayedTicketID
            );
        }

        ExtentTestListener.logStep(
                "Ticket ID Matched Successfully : "
                        + savedTicketID
        );


        //=====================================================
        // Get Created Date
        //=====================================================

        WebElement date = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        createdDate
                )
        );

        String createdDateValue =
                date.getAttribute("content-desc");


        System.out.println(
                "Created Date : "
                        + createdDateValue
        );


        ExtentTestListener.logStep(
                "Created Date : "
                        + createdDateValue
        );


        //=====================================================
        // Test Passed
        //=====================================================

        if (ExtentTestListener.getTest() != null) {

            ExtentTestListener.getTest().pass(
                    "Ticket Details validated successfully for Ticket : "
                            + savedTicketID
            );
        }


        //=====================================================
        // Click Back Inside Ticket Details
        //=====================================================

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        backButtonInsideTicket
                )
        ).click();

        ExtentTestListener.logStep(
                "Clicked Back Button"
        );


        //=====================================================
        // Click Completed Tab
        //=====================================================

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        completedTab
                )
        ).click();

        ExtentTestListener.logStep(
                "Clicked Completed Tab"
        );


        //=====================================================
        // Return From Ticket History
        //=====================================================

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        backButton
                )
        ).click();

        ExtentTestListener.logStep(
                "Returned from Ticket History"
        );
    }


    //=========================================================
    // Reusable Scroll Down
    //=========================================================

    private void scrollTillEnd() {

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
                    )
            );
        }

        System.out.println(
                "Reached end of page"
        );

        ExtentTestListener.logStep(
                "Scrolled to end of page"
        );
    }
}
