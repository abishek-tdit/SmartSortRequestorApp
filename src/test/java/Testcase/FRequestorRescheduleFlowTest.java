package Testcase;

import Base.BaseClassMobile;
import com.AndroidTest.FRequestorRescheduleFlow.ALoginPage;
import com.AndroidTest.FRequestorRescheduleFlow.BLocationPage;
import com.AndroidTest.FRequestorRescheduleFlow.CReschedulePage;
import com.AndroidTest.FRequestorRescheduleFlow.DSlotPage;
import org.testng.annotations.Test;

import static com.sun.activation.registries.LogSupport.log;

public class FRequestorRescheduleFlowTest extends BaseClassMobile {

    @Test
    public void rescheduleFlow() throws Exception {

        log("========== REQUESTOR RESCHEDULE FLOW STARTED ==========");


//        // Login
//        ALoginPage loginPage = new ALoginPage(driver);
//        loginPage.login(
//                "0500000055",
//                "Admin@194");
//
//        log("Login Completed Successfully");

        //=========================================================
        // Select Location
        //=========================================================
        Thread.sleep(4000);
        BLocationPage locationPage = new BLocationPage(driver);
        locationPage.selectLocation();

        log("Location Selected Successfully");

        //=========================================================
        // Pending Order
        //=========================================================
        CReschedulePage reschedulePage = new CReschedulePage(driver);
        // Click Pending Orders
        reschedulePage.clickReschedule();
        // Change Order Number Before Execution
        reschedulePage.selectOrderToReschedule("AB-RO-62056");
        log("Order Selected Successfully");

        //=========================================================
        // Click Reschedule
        //=========================================================

        reschedulePage.clickRescheduleButton();
        log("Reschedule Button Clicked");

        //=========================================================
        // Slot Selection
        //=========================================================

        DSlotPage slotPage = new DSlotPage(driver);
        slotPage.selectSlotTiming();
        slotPage.confirmReschedule();
        log("Slot Selected Successfully");
        log("========== REQUESTOR RESCHEDULE FLOW COMPLETED ==========");
    }
}