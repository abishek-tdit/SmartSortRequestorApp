package Testcase;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import com.AndroidTest.HSmartBotTicketManagementFlow.BSmartBotPage;
import com.AndroidTest.HSmartBotTicketManagementFlow.CRaiseTicketPage;
import com.AndroidTest.HSmartBotTicketManagementFlow.DTicketHistoryPage;
import org.testng.annotations.Test;

public class HSmartBotTicketManagementFlowTest extends BaseClassMobile {

    @Test(priority = 5)
    public void smartBotTicketManagementFlow() {

        //=========================================================
        // LOGIN
        //=========================================================

//        ALoginPage loginPage = new ALoginPage(driver);
//        loginPage.login("0500000055", "Admin@194");
//
//        ExtentTestListener.logStep("Login completed successfully");

        //=========================================================
        // OPEN SMART-BOT
        //=========================================================

        BSmartBotPage smartBotPage = new BSmartBotPage(driver);
        smartBotPage.openSmartBotAndStartChat();

        ExtentTestListener.logStep("SmartBot opened successfully");

        //=========================================================
        // RAISE TICKET
        //=========================================================

        CRaiseTicketPage raiseTicketPage = new CRaiseTicketPage(driver);
        raiseTicketPage.raiseTicket();

        ExtentTestListener.logStep("Ticket raised successfully");

        //=========================================================
        // TICKET HISTORY
        //=========================================================

        DTicketHistoryPage ticketHistoryPage = new DTicketHistoryPage(driver);
        ticketHistoryPage.viewTicketHistory();

        ExtentTestListener.logStep("Ticket History verified successfully");
    }
}