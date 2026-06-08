package Testcase;

import Base.BaseClassMobile;
import com.AndroidTest.GCustomerCareServicesFlow.ALoginPage;
import com.AndroidTest.GCustomerCareServicesFlow.BCallCustomerCarePage;
import org.testng.annotations.Test;

public class GCustomerCareServicesFlowTest extends BaseClassMobile {

    @Test
    public void CustomerCareServicesFlow() throws Exception {

        // Login
        ALoginPage loginPage = new ALoginPage(driver);
        loginPage.login();

        Thread.sleep(3000);

        // Customer Care
        BCallCustomerCarePage callPage = new BCallCustomerCarePage(driver);

        callPage.clickCallIcon();

        Thread.sleep(2000);

        callPage.clickCallButton();

        Thread.sleep(3000);

        System.out.println("Customer Care Services Flow Completed Successfully");


        // Navigate Back to home page
        callPage.clickCallButton();

        Thread.sleep(5000); // Wait for dialer to open

        callPage.navigateBackToHomePage();

        Thread.sleep(3000);
    }

}