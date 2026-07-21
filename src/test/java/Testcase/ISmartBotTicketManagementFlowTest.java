package Testcase;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import com.AndroidTest.ISmartBotTicketManagementFlow.ALoginPage;
import com.AndroidTest.ISmartBotTicketManagementFlow.BSmartBotPage;
import com.AndroidTest.ISmartBotTicketManagementFlow.CRaiseTicketPage;
import com.AndroidTest.ISmartBotTicketManagementFlow.DTicketHistoryPage;
import org.testng.annotations.Test;

public class ISmartBotTicketManagementFlowTest extends BaseClassMobile {

    @Test
    public void smartBotTicketManagementFlow() throws Exception {

        //Abishek rtr      - 0500098765 Dom (RO)
        //Jamuna           - 0500445566 Dom (NON RO)

        //LOGIN FLOW:
//        ALoginPage loginPage = new ALoginPage(driver);
//        loginPage.login("0500445566",
//                     "Admin@194");
//
//        ExtentTestListener.logStep("Login completed successfully");
//
//        // OPEN SMART-BOT & START CHAT:
//        BSmartBotPage smartBotPage = new BSmartBotPage(driver);
//        smartBotPage.openSmartBotAndStartChat();
//
//        ExtentTestListener.logStep("SmartBot opened successfully");

        // RAISE TICKET FLOW:
        CRaiseTicketPage raiseTicketPage = new CRaiseTicketPage(driver);
        raiseTicketPage.raiseTicket();

        ExtentTestListener.logStep("Ticket raised successfully");

        //TICKET MANAGEMENT FLOW:
        DTicketHistoryPage ticketHistoryPage = new DTicketHistoryPage(driver);
        ticketHistoryPage.viewTicketHistory();

        ExtentTestListener.logStep("Ticket History verified successfully");
    }
}