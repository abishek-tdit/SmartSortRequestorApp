package Testcase;

import Base.BaseClassMobile;
import com.AndroidTest.E1PlaceOrderForRescheduleFlow.ALocationPage;
import com.AndroidTest.E1PlaceOrderForRescheduleFlow.BDoorPickupPage;
import com.AndroidTest.E1PlaceOrderForRescheduleFlow.CSlotPage;
import com.AndroidTest.E1PlaceOrderForRescheduleFlow.DSaveOrderNumberForReschedule;
import org.testng.annotations.Test;

public class E1PlaceOrderForRescheduleFlowTest extends BaseClassMobile {

    @Test(priority = 11)
    public void placeOrderForRescheduleFlow() throws Exception {

        //=========================================================
        // Select Location
        //=========================================================
        ALocationPage locationPage = new ALocationPage(driver);
        locationPage.selectLocation();

        //=========================================================
        // Door Pickup
        //=========================================================
        BDoorPickupPage doorPickupPage = new BDoorPickupPage(driver);
        doorPickupPage.selectPickup();

        //=========================================================
        // Select Slot
        //=========================================================
        CSlotPage slotPage = new CSlotPage(driver);
        slotPage.selectSlot();

        //=========================================================
        // Save Order Number
        //=========================================================
        DSaveOrderNumberForReschedule saveOrder =
                new DSaveOrderNumberForReschedule(driver);

        saveOrder.saveRecentlyPlacedOrderNumber();
    }
}