package Testcase;

import Base.BaseClassMobile;
import Base.ExtentTestListener;
import Utility.EOrderDataTicketManagement;
import com.AndroidTest.HSmartBotTicketManagementFlow.ASmartBotPage;
import com.AndroidTest.HSmartBotTicketManagementFlow.BRaiseTicketPage;
import com.AndroidTest.HSmartBotTicketManagementFlow.CLoginWebExecutivePage;
import com.AndroidTest.HSmartBotTicketManagementFlow.DTicketHistoryPage;
import org.testng.annotations.Test;

public class HSmartBotTicketManagementFlowTest extends BaseClassMobile {

    @Test(priority = 16)
    public void smartBotTicketManagementFlow() throws InterruptedException {

        //=========================================================
        // OPEN SMART-BOT
        //=========================================================

        ASmartBotPage smartBotPage = new ASmartBotPage(driver);
        smartBotPage.openSmartBotAndStartChat();

        ExtentTestListener.logStep("SmartBot opened successfully");


        //=========================================================
        // Raise Ticket
        //=========================================================

        BRaiseTicketPage raiseTicketPage = new BRaiseTicketPage(driver);
        raiseTicketPage.raiseTicket();

        ExtentTestListener.logStep(
                "Raise Ticket flow completed successfully");


        //=========================================================
        // Verify Saved Ticket ID
        //=========================================================

        System.out.println("==============================================");
        System.out.println("SAVED TICKET DATA");
        System.out.println("==============================================");
        System.out.println("Ticket ID : "
                + EOrderDataTicketManagement.ticketIDNo);
        System.out.println("==============================================");


        // Launch Chrome
        CLoginWebExecutivePage executiveLogin = new CLoginWebExecutivePage();
        executiveLogin.loginExecutive(
                "SOEQA",
                "SOEQA");

        //=========================================================
        // TICKET HISTORY
        //=========================================================

        DTicketHistoryPage ticketHistoryPage = new DTicketHistoryPage(driver);
        ticketHistoryPage.viewTicketHistory();

        ExtentTestListener.logStep("Ticket History verified successfully");
    }
}