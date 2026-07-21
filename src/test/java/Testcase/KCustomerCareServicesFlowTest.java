package Testcase;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import com.AndroidTest.KCustomerCareServicesFlow.ALoginPage;
import com.AndroidTest.KCustomerCareServicesFlow.BLocationPage;
import com.AndroidTest.KCustomerCareServicesFlow.CCallCustomerCarePage;
import org.testng.annotations.Test;

public class KCustomerCareServicesFlowTest extends BaseClassMobile {

    @Test
    public void CustomerCareServicesFlow() throws Exception {

        //Abishek rtr      - 0500098765 Dom (RO)
        //Jamuna           - 0500445566 Dom (NON RO)

//        //Login:
//        ALoginPage loginPage = new ALoginPage(driver);
//        loginPage.login("0500445566",
//                     "Admin@194");
        Thread.sleep(3000);
        //Location:
        BLocationPage homePage = new BLocationPage(driver);
        homePage.selectLocation();

        //Customer Care:
        CCallCustomerCarePage callPage = new CCallCustomerCarePage(driver);
        callPage.clickCallIcon();
        Thread.sleep(2000);
        callPage.clickCallButton();
        Thread.sleep(3000);
        callPage.navigateBackToHomePage();
        Thread.sleep(2000);

        ExtentTestListener.logStep("Customer Care Services Flow Completed Successfully");
    }
}