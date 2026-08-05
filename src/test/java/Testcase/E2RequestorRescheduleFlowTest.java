package Testcase;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import Utility.BOrderDataReschedule;
import com.AndroidTest.E2RequestorRescheduleFlow.*;
import org.testng.annotations.Test;

import static com.sun.activation.registries.LogSupport.log;

public class E2RequestorRescheduleFlowTest extends BaseClassMobile {

    @Test(priority = 2)
    public void rescheduleFlow() throws Exception {

        String orderNumber = BOrderDataReschedule.orderNumberReschedule;

        //=========================================================
        // Select Location
        //=========================================================

        Thread.sleep(5000);

        BLocationPage locationPage = new BLocationPage(driver);
        locationPage.selectLocation();

        log("Location Selected Successfully");

        //=========================================================
        // Requestor - Open Pending Order & Chat
        //=========================================================

        CChatWithCollectorPage reschedulePage = new CChatWithCollectorPage(driver);

        reschedulePage.clickChatWithCollector();

        reschedulePage.selectOrderToReschedule(orderNumber);

        log("Order Selected Successfully");

        reschedulePage.openChatAndReturn();

        //=========================================================
        // Launch SS Utility App
        //=========================================================

        driver.activateApp("com.smartsort.utilities");
        ExtentTestListener.logStep("SS Utility App Launched Successfully");

        //=========================================================
        // Collector Login
        //=========================================================

        Thread.sleep(12000);

        DLoginCollectorPage loginPage = new DLoginCollectorPage();

        loginPage.login(
                "0500055447",
                "Admin@194");

        log("Collector Login Successful");

        //=========================================================
        // Collector Chat
        //=========================================================

        EChatWithRequestor requestOrderPage = new EChatWithRequestor();

        requestOrderPage.openLatestRequestOrder();

        requestOrderPage.selectRequestOrder(orderNumber);

        requestOrderPage.clickChatIcon();

        requestOrderPage.clickImOnTheWay();

        //=========================================================
        // Launch SmartSort App
        //=========================================================

        driver.activateApp("com.abqaiq.smartsort");
        ExtentTestListener.logStep("Smart Sort App Launched Successfully");

        //=========================================================
        // Verify Chat & Reschedule
        //=========================================================

        FVerifyChatAndReschedule verifyChat =
                new FVerifyChatAndReschedule();

        verifyChat.openOrders();

        verifyChat.selectOrderToReschedule(orderNumber);

        verifyChat.openChatAndReturn();

        verifyChat.clickRescheduleButton();

        //=========================================================
        // Slot Selection
        //=========================================================

        GSlotPage slotPage = new GSlotPage(driver);
        slotPage.selectSlotTiming();
        Thread.sleep(1500);
        slotPage.confirmReschedule();

        log("Slot Selected Successfully");

        log("========== REQUESTOR RESCHEDULE FLOW COMPLETED ==========");
    }
}