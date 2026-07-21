package Testcase;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import com.AndroidTest.ERequestorRedeemFlow.*;
import com.AndroidTest.ERequestorRedeemFlow.ELocationPage2;
import com.AndroidTest.ERequestorRedeemFlow.FRedeemCashItOutPage2;
import org.testng.annotations.Test;

public class ERequestorRedeemFlowTest extends BaseClassMobile {

    @Test
    public void redeemFlow() throws Exception {

        //Abishek rtr      - 0500098765 Dom (RO)
        //Jamuna           - 0500445566 Dom (NON RO)

        //LOGIN:
        ALoginPage loginPage = new ALoginPage(driver);
        loginPage.login("0500445566",
                     "Admin@194");

        ExtentTestListener.logStep("Login completed successfully");
        Thread.sleep(3000);

        //LOCATION SELECTION:
        BLocationPage1 locationPage = new BLocationPage1(driver);
        locationPage.selectLocation1();

        ExtentTestListener.logStep("Location selected successfully");


        //REDEEM CASH OUT:
        CRedeemCashItOutPage1 redeemPage = new CRedeemCashItOutPage1(driver);
        redeemPage.redeemPoints1();

        ExtentTestListener.logStep("Redeem Cash Out completed successfully");

        //PARTNER STORE:
        DProcessRedeemPointsPartnerStorePage proceedPage =
                new DProcessRedeemPointsPartnerStorePage(driver);
        proceedPage.proceedRedeem();

        ExtentTestListener.logStep("Partner store redeem completed successfully");

        //LOCATION SELECTION:
        ELocationPage2 locationPage2 = new ELocationPage2(driver);
        locationPage2.selectLocation2();

        ExtentTestListener.logStep("Location selected successfully");

        //REDEEM CASH OUT:
        FRedeemCashItOutPage2 redeemPage2 = new FRedeemCashItOutPage2(driver);
        redeemPage2.redeemPoints2();

        ExtentTestListener.logStep("Redeem Cash Out completed successfully");

        //CONVERT TO CASH:
        GProcessRedeemPointsConvertToCashPage convertPage =
                new GProcessRedeemPointsConvertToCashPage(driver);
        convertPage.proceedToRedeemPointsAndSelectCheckbox();
        convertPage.clickConvertToCash();
        convertPage.selectSAR10Points();
        convertPage.selectBankTransfer();
      //convertPage.enterMiddleName("Raman");
        convertPage.clickProceed();
        convertPage.clickConfirm();
        convertPage.clickOkPopup();

        ExtentTestListener.logStep("Convert to Cash flow completed");
        Thread.sleep(3000);
        //Voucher:
        HVoucherPage voucherPage = new HVoucherPage(driver);
        voucherPage.clickExploreLocations();
        Thread.sleep(5000);
        voucherPage.selectAsyutLocation();
        Thread.sleep(8000);
        voucherPage.scrollDown();
        Thread.sleep(3000);
        voucherPage.clickRedeemCashOut();
        Thread.sleep(3000);
        voucherPage.clickProceedToRedeemPoints();
        Thread.sleep(3000);
        voucherPage.clickVoucher();
        Thread.sleep(2000);
        voucherPage.clickCheckbox();
        Thread.sleep(2000);
        voucherPage.enterPoints("1000");
        Thread.sleep(2000);
        voucherPage.hideKeyboardIfVisible();
        Thread.sleep(2000);
        voucherPage.clickRedeemVoucher();
        Thread.sleep(2000);
        voucherPage.clickOkPopup();

        ExtentTestListener.logStep("FULL FLOW COMPLETED SUCCESSFULLY");
        Thread.sleep(3000);
    }
}