package Testcase;

import Base.BaseClassMobile;
import com.AndroidTest.BSmartSortOrderPlacingFlow.*;
import org.testng.annotations.Test;

public class BSmartSortOrderPlacingFlowTest extends BaseClassMobile {

    @Test
    public void smartSortOrderFlow() throws Exception {

        ALoginPage loginPage = new ALoginPage(driver);
        loginPage.login("0500123456",
                     "Admin@194");

        BHomePage homePage = new BHomePage(driver);
        homePage.selectLocation();

        CPickupPage pickupPage = new CPickupPage(driver);
        pickupPage.selectPickup();

        DSlotPage slotPage = new DSlotPage(driver);
        slotPage.selectSlot();

        System.out.println("Smart Sort Flow Completed");
    }
}