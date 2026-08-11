package Testcase;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import com.AndroidTest.JCustomerCareServicesFlow.BLocationPage;
import com.AndroidTest.JCustomerCareServicesFlow.CCallCustomerCarePage;
import org.testng.annotations.Test;

public class JCustomerCareServicesFlowTest extends BaseClassMobile {

    @Test(priority = 18)
    public void CustomerCareServicesFlow() throws Exception {

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