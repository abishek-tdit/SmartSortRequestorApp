package Testcase;

import Base.BaseClassMobile;

import com.AndroidTest.ESmartBotTicketManagementFlow.ALoginPage;
import com.AndroidTest.ESmartBotTicketManagementFlow.BSmartBotPage;
import com.AndroidTest.ESmartBotTicketManagementFlow.CRaiseTicketPage;
import com.AndroidTest.ESmartBotTicketManagementFlow.DTicketHistoryPage;
import org.testng.annotations.Test;

public class ESmartBotTicketManagementFlowTest extends BaseClassMobile {

    @Test
    public void smartBotTicketManagementFlow() throws Exception {

        // LOGIN FLOW
        ALoginPage loginPage =
                new ALoginPage(driver);

        loginPage.login(
                "0500123456",
                "Admin@194"
        );

        System.out.println("Login completed successfully");


        // OPEN SMART-BOT & START CHAT
        BSmartBotPage smartBotPage =
                new BSmartBotPage(driver);

        smartBotPage.openSmartBotAndStartChat();

        System.out.println("SmartBot opened successfully");


        // RAISE TICKET FLOW
        CRaiseTicketPage raiseTicketPage =
                new CRaiseTicketPage(driver);

        raiseTicketPage.raiseTicket();

        System.out.println("Ticket raised successfully");


        //TICKET MANAGEMENT FLOW
        DTicketHistoryPage ticketHistoryPage =
                new DTicketHistoryPage(driver);

        ticketHistoryPage.viewTicketHistory();

        System.out.println("Ticket History verified successfully");
    }
}