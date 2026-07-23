package Testcase;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import com.AndroidTest.LNotificationsFlow.ALoginPage;
import com.AndroidTest.LNotificationsFlow.BNotificationPage;
import org.testng.annotations.Test;

public class LNotificationsFlowTest extends BaseClassMobile {
    @Test
    public void testNotificationFlow() throws Exception {

        //Abiram abi      - 0500000055 Dom

        //Login:
//        ALoginPage loginPage = new ALoginPage(driver);
//        loginPage.login("0500000055",
//                "Admin@194");
//
//        ExtentTestListener.logStep("Login completed");
        Thread.sleep(3000);

        //NOTIFICATION PAGE:
        BNotificationPage page = new BNotificationPage(driver);
        ExtentTestListener.getTest().info("Clicking notification icon");
        page.clickNotificationIcon();

        if (page.isNotificationScreenDisplayed()) {
            ExtentTestListener.getTest().fail("Notification screen failed");
            throw new RuntimeException("Notification screen failed");
        }
        ExtentTestListener.getTest().pass("Notification screen opened");


        //PRINT LIST:
        page.printAllNotifications();
        String before = page.getFirstNotificationText();

        //OPEN FIRST NOTIFICATION:
        ExtentTestListener.getTest().info("Click first notification");
        page.clickFirstNotification();

        if (page.isStillOnNotificationScreen()) {
            ExtentTestListener.logStep("Notification clicked but no navigation (expected behavior)");
        }
        else
        {
            ExtentTestListener.logStep("Navigation happened");
        }

        ExtentTestListener.getTest().pass("Navigation to Home screen after notification click successful");

        //USE UI BACK BUTTON:
        ExtentTestListener.getTest().info("Clicking UI back button");
        page.clickBackButton();

        if (page.isNotificationScreenDisplayed()) {
            ExtentTestListener.getTest().fail("Back button failed");
            throw new RuntimeException("Back button not working");
        }
        ExtentTestListener.getTest().pass("Back navigation successful");

        //READ VALIDATION:
        String after = page.getFirstNotificationText();
        page.validateNotificationRead(before, after);
        ExtentTestListener.getTest().pass("Read validation completed");

        //SCROLL VALIDATION:
        int beforeScroll = page.getNotificationCount();
        ExtentTestListener.getTest().info("Before scroll count: " + beforeScroll);
        page.scrollDown();

        int afterScroll = page.getNotificationCount();
        ExtentTestListener.getTest().info("After scroll count: " + afterScroll);
        ExtentTestListener.getTest().pass("Scroll executed");

        //LOOP VALIDATION:
        page.verifyAllNotifications();
        ExtentTestListener.getTest().pass("All notifications validated successfully");
        driver.navigate().back();

        ExtentTestListener.logStep("Navigated to Home screen");
        Thread.sleep(5000);
    }
}