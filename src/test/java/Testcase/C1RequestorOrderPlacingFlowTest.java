package Testcase;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import com.AndroidTest.C1RequestorOrderPlacingFlow.*;
import org.testng.annotations.Test;

public class C1RequestorOrderPlacingFlowTest extends BaseClassMobile {

    @Test(priority = 3)
    public void smartSortOrderFlow() throws Exception {


        // Login
        ALoginPage loginPage = new ALoginPage(driver);
        loginPage.login("0500000055",
                "Admin@194");

        // Location
        BLocationPage locationPage = new BLocationPage(driver);
        locationPage.selectLocation();

        // Door Pickup
        CDoorPickupPage pickupPage = new CDoorPickupPage(driver);
        pickupPage.selectPickup();

        // Slot
        DSlotPage slotPage = new DSlotPage(driver);
        slotPage.selectSlot();

        //save order number
        ESaveOrderNumberForDoorPickup saveOrder = new ESaveOrderNumberForDoorPickup(driver);
        saveOrder.saveRecentlyPlacedOrderNumber();

        ExtentTestListener.logStep("Smart Sort Flow Completed");
    }
}