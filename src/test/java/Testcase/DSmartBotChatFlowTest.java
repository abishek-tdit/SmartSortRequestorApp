package Testcase;

import Base.BaseClassMobile;

import com.AndroidTest.DSmartBotChatFlow.ALoginPage;
import com.AndroidTest.DSmartBotChatFlow.BSmartBotPage;
import com.AndroidTest.DSmartBotChatFlow.CChatConversationPage;

import org.testng.annotations.Test;

public class DSmartBotChatFlowTest extends BaseClassMobile {

    @Test
    public void smartBotFlow() throws Exception {

        ALoginPage loginPage =
                new ALoginPage(driver);

        loginPage.login(
                "0500123456",
                "Admin@194"
        );

        System.out.println("Login completed successfully");

        BSmartBotPage smartBotPage =
                new BSmartBotPage(driver);

        smartBotPage.openSmartBotAndStartChat();

        System.out.println("Chat started successfully");

        CChatConversationPage chatPage =
                new CChatConversationPage(driver);

        chatPage.askQuestion(
                "Where is my collector?"
        );

        System.out.println("Question sent successfully");
    }
}