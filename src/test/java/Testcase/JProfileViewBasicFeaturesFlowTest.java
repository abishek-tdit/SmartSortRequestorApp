package Testcase;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import com.AndroidTest.JProfileViewBasicFeaturesFlow.*;
import org.testng.annotations.Test;

public class JProfileViewBasicFeaturesFlowTest extends BaseClassMobile {

    @Test
    public void profileViewBasicFeaturesFlow() throws Exception {

        //Abishek rtr      - 0500098765 Dom (RO)
        //Jamuna           - 0500445566 Dom (NON RO)

         //LOGIN:
//        ALoginPage loginPage = new ALoginPage(driver);
//        loginPage.login("0500445566",
//                     "Admin@194");
//
//         ExtentTestListener.logStep("Login completed successfully");

        //PROFILE ICON:
        BHomePage homePage1 = new BHomePage(driver);
        homePage1.clickProfileIcon();

        ExtentTestListener.logStep("Profile Icon clicked successfully");

        // VIEW PROFILE + PHOTO UPLOAD:
        CProfilePhotoUploadPage profilePage = new CProfilePhotoUploadPage(driver);
        profilePage.clickViewProfile();
        profilePage.uploadProfilePhoto();

        ExtentTestListener.logStep("Uploaded Successfully");

        // UPDATE USER DETAILS:
        DProfileUserDetailsPage detailsPage = new DProfileUserDetailsPage(driver);
        detailsPage.updateUserDetails();

        ExtentTestListener.logStep("Profile User Details Updated Successfully");

        // QR CODE FEATURE:
        EViewQRCodePage qrCodePage = new EViewQRCodePage(driver);
        qrCodePage.verifyQRCodeFeature();

        ExtentTestListener.logStep("Profile QR Code Feature Completed Successfully");

        // CHANGE PASSWORD:
        FChangePasswordPage page = new FChangePasswordPage(driver);
        page.changePassword();

        ExtentTestListener.logStep("Password Change Feature Completed Successfully");

        // CONTACT US:
        GContactUsPage contactUsPage = new GContactUsPage(driver);
        contactUsPage.submitContactUsForm();

        ExtentTestListener.logStep("Contact Us Feature Completed Successfully");
        driver.navigate().back();

        //Location:
        HLocationPage homePage2 = new HLocationPage(driver);
        homePage2.selectLocation();

        ExtentTestListener.logStep("Bqaiq Location Selected Successfully");

        //YOUR ADDRESS:
        IYourAddressPage addressPage = new IYourAddressPage(driver);
        addressPage.validateYourAddressPage();

        ExtentTestListener.logStep("Your Address Completed Successfully");

//        //Check For Update:
//        JCheckForUpdatePage updatePage = new JCheckForUpdatePage(driver);
//        updatePage.clickCheckForUpdate();
//
//        System.out.println("Check For Update Completed Successfully");

        //FREE UP SPACE:
        KFreeUpSpacePage freeUp = new KFreeUpSpacePage(driver);
        freeUp.scrollAndOptimize();

        ExtentTestListener.logStep("Free Up Space Action Completed");

        //WHAT'S NEW:
        LWhatsNewPage whatsNewPage = new LWhatsNewPage(driver);
        whatsNewPage.verifyWhatsNewFeature();

        ExtentTestListener.logStep("What's New Feature Completed Successfully");

        //THEME AND LANGUAGE:
        MThemeAndLanguagePage themeAndLanguagePage = new MThemeAndLanguagePage(driver);
        themeAndLanguagePage.verifySettingsFeatures();

        ExtentTestListener.logStep("Theme And Language Feature Completed Successfully");
    }
}