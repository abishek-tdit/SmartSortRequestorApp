package Testcase;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import com.AndroidTest.HSmartBotChatFlow.ALoginPage;
import com.AndroidTest.HSmartBotChatFlow.BSmartBotPage;
import com.AndroidTest.HSmartBotChatFlow.CChatConversationPage;
import org.testng.annotations.Test;

public class HSmartBotChatFlowTest extends BaseClassMobile {

    @Test(priority = 1)
    public void smartBotFlow() throws InterruptedException {

        ExtentTestListener.logStep("========== SMARTBOT TEST STARTED ==========");
        //Abiram abi      - 0500000055 Dom
        // Login
//        ALoginPage loginPage = new ALoginPage(driver);
//        loginPage.login("0500000055",
//                        "Admin@194");
//
//        ExtentTestListener.logStep("Login Completed Successfully");

        // Open SmartBot
        BSmartBotPage smartBotPage = new BSmartBotPage(driver);
        smartBotPage.openSmartBotAndStartChat();

        ExtentTestListener.logStep("SmartBot Opened Successfully");

        // Chat
        CChatConversationPage chatPage = new CChatConversationPage(driver);

        chatPage.askQuestion("Where is my collector?");
        chatPage.closeSmartBot();

        ExtentTestListener.logStep("Question 1 Completed");

        ExtentTestListener.logStep("========== SMARTBOT TEST COMPLETED ==========");
        Thread.sleep(5000);
    }

}