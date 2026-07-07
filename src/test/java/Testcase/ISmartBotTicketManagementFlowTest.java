package Testcase;

import Base.BaseClassMobile;
import com.AndroidTest.ISmartBotTicketManagementFlow.ALoginPage;
import com.AndroidTest.ISmartBotTicketManagementFlow.BSmartBotPage;
import com.AndroidTest.ISmartBotTicketManagementFlow.CRaiseTicketPage;
import com.AndroidTest.ISmartBotTicketManagementFlow.DTicketHistoryPage;
import org.testng.annotations.Test;

public class ISmartBotTicketManagementFlowTest extends BaseClassMobile {

    @Test
    public void smartBotTicketManagementFlow() throws Exception {

        //.Abishek DS      - 0500098765 Dom
        //.Krishna Kumar   - 0500003576 Corp

        //LOGIN FLOW
        ALoginPage loginPage = new ALoginPage(driver);
        loginPage.login("0500098765",
                     "Admin@194");

        System.out.println("Login completed successfully");

        // OPEN SMART-BOT & START CHAT
        BSmartBotPage smartBotPage = new BSmartBotPage(driver);
        smartBotPage.openSmartBotAndStartChat();

        System.out.println("SmartBot opened successfully");

        // RAISE TICKET FLOW
        CRaiseTicketPage raiseTicketPage = new CRaiseTicketPage(driver);
        raiseTicketPage.raiseTicket();

        System.out.println("Ticket raised successfully");

        //TICKET MANAGEMENT FLOW
        DTicketHistoryPage ticketHistoryPage = new DTicketHistoryPage(driver);
        ticketHistoryPage.viewTicketHistory();

        System.out.println("Ticket History verified successfully");
    }
}