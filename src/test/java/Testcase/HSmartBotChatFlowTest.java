package Testcase;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import com.AndroidTest.HSmartBotChatFlow.ALoginPage;
import com.AndroidTest.HSmartBotChatFlow.BSmartBotPage;
import com.AndroidTest.HSmartBotChatFlow.CChatConversationPage;
import org.testng.annotations.Test;

public class HSmartBotChatFlowTest extends BaseClassMobile {

    @Test
    public void smartBotFlow() throws Exception {

        //Abishek rtr      - 0500098765 Dom (RO)
        //Jamuna           - 0500445566 Dom (NON RO)

        //Login:
//        ALoginPage loginPage = new ALoginPage(driver);
//        loginPage.login("0500445566",
//                     "Admin@194");
//
//        ExtentTestListener.logStep("Login completed successfully");

        //Smart Bot:
        BSmartBotPage smartBotPage = new BSmartBotPage(driver);
        smartBotPage.openSmartBotAndStartChat();

        ExtentTestListener.logStep("Chat started successfully");

        //Chat Conversation:
        CChatConversationPage chatPage = new CChatConversationPage(driver);
        chatPage.askQuestion("Where is my collector?");

        ExtentTestListener.logStep("Answer Received successfully");
    }
}