package Testcase;

import Base.BaseClassMobile;

import com.AndroidTest.CSmartSortRedeemFlow.ALoginPage;
import com.AndroidTest.CSmartSortRedeemFlow.BLocationPage;
import com.AndroidTest.CSmartSortRedeemFlow.CRedeemCashOutPage;
import com.AndroidTest.CSmartSortRedeemFlow.DProcessRedeemPointsPage;

import org.testng.annotations.Test;

public class CSmartSortRedeemFlowTest extends BaseClassMobile {

    @Test
    public void redeemFlow() throws Exception {

        // LOGIN FLOW
        ALoginPage loginPage =
                new ALoginPage(driver);

        loginPage.login(
                "0500123456",
                "Admin@194"
        );

        System.out.println("Login completed successfully");


        // LOCATION SELECTION FLOW
        BLocationPage locationPage =
                new BLocationPage(driver);

        locationPage.selectLocation();

        System.out.println("Location selected successfully");


        // REDEEM CASH OUT FLOW
        CRedeemCashOutPage redeemPage =
                new CRedeemCashOutPage(driver);

        redeemPage.redeemPoints();

        System.out.println("Redeem Cash Out completed successfully");


        // PROCEED REDEEM FLOW
        DProcessRedeemPointsPage proceedPage =
                new DProcessRedeemPointsPage(driver);

        proceedPage.proceedRedeem();

        System.out.println("Proceed Redeem completed successfully");
    }
}