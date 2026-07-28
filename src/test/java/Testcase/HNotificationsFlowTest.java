package Testcase;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import com.AndroidTest.HNotificationsFlow.ALoginPage;
import com.AndroidTest.HNotificationsFlow.BNotificationPage;
import org.testng.annotations.Test;

public class HNotificationsFlowTest extends BaseClassMobile {

    @Test
    public void testNotificationFlow() throws Exception {

        //LOGIN
        ALoginPage loginPage = new ALoginPage(driver);
        loginPage.login();
        System.out.println("Login completed");

        //NOTIFICATION PAGE
        BNotificationPage page = new BNotificationPage(driver);

        ExtentTestListener.getTest().info("Clicking notification icon");
        page.clickNotificationIcon();

        if (!page.isNotificationScreenDisplayed()) {
            ExtentTestListener.getTest().fail("Notification screen failed");
            throw new RuntimeException("Notification screen failed");
        }
        ExtentTestListener.getTest().pass("Notification screen opened");

        //PRINT LIST
        page.printAllNotifications();

        String before = page.getFirstNotificationText();

        // OPEN FIRST NOTIFICATION
        ExtentTestListener.getTest().info("Click first notification");
        page.clickFirstNotification();

        if (!page.isNotificationDetailDisplayed()) {
            ExtentTestListener.getTest().fail("Detail screen failed");
            throw new RuntimeException("Detail screen failed");
        }
        ExtentTestListener.getTest().pass("Detail screen opened");

        //USE UI BACK BUTTON
        ExtentTestListener.getTest().info("Clicking UI back button");
        page.clickBackButton();

        if (!page.isNotificationScreenDisplayed()) {
            ExtentTestListener.getTest().fail("Back button failed");
            throw new RuntimeException("Back button not working");
        }
        ExtentTestListener.getTest().pass("Back navigation successful");

        //READ VALIDATION
        String after = page.getFirstNotificationText();
        page.validateNotificationRead(before, after);
        ExtentTestListener.getTest().pass("Read validation completed");

        //SCROLL VALIDATION
        int beforeScroll = page.getNotificationCount();
        ExtentTestListener.getTest().info("Before scroll count: " + beforeScroll);

        page.scrollDown();

        int afterScroll = page.getNotificationCount();
        ExtentTestListener.getTest().info("After scroll count: " + afterScroll);

        ExtentTestListener.getTest().pass("Scroll executed");

        //LOOP VALIDATION
        page.verifyAllNotifications();
        ExtentTestListener.getTest().pass("Loop verification completed");

        System.out.println("Test Completed Successfully");

        ExtentTestListener.getTest().info("Navigating back to Home");

        page.clickBackButton();  // from Notification list → Home

        System.out.println("Navigated to Home screen");
    }
}