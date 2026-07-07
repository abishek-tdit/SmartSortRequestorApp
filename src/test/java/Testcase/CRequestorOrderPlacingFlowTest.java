package Testcase;

import Base.BaseClassMobile;
import com.AndroidTest.CRequestorOrderPlacingFlow.*;
import org.testng.annotations.Test;

public class CRequestorOrderPlacingFlowTest extends BaseClassMobile {

    @Test
    public void smartSortOrderFlow() throws Exception {

        //.Abishek DS      - 0500098765 Dom
        //.Krishna Kumar   - 0500003576 Corp

//        //Login
//        ALoginPage loginPage = new ALoginPage(driver);
//        loginPage.login("0500098765",
//                     "Admin@194");

        //Location
        BLocationPage homePage = new BLocationPage(driver);
        homePage.selectLocation();

        //Door Pickup
        CDoorPickupPage pickupPage = new CDoorPickupPage(driver);
        pickupPage.selectPickup();

        //Slot
        DSlotPage slotPage = new DSlotPage(driver);
        slotPage.selectSlot();

        System.out.println("Smart Sort Flow Completed");
    }
}