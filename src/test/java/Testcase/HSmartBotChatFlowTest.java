package Testcase;

import Base.BaseClassMobile;
import com.AndroidTest.HSmartBotChatFlow.ALoginPage;
import com.AndroidTest.HSmartBotChatFlow.BSmartBotPage;
import com.AndroidTest.HSmartBotChatFlow.CChatConversationPage;
import org.testng.annotations.Test;

public class HSmartBotChatFlowTest extends BaseClassMobile {

    @Test
    public void smartBotFlow() throws Exception {

        //.Abishek DS      - 0500098765 Dom
        //.Krishna Kumar   - 0500003576 Corp

        //Login
        ALoginPage loginPage = new ALoginPage(driver);
        loginPage.login("0500098765",
                     "Admin@194");

        System.out.println("Login completed successfully");

        //Smart Bot
        BSmartBotPage smartBotPage = new BSmartBotPage(driver);
        smartBotPage.openSmartBotAndStartChat();

        System.out.println("Chat started successfully");

        //Chat Conversation
        CChatConversationPage chatPage = new CChatConversationPage(driver);
        chatPage.askQuestion("Where is my collector?");

        System.out.println("Question sent successfully");
    }
}