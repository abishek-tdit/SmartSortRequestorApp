package Testcase;

import Base.ExtentTestListener;
import com.AndroidTest.FRequestorRescheduleFlow.ALoginPage;
import com.AndroidTest.FRequestorRescheduleFlow.BLocationPage;
import com.AndroidTest.FRequestorRescheduleFlow.CReschedulePage;
import com.AndroidTest.FRequestorRescheduleFlow.DSlotPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FRequestorRescheduleFlowTest extends ExtentTestListener {

    @Test
    public void rescheduleFlow() {

        try {

            //.Abishek DS      - 0500098765 Dom
            //.Krishna Kumar   - 0500003576 Corp

            //LOGIN
//            ALoginPage loginPage = new ALoginPage(driver);
//            loginPage.login("0500098765",
//                         "Admin@194");
//
//            //LOCATION
//            HLocationPage locationPage = new HLocationPage(driver);
//            locationPage.selectLocation();

            //RESCHEDULE
            CReschedulePage reschedule = new CReschedulePage(driver);
            reschedule.clickReschedule();
//================================================================================//
                // Change order no before RUN
            reschedule.selectOrderToReschedule("AB-RO-60453");
//================================================================================//
            reschedule.clickRescheduleButton();

            //SLOT PAGE
            DSlotPage slotPage = new DSlotPage(driver);

            slotPage.selectSlotTiming();
            slotPage.confirmReschedule();

            System.out.println("SmartSort Reschedule Flow Completed Successfully");

        }
        catch (Exception e) {

            e.printStackTrace();

            //Screenshot
            takeScreenshot("rescheduleFlow");

            Assert.fail("SmartSort Reschedule Flow Failed : " + e.getMessage());
        }
    }
}