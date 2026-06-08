package Testcase;

import Base.BaseClassMobile;
import com.AndroidTest.FProfileViewBasicFeaturesFlow.*;
import org.testng.annotations.Test;

public class FProfileViewBasicFeaturesFlowTest extends BaseClassMobile {

    @Test
    public void profileViewBasicFeaturesFlow() throws Exception {


//        // LOGIN
//        ALoginPage loginPage =
//                new ALoginPage(driver);
//
//        loginPage.login(
//                "0500123456",
//                "Admin@194"
//        );
//
//        System.out.println("Login completed successfully");
//
//
//        // PROFILE ICON
//        BHomePage homePage = new BHomePage(driver);
//
//        homePage.clickProfileIcon();
//
//        System.out.println("Profile Icon clicked successfully");
//
//
//        // VIEW PROFILE + PHOTO UPLOAD
//        CProfilePhotoUploadPage profilePage = new CProfilePhotoUploadPage(driver);
//        profilePage.clickViewProfile();
//
//        System.out.println("View Profile opened successfully");
//
//        profilePage.uploadProfilePhoto();
//
//        System.out.println("Uploaded Successfully");
//
//
//        // UPDATE USER DETAILS
//        DProfileUserDetailsPage detailsPage = new DProfileUserDetailsPage(driver);
//        detailsPage.updateUserDetails();
//
//        System.out.println("Profile User Details Updated Successfully");
//
//
//        // QR CODE FEATURE
//        EViewQRCodePage qrCodePage = new EViewQRCodePage(driver);
//        qrCodePage.verifyQRCodeFeature();
//
//        System.out.println("Profile QR Code Feature Completed Successfully");
//
//
//        // CHANGE PASSWORD
//        FChangePasswordPage changePasswordPage = new FChangePasswordPage(driver);
//        changePasswordPage.changePassword();
//
//        System.out.println("Password Change Feature Completed Successfully");


        // CONTACT US
        GContactUsPage contactUsPage = new GContactUsPage(driver);
        contactUsPage.submitContactUsForm();

        System.out.println("Contact Us Feature Completed Successfully");


        // YOUR ADDRESS
        HYourAddressPage addressPage = new HYourAddressPage(driver);
        addressPage.validateYourAddressPage();

        System.out.println("Your Address Completed Successfully");


//        // Check For Update
//        ICheckForUpdatePage updatePage = new ICheckForUpdatePage(driver);
//        updatePage.clickCheckForUpdate();
//
//        System.out.println("Check For Update Completed Successfully");


        // FREE UP SPACE
        JFreeUpSpacePage freeUp = new JFreeUpSpacePage(driver);
        freeUp.scrollAndOptimize();

        System.out.println("Free Up Space Action Completed");

        // WHAT'S NEW
        KWhatsNewPage whatsNewPage = new KWhatsNewPage(driver);

        whatsNewPage.verifyWhatsNewFeature();

        System.out.println("What's New Feature Completed Successfully");


        // THEME AND LANGUAGE
        LThemeAndLanguagePage themeAndLanguagePage =
                new LThemeAndLanguagePage(driver);

        themeAndLanguagePage.verifySettingsFeatures();

        System.out.println("Theme And Language Feature Completed Successfully");


    }
}
