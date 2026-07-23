package Testcase;

import Base.BaseClassMobile;
import com.AndroidTest.CRequestorOrderPlacingFlow.ALoginPage;
import com.AndroidTest.CRequestorOrderPlacingFlow.BLocationPage;
import com.AndroidTest.CRequestorOrderPlacingFlow.CDoorPickupPage;
import com.AndroidTest.CRequestorOrderPlacingFlow.DSlotPage;
import org.testng.annotations.Test;

public class CRequestorOrderPlacingFlowTest extends BaseClassMobile {

    @Test
    public void smartSortOrderFlow() throws Exception {


        // Login
//        ALoginPage loginPage = new ALoginPage(driver);
//
//        loginPage.login(
//                "0500000055",
//                "Admin@194");
        Thread.sleep(5000);

        //=====================================================
        // Location
        //=====================================================
        BLocationPage locationPage = new BLocationPage(driver);
        locationPage.selectLocation();

        //=====================================================
        // Door Pickup
        //=====================================================
        CDoorPickupPage pickupPage = new CDoorPickupPage(driver);
        pickupPage.selectPickup();

        //=====================================================
        // Slot
        //=====================================================
        DSlotPage slotPage = new DSlotPage(driver);
        slotPage.selectSlot();

        System.out.println("Smart Sort Flow Completed");
    }
}