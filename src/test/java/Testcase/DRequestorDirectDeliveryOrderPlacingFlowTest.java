package Testcase;

import Base.BaseClassMobile;
import com.AndroidTest.DRequestorDirectDeliveryOrderPlacingFlow.*;
import org.testng.annotations.Test;

public class DRequestorDirectDeliveryOrderPlacingFlowTest extends BaseClassMobile {

    @Test
    public void smartSortDirectDeliveryOrderFlow() throws Exception {

        //.Abishek DS      - 0500098765 Dom
        //.Krishna Kumar   - 0500003576 Corp

//        //Login
//        ALoginPage loginPage = new ALoginPage(driver);
//        loginPage.login("0500098765",
//                         "Admin@194");

        //Location
        BLocationPage homePage = new BLocationPage(driver);
        homePage.selectLocation();

        //Direct Delivery
        CDirectDeliveryPage pickupPage = new CDirectDeliveryPage(driver);
        pickupPage.clickDirectDelivery();

        //Schedule Date
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