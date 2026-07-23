package Testcase;

import Base.BaseClassMobile;
import com.AndroidTest.DRequestorDirectDeliveryOrderPlacingFlow.ALoginPage;
import com.AndroidTest.DRequestorDirectDeliveryOrderPlacingFlow.BLocationPage;
import com.AndroidTest.DRequestorDirectDeliveryOrderPlacingFlow.CDirectDeliveryPage;
import com.AndroidTest.DRequestorDirectDeliveryOrderPlacingFlow.DScheduleDatePage;
import org.testng.annotations.Test;

public class DRequestorDirectDeliveryOrderPlacingFlowTest extends BaseClassMobile {

    @Test
    public void smartSortDirectDeliveryOrderFlow() throws Exception {

        //=====================================================
        // Login
        //=====================================================

//        ALoginPage loginPage = new ALoginPage(driver);
//
//        loginPage.login(
//                "0500000055",
//                "Admin@194");
//        Thread.sleep(5000);
//
//        //=====================================================
//        // Location
//        //=====================================================
//        BLocationPage locationPage = new BLocationPage(driver);
//
//        locationPage.selectLocation();

        //=====================================================
        // Direct Delivery
        //=====================================================

        CDirectDeliveryPage directDeliveryPage = new CDirectDeliveryPage(driver);

        directDeliveryPage.clickDirectDelivery();

        //=====================================================
        // Schedule Date & Time
        //=====================================================

        DScheduleDatePage schedulePage = new DScheduleDatePage(driver);

        schedulePage.clickScheduleDate();
        schedulePage.selectTodayDateAndClickOK();
        schedulePage.clickScheduleTime();
        schedulePage.selectScheduleTime();
        schedulePage.clickContinue();
        schedulePage.clickConfirmAndOK();

        System.out.println("Smart Sort Direct Delivery Order Flow Completed");
    }
}