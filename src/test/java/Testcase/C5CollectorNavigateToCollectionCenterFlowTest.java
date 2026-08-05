package Testcase;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import com.AndroidTest.C5CollectorNavigateToCollectionCenterFlow.ALoginPage;
import com.AndroidTest.C5CollectorNavigateToCollectionCenterFlow.BCollectorNavigateToCollectionCenterDOPage;
import com.AndroidTest.C5CollectorNavigateToCollectionCenterFlow.CLogoutPage;
import org.testng.annotations.Test;

public class C5CollectorNavigateToCollectionCenterFlowTest extends BaseClassMobile {

    @Test(priority = 5)
    public void collectorNavigateToCollectionCenterTest() throws Exception {

        //Rahul  : 0500055447
        //TDIT   : 0500000654

        // Login:
        ALoginPage loginPage = new ALoginPage();
        loginPage.login("0500055447",
                "Admin@194");

        //Collector Navigate To Collection Center:
        BCollectorNavigateToCollectionCenterDOPage doPage = new BCollectorNavigateToCollectionCenterDOPage();
        doPage.openAcceptedDeliveryOrders();

        //Logout:
        CLogoutPage logoutPage = new CLogoutPage(driver);
        logoutPage.clearStorage();

        ExtentTestListener.logStep("Collector  Navigate 3rd  Flow Completed Successfully");
    }
}