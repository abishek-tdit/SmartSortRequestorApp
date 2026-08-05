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

        // CLICK NOTIFICATION ICON
        ExtentTestListener.getTest().info("Clicking notification icon");
        page.clickNotificationIcon();

        // VERIFY NOTIFICATION SCREEN
        if (!page.isNotificationScreenDisplayed()) {
            ExtentTestListener.getTest().fail("Notification screen failed");
            throw new RuntimeException("Notification screen failed");
        }

        ExtentTestListener.getTest().pass("Notification screen opened");

        // PRINT ALL NOTIFICATIONS
        page.printAllNotifications();

        String before = page.getFirstNotificationText();

        // CLICK FIRST NOTIFICATION
        ExtentTestListener.getTest().info("Clicking first notification");
        page.clickFirstNotification();

        if (page.isStillOnNotificationScreen()) {

            ExtentTestListener.logStep("Notification clicked but stayed on Notification screen");

        } else {

            ExtentTestListener.logStep("Notification opened another screen");

            driver.navigate().back();

            Thread.sleep(1500);

            if (!page.isNotificationScreenDisplayed()) {
                throw new RuntimeException("Unable to return to Notification screen");
            }
        }

        ExtentTestListener.getTest().pass("Notification click validated");

        // VALIDATE READ STATUS
        String after = page.getFirstNotificationText();
        page.validateNotificationRead(before, after);

        ExtentTestListener.getTest().pass("Read validation completed");

        // SCROLL
        int beforeScroll = page.getNotificationCount();
        ExtentTestListener.getTest().info("Visible notifications before scroll : " + beforeScroll);

        page.scrollDown();

        int afterScroll = page.getNotificationCount();
        ExtentTestListener.getTest().info("Visible notifications after scroll : " + afterScroll);

        ExtentTestListener.getTest().pass("Scroll validated");

        // VERIFY ALL NOTIFICATIONS
        page.verifyAllNotifications();

        ExtentTestListener.getTest().pass("All notifications validated");

        // DELETE LAST NOTIFICATION
        page.deleteLastNotification();

        ExtentTestListener.getTest().pass("Last notification deleted");

        // RETURN HOME
        page.goToHomeFromNotification();

        ExtentTestListener.getTest().pass("Returned to Home screen");

        Thread.sleep(3000);
    }
}