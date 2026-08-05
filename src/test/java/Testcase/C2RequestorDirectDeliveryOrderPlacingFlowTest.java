package Testcase;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import com.AndroidTest.C2RequestorDirectDeliveryOrderPlacingFlow.ALocationPage;
import com.AndroidTest.C2RequestorDirectDeliveryOrderPlacingFlow.BDirectDeliveryPage;
import com.AndroidTest.C2RequestorDirectDeliveryOrderPlacingFlow.CScheduleDatePage;
import org.testng.annotations.Test;

public class C2RequestorDirectDeliveryOrderPlacingFlowTest extends BaseClassMobile {

    @Test(priority = 2)
    public void smartSortDirectDeliveryOrderFlow() throws Exception {

        Thread.sleep(5000);
        // Location
        ALocationPage locationPage = new ALocationPage(driver);
        locationPage.selectLocation();

        Thread.sleep(5000);
        // Direct Delivery
        BDirectDeliveryPage directDeliveryPage = new BDirectDeliveryPage(driver);
        directDeliveryPage.clickDirectDelivery();

        // Schedule Date & Time
        CScheduleDatePage schedulePage = new CScheduleDatePage(driver);
        schedulePage.clickScheduleDate();
        schedulePage.selectTodayDateAndClickOK();
        schedulePage.clickScheduleTime();
        schedulePage.selectScheduleTime();
        schedulePage.clickContinue();
        schedulePage.clickConfirmAndOK();

        ExtentTestListener.logStep("Smart Sort Direct Delivery Order Flow Completed");
        Thread.sleep(7000);
    }
}