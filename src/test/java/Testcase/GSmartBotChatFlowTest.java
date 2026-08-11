package Testcase;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import com.AndroidTest.GSmartBotChatFlow.BSmartBotPage;
import com.AndroidTest.GSmartBotChatFlow.CChatConversationPage;
import org.testng.annotations.Test;

public class GSmartBotChatFlowTest extends BaseClassMobile {

    @Test(priority = 15)
    public void smartBotFlow() throws InterruptedException {

        ExtentTestListener.logStep("========== SMARTBOT TEST STARTED ==========");

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