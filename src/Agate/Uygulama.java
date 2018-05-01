package Agate;

import Agate.help.Database;
import Agate.help.Utils;
import Agate.help.ScanHelper;
import Agate.UI.AddNewCampaignUI;
import Agate.UI.AddNewClientUI;
import Agate.UI.AddNewMemberStaffUI;
import Agate.UI.AssignStaffOnCampaignUI;

public class Uygulama {

    public static void main(String[] args) {
        Database.init();
        int choice;

        while(true) {
            //Brand UI
            Utils.printLine(49);
            Utils.print("|                                               |");
            Utils.print("|                   AGATE LTD                   |");
            Utils.print("|                                               |");

            //Menu UI
            Utils.printLine(49);
            Utils.print("|     1- Add a new client                       |");
            Utils.print("|     2- Add a new campaign                     |");
            Utils.print("|     5- Assign staff to work on a campaign     |");
            Utils.print("|     11- Add a new advert to a campaign        |");
            Utils.print("|     12- Add a new member of staff             |");
            Utils.print("|     999- Exit                                 |");
            Utils.printLine(49);

            Utils.print("Enter a number=> ", true);
            choice = ScanHelper.scanInt();
            Utils.printLine(49);
            switch(choice) {

                case 1:
                    AddNewClientUI.getInstance();
                    break;
                case 2:
                    AddNewCampaignUI.getInstance();
                    break;
                case 5:
                    AssignStaffOnCampaignUI.getInstance();
                    break;
                case 11:
                    Utils.print("add a new advert to a campaign");
                    break;
                case 12:
                    AddNewMemberStaffUI.getInstance();
                    break;
                case 999:
                    Utils.print("exit");
                    System.exit(0);
                    break;
                default:
                    Utils.print("error, try enter a number");
                    break;
            }
            Utils.printRow(40);
        }

    }

}