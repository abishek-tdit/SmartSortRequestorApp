package com.AndroidTest.HSmartBotTicketManagementFlow;

import Base.ExtentTestListener;
import Utility.AOrderDataDoorPickup;
import Utility.EOrderDataTicketManagement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;

import static Base.BaseClassMobile.driver;

public class CLoginWebExecutivePage {

    public static WebDriver webDriver;
    public static WebDriverWait wait;

    public void loginExecutive(String username, String password) {

        try {

            // Launch Chrome
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();

            wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));

            // Open URL
            webDriver.get("https://qa-bo-executive.smartsortsupport.com");

            ExtentTestListener.logStep("Executive Login Page Opened");

            // Username
            WebElement usernameField = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.id("email1")));

            usernameField.clear();
            usernameField.sendKeys(username);

            ExtentTestListener.logStep("Username Entered");

            // Password
            WebElement passwordField = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//input[@type='password']")));

            passwordField.clear();
            passwordField.sendKeys(password);

            ExtentTestListener.logStep("Password Entered");


            // Login Button
            WebElement signInBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//span[text()='Sign In']")
                    )
            );

            signInBtn.click();

            ExtentTestListener.logStep("Executive Login Successful");

            Thread.sleep(5000);


//=========================================================
// Swipe table horizontally to left
//=========================================================

            for (int i = 0; i < 2; i++) {

                JavascriptExecutor js = (JavascriptExecutor) webDriver;

                js.executeScript(
                        "window.scrollBy(500,0);"
                );

                Thread.sleep(1500);
            }

            ExtentTestListener.logStep("Table Swiped Left");


//=========================================================
// Get Saved Ticket ID
//=========================================================

            String ticketID =
                    EOrderDataTicketManagement.ticketIDNo;

            System.out.println("==============================================");
            System.out.println("SAVED TICKET DATA");
            System.out.println("==============================================");
            System.out.println("Ticket ID : " + ticketID);
            System.out.println("==============================================");


//=========================================================
// Dynamic Green Check / Approve Icon XPath
//=========================================================

            String approveXpath =
                    "//tr[td[contains(normalize-space(),'" + ticketID + "')]]" +
                            "//button[contains(@class,'approve-btn')]" +
                            "//i[contains(@class,'pi-check')]";


//=========================================================
// Click Green Check Button
//=========================================================

            WebElement approveIcon = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath(approveXpath)
                    )
            );

            approveIcon.click();

            ExtentTestListener.logStep(
                    "Green Check / Approve icon clicked for Ticket : "
                            + ticketID
            );

            Thread.sleep(2000);


//=========================================================
// Approve Popup - Continue Without Edit
//=========================================================

            WebElement continueWithoutEdit = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath(
                                    "//button[normalize-space()='Continue Without Edit']"
                            )
                    )
            );

            continueWithoutEdit.click();

            ExtentTestListener.logStep(
                    "Clicked Continue Without Edit"
            );

            Thread.sleep(2000);


//=========================================================
// Priority Dropdown
//=========================================================

            WebElement priorityDropdown = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath(
                                    "//span[@aria-label='Select Priority']"
                            )
                    )
            );

            priorityDropdown.click();

            ExtentTestListener.logStep(
                    "Priority Dropdown Clicked"
            );

            Thread.sleep(1000);


//=========================================================
// Select Medium
//=========================================================

            WebElement mediumPriority = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath(
                                    "//span[normalize-space()='Medium']"
                            )
                    )
            );

            mediumPriority.click();

            ExtentTestListener.logStep(
                    "Priority Selected : Medium"
            );

            Thread.sleep(1000);


//=========================================================
// Transfer To Dropdown
//=========================================================

            WebElement transferToDropdown = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath(
                                    "//span[@aria-label='Select Transfer To List']"
                            )
                    )
            );

            transferToDropdown.click();

            ExtentTestListener.logStep(
                    "Transfer To Dropdown Clicked"
            );

            Thread.sleep(1000);


//=========================================================
// Select Product Manager
//=========================================================

            WebElement productManager = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath(
                                    "//span[normalize-space()='Product Manager']"
                            )
                    )
            );

            productManager.click();

            ExtentTestListener.logStep(
                    "Transfer To Selected : Product Manager"
            );

            Thread.sleep(1000);


//=========================================================
// Final Approve
//=========================================================

            WebElement approveBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath(
                                    "//span[normalize-space()='Approve']"
                            )
                    )
            );

            approveBtn.click();

            ExtentTestListener.logStep(
                    "Final Approval Completed for Ticket : "
                            + ticketID
            );


            Thread.sleep(3000);

            // Close Chrome only
            webDriver.quit();

            ExtentTestListener.logStep("Chrome Browser Closed");
            Thread.sleep(3000);

            ExtentTestListener.logStep("Returned to Mobile Application");

            // Debug
            ExtentTestListener.logStep(
                    "Mobile Session ID = " +
                            driver.getSessionId());

        }
        catch (Exception e)
        {
            ExtentTestListener.logStep("Executive Login Failed : " + e.getMessage());
            throw new RuntimeException("Executive Login Failed", e);
        }
    }
}