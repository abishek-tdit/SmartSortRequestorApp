package Testcase;

import Base.BaseClassMobile;
import com.AndroidTest.F1PlaceOrderForCancelFlow.ALocationPage;
import com.AndroidTest.F1PlaceOrderForCancelFlow.BDoorPickupPage;
import com.AndroidTest.F1PlaceOrderForCancelFlow.CSlotPage;
import com.AndroidTest.F1PlaceOrderForCancelFlow.DSaveOrderNumberForCancel;
import org.testng.annotations.Test;

public class F1PlaceOrderForCancelFlowTest extends BaseClassMobile {

    @Test(priority = 1)
    public void placeOrderForCancelFlow() throws Exception {

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
        DSaveOrderNumberForCancel saveOrder =
                new DSaveOrderNumberForCancel(driver);

        saveOrder.SaveRecentlyPlacedOrderNumber();
    }
}