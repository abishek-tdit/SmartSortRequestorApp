package Testcase;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import com.AndroidTest.DRequestorRedeemFlow.*;
import org.testng.annotations.Test;

public class DRequestorRedeemFlowTest extends BaseClassMobile {

    @Test(priority = 8)
    public void redeemFlow() throws Exception {

        ExtentTestListener.logStep("========== REQUESTOR REDEEM FLOW STARTED ==========");

        //=========================================================
        // Launch SmartSort App
        //=========================================================
        driver.activateApp("com.abqaiq.smartsort");
        ExtentTestListener.logStep("Smart Sort App Launched Successfully");
        Thread.sleep(4000);

        // Location 1
        ALocationPage1 locationPage1 = new ALocationPage1(driver);
        locationPage1.selectLocation();

        ExtentTestListener.logStep("Location 1 Selected Successfully");
        Thread.sleep(4000);


        //=========================================================
        // Redeem & Cash Out 1
        //=========================================================
        BRedeemCashItOutPage1 redeemPage1 = new BRedeemCashItOutPage1(driver);
        redeemPage1.redeemPoints1();

        ExtentTestListener.logStep("Redeem & Cash Out Completed");

        //Available Points
        CAvailablePointsPage page = new CAvailablePointsPage(driver);
        page.availablePoints();


        // Business Point History
        DBusinessPointHistoryPage businessPointHistoryPage = new DBusinessPointHistoryPage(driver);
        businessPointHistoryPage.openBusinessPointHistory();
        businessPointHistoryPage.filterBusinessHistory();


        // Partner Store
        EProcessRedeemPointsPartnerStorePage partnerStorePage =
                new EProcessRedeemPointsPartnerStorePage(driver);

        partnerStorePage.proceedRedeem();

        ExtentTestListener.logStep("Partner Store Redeem Completed");
        Thread.sleep(5000);

        // Location 2
        FLocationPage2 locationPage2 = new FLocationPage2(driver);
        locationPage2.selectLocation();

        ExtentTestListener.logStep("Location 2 Selected Successfully");
        Thread.sleep(4000);

        //=========================================================
        // Redeem & Cash Out 2
        //=========================================================
        GRedeemCashItOutPage2 redeemPage2 = new GRedeemCashItOutPage2(driver);
        redeemPage2.redeemPoints2();

        ExtentTestListener.logStep("Redeem & Cash Out Completed");


        // Convert To Cash
        HProcessRedeemPointsConvertToCashPage convertPage =
                new HProcessRedeemPointsConvertToCashPage(driver);

        convertPage.proceedToRedeemPointsAndSelectCheckbox();
        convertPage.clickConvertToCash();
        convertPage.selectSAR10Points();
        convertPage.selectBankTransfer();
        convertPage.clickProceed();
        convertPage.clickConfirm();
        convertPage.clickOkPopup();

        ExtentTestListener.logStep("Convert To Cash Completed");
        Thread.sleep(5000);

        // Location 3
        ILocationPage3 locationPage3 = new ILocationPage3(driver);
        locationPage3.selectLocation();

        ExtentTestListener.logStep("Location 2 Selected Successfully");
        Thread.sleep(4000);

        //=========================================================
        // Redeem & Cash Out 3
        //=========================================================
        JRedeemCashItOutPage3 redeemPage3 = new JRedeemCashItOutPage3(driver);
        redeemPage3.redeemPoints3();

        ExtentTestListener.logStep("Redeem & Cash Out Completed");


        // Voucher
        KVoucherPage voucherPage = new KVoucherPage(driver);
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