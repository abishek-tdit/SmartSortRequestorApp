package Testcase;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import com.AndroidTest.ERequestorRedeemFlow.*;
import org.testng.annotations.Test;

public class ERequestorRedeemFlowTest extends BaseClassMobile {

    @Test(priority = 1)
    public void redeemFlow() throws Exception {

        ExtentTestListener.logStep("========== REQUESTOR REDEEM FLOW STARTED ==========");

        //Login
        ALoginPage loginPage = new ALoginPage(driver);
        loginPage.login("0500000055",
                "Admin@194");

        ExtentTestListener.logStep("Login Completed Successfully");
        Thread.sleep(4000);

        // Location 1
        BALocationPage1 locationPage1 = new BALocationPage1(driver);
        locationPage1.selectLocation1();

        ExtentTestListener.logStep("Location 1 Selected Successfully");
        Thread.sleep(4000);

        //Available Points
        BBAvailablePointsForRedeemPage page = new BBAvailablePointsForRedeemPage(driver);
        page.redeemPoints1();


        // Business Point History
        CBusinessPointHistoryPage businessPointHistoryPage = new CBusinessPointHistoryPage(driver);
        businessPointHistoryPage.openBusinessPointHistory();
        businessPointHistoryPage.filterBusinessHistory();


        // Partner Store
        DProcessRedeemPointsPartnerStorePage partnerStorePage =
                new DProcessRedeemPointsPartnerStorePage(driver);

        partnerStorePage.proceedRedeem();

        ExtentTestListener.logStep("Partner Store Redeem Completed");
        Thread.sleep(5000);
        //=========================================================
        // Location 2
        //=========================================================

        ELocationPage2 locationPage2 = new ELocationPage2(driver);
        locationPage2.selectLocation2();

        ExtentTestListener.logStep("Location 2 Selected Successfully");

        //=========================================================
        // Redeem & Cash Out
        //=========================================================

        FRedeemCashItOutPage2 redeemPage2 = new FRedeemCashItOutPage2(driver);
        redeemPage2.redeemPoints2();

        ExtentTestListener.logStep("Redeem & Cash Out Completed");

        //=========================================================
        // Convert To Cash
        //=========================================================

        GProcessRedeemPointsConvertToCashPage convertPage =
                new GProcessRedeemPointsConvertToCashPage(driver);

        convertPage.proceedToRedeemPointsAndSelectCheckbox();
        convertPage.clickConvertToCash();
        convertPage.selectSAR10Points();
        convertPage.selectBankTransfer();
        convertPage.clickProceed();
        convertPage.clickConfirm();
        convertPage.clickOkPopup();

        ExtentTestListener.logStep("Convert To Cash Completed");
        Thread.sleep(5000);
        //=========================================================
        // Voucher
        //=========================================================

        HVoucherPage voucherPage = new HVoucherPage(driver);
        voucherPage.clickExploreLocations();
        voucherPage.selectBqaiqLocation();
        voucherPage.scrollAndClickRedeemCashOut();
        voucherPage.clickProceedToRedeemPoints();
        voucherPage.clickVoucher();
        voucherPage.clickCheckbox();
        voucherPage.enterPoints("1000");
        voucherPage.hideKeyboardIfVisible();
        voucherPage.clickRedeemVoucher();
        voucherPage.clickOkPopup();

        ExtentTestListener.logStep("Voucher Redeemed Successfully");

        ExtentTestListener.logStep("========== REQUESTOR REDEEM FLOW COMPLETED ==========");
    }
}