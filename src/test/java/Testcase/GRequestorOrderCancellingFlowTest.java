package Testcase;

import Base.ExtentTestListener;
import com.AndroidTest.GRequestorOrderCancellingFlow.ALoginPage;
import com.AndroidTest.GRequestorOrderCancellingFlow.BLocationPage;
import com.AndroidTest.GRequestorOrderCancellingFlow.CCancelPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GRequestorOrderCancellingFlowTest extends ExtentTestListener {

    @Test
    public void cancelFlowTest() {

        try {

            //.Abishek DS      - 0500098765 Dom
            //.Krishna Kumar   - 0500003576 Corp

            //LOGIN
            ALoginPage loginPage = new ALoginPage(driver);
            loginPage.login("0500098765",
                         "Admin@194");

            //LOCATION
            BLocationPage locationPage = new BLocationPage(driver);
            locationPage.selectLocation();

            //CANCEL
            CCancelPage cancelPage = new CCancelPage(driver);
            cancelPage.openPendingOrders();
//================================================================================//
            // Change order no before RUN
            cancelPage.selectOrderToCancel("AB-RO-60453");
//================================================================================//
            cancelPage.clickCancelButton();
            cancelPage.selectCancelReason();
            cancelPage.clickSubmit();
            cancelPage.clickOkPopup();
            System.out.println("Cancel Flow Login → Location → Pending Order Completed Successfully");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            takeScreenshot("cancelFlow_LoginLocation");
            Assert.fail("Cancel Flow (Login + Location) Failed : " + e.getMessage());
        }
    }
}