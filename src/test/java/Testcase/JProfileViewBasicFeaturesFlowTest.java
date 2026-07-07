package Testcase;

import Base.BaseClassMobile;
import com.AndroidTest.JProfileViewBasicFeaturesFlow.*;
import org.testng.annotations.Test;

public class JProfileViewBasicFeaturesFlowTest extends BaseClassMobile {

    @Test
    public void profileViewBasicFeaturesFlow() throws Exception {

        //.Abishek DS      - 0500098765 Dom
        //.Krishna Kumar   - 0500003576 Corp

         //LOGIN
        ALoginPage loginPage = new ALoginPage(driver);
        loginPage.login("0500098765",
                     "Admin@194");

        System.out.println("Login completed successfully");

        // PROFILE ICON
        BHomePage homePage1 = new BHomePage(driver);
        homePage1.clickProfileIcon();

        System.out.println("Profile Icon clicked successfully");

        // VIEW PROFILE + PHOTO UPLOAD
        CProfilePhotoUploadPage profilePage = new CProfilePhotoUploadPage(driver);
        profilePage.clickViewProfile();
        profilePage.uploadProfilePhoto();

        System.out.println("Uploaded Successfully");

        // UPDATE USER DETAILS
        DProfileUserDetailsPage detailsPage = new DProfileUserDetailsPage(driver);
        detailsPage.updateUserDetails();

        System.out.println("Profile User Details Updated Successfully");

        // QR CODE FEATURE
        EViewQRCodePage qrCodePage = new EViewQRCodePage(driver);
        qrCodePage.verifyQRCodeFeature();

        System.out.println("Profile QR Code Feature Completed Successfully");

        // CHANGE PASSWORD
        FChangePasswordPage page = new FChangePasswordPage(driver);
        page.changePassword();

        System.out.println("Password Change Feature Completed Successfully");

        // CONTACT US
        GContactUsPage contactUsPage = new GContactUsPage(driver);
        contactUsPage.submitContactUsForm();

        System.out.println("Contact Us Feature Completed Successfully");
        driver.navigate().back();

        //Location
        HLocationPage homePage2 = new HLocationPage(driver);
        homePage2.selectLocation();

        System.out.println("Bqaiq Location Selected Successfully");

        // YOUR ADDRESS
        IYourAddressPage addressPage = new IYourAddressPage(driver);
        addressPage.validateYourAddressPage();

        System.out.println("Your Address Completed Successfully");

//        // Check For Update
//        JCheckForUpdatePage updatePage = new JCheckForUpdatePage(driver);
//        updatePage.clickCheckForUpdate();
//
//        System.out.println("Check For Update Completed Successfully");

        // FREE UP SPACE
        KFreeUpSpacePage freeUp = new KFreeUpSpacePage(driver);
        freeUp.scrollAndOptimize();

        System.out.println("Free Up Space Action Completed");

        // WHAT'S NEW
        LWhatsNewPage whatsNewPage = new LWhatsNewPage(driver);
        whatsNewPage.verifyWhatsNewFeature();

        System.out.println("What's New Feature Completed Successfully");

        // THEME AND LANGUAGE
        MThemeAndLanguagePage themeAndLanguagePage = new MThemeAndLanguagePage(driver);
        themeAndLanguagePage.verifySettingsFeatures();

        System.out.println("Theme And Language Feature Completed Successfully");
    }
}