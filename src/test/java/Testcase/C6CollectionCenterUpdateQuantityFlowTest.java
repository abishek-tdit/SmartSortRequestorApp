package Testcase;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import com.AndroidTest.C6CollectionCenterUpdateQuantityFlow.ALoginPage;
import com.AndroidTest.C6CollectionCenterUpdateQuantityFlow.BPickupQuantityOrdersPage;
import org.testng.annotations.Test;

public class C6CollectionCenterUpdateQuantityFlowTest extends BaseClassMobile {

    @Test(priority = 6)
    public void collectionCenterQuantityUpdateTest() throws Exception {

        //TTFVaasan : 0500123001

        //Login:
        ALoginPage loginPage = new ALoginPage();
        loginPage.login("0500123001",
                "Admin@194");

        //Pickup Quantity - Orders:
        BPickupQuantityOrdersPage pickupQuantityOrdersPage = new BPickupQuantityOrdersPage();
        pickupQuantityOrdersPage.clickPickupQuantityOrders();


        ExtentTestListener.logStep("Collection Center Update Quantity 4th Flow Completed");

    }
}