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

        //Abiram abi      - 0500000055 Dom

        //Login:
//        ALoginPage loginPage = new ALoginPage(driver);
//        loginPage.login("0500000055",
//                     "Admin@194");
        Thread.sleep(3000);

        //Location:
        BLocationPage homePage = new BLocationPage(driver);
        homePage.selectLocation();
        Thread.sleep(3000);

        //Customer Care:
        CCallCustomerCarePage callPage = new CCallCustomerCarePage(driver);
        callPage.clickCallIcon();

        callPage.clickCallButton();

        callPage.navigateBackToHomePage();


        ExtentTestListener.logStep("Customer Care Services Flow Completed Successfully");
    }
}