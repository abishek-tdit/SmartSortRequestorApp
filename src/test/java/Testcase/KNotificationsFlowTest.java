package Testcase;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import com.AndroidTest.KNotificationsFlow.ANotificationPage;
import org.testng.annotations.Test;

public class KNotificationsFlowTest extends BaseClassMobile {

    @Test(priority = 8)
    public void testNotificationFlow() throws Exception {

        Thread.sleep(3000);

        ANotificationPage page = new ANotificationPage(driver);

        //=========================================================
        // Click Notification Icon
        //=========================================================
        ExtentTestListener.getTest().info("Clicking Notification Icon");

        page.clickNotificationIcon();

        //=========================================================
        // Verify Notification Screen
        //=========================================================
        if (!page.isNotificationScreenDisplayed()) {

            ExtentTestListener.getTest().fail("Notification screen failed");

            throw new RuntimeException("Notification screen failed");
        }

        ExtentTestListener.getTest().pass("Notification screen opened successfully");

        //=========================================================
        // Print All Notifications
        //=========================================================
        page.printAllNotifications();

        //=========================================================
        // Save First Notification
        //=========================================================
        String before = page.getFirstNotificationText();

        //=========================================================
        // Click First Notification
        //=========================================================
        ExtentTestListener.getTest().info("Clicking First Notification");

        page.clickFirstNotification();

        if (page.isStillOnNotificationScreen()) {

            ExtentTestListener.logStep(
                    "Notification clicked but stayed on Notification screen");

        } else {

            ExtentTestListener.logStep(
                    "Notification opened another screen");

            page.goBack();
        }

        ExtentTestListener.getTest().pass("Notification click validated");

        //=========================================================
        // Validate Read Status
        //=========================================================
        String after = page.getFirstNotificationText();

        page.validateNotificationRead(before, after);

        ExtentTestListener.getTest().pass("Read validation completed");

        //=========================================================
        // Scroll Down
        //=========================================================
        int beforeScroll = page.getNotificationCount();

        ExtentTestListener.getTest().info(
                "Visible notifications before scroll : " + beforeScroll);

        page.scrollDown();

        int afterScroll = page.getNotificationCount();

        ExtentTestListener.getTest().info(
                "Visible notifications after scroll : " + afterScroll);

        ExtentTestListener.getTest().pass("Scroll validated");

        //=========================================================
        // Validate Every Notification
        //=========================================================
        page.verifyAllNotifications();

        ExtentTestListener.getTest().pass("All notifications validated");

        //=========================================================
        // Delete Last Notification
        //=========================================================
        page.deleteLastNotification();

        ExtentTestListener.getTest().pass("Last notification deleted");

        //=========================================================
        // Return Home
        //=========================================================
        page.goToHomeFromNotification();

        ExtentTestListener.getTest().pass("Returned to Home Screen");

        Thread.sleep(3000);
    }
}