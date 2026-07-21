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

            //Abishek rtr      - 0500098765 Dom (RO)
            //Jamuna           - 0500445566 Dom (NON RO)

//            //LOGIN:
//            ALoginPage loginPage = new ALoginPage(driver);
//            loginPage.login("0500445566",
//                         "Admin@194");
//            Thread.sleep(3000);
//            //LOCATION:
//            BLocationPage locationPage = new BLocationPage(driver);
//            locationPage.selectLocation();
            Thread.sleep(3000);

            //RESCHEDULE:
            CReschedulePage reschedule = new CReschedulePage(driver);
            reschedule.clickReschedule();
//================================================================================//
//================================================================================//
                      // Change order no before RUN:
            reschedule.selectOrderToReschedule("AB-RO-62004");
//================================================================================//
//================================================================================//
            reschedule.clickRescheduleButton();

            //SLOT PAGE:
            DSlotPage slotPage = new DSlotPage(driver);

            slotPage.selectSlotTiming();
            slotPage.confirmReschedule();

            ExtentTestListener.logStep("SmartSort Reschedule Flow Completed Successfully");

        }
        catch (Exception e)
        {
            e.printStackTrace();

            //Screenshot
            takeScreenshot("rescheduleFlow");

            Assert.fail("SmartSort Reschedule Flow Failed : " + e.getMessage());
        }
    }
}