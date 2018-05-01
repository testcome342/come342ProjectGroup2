package Agate.UI;

import Agate.control.AssignStaffOnCampaign;
import Agate.domain.Client;
import Agate.help.ScanHelper;
import Agate.help.Utils;

import java.util.List;

public class AssignStaffOnCampaignUI {



    private static AssignStaffOnCampaignUI instance;

    public static AssignStaffOnCampaignUI getInstance() {
        instance = new AssignStaffOnCampaignUI();
        return instance;
    }

    private AssignStaffOnCampaignUI() {
        Utils.print("*** Client list ***");
        List<Client> clientList = Client.getClients();
        if(clientList.size() != 0) {
            for(int i=0; i< clientList.size(); i++) {
                Utils.print(String.valueOf(clientList.get(i).getId()) +" - "+ clientList.get(i).getCompanyName() +
                        " (Campaigns: " + clientList.get(i).getCampaigns().size() + ")");
            }

        } else {
            Utils.print("Not Found Any Company at List..!");
        }
        startInterface();
    }

    public void startInterface() {
        Utils.print("Please Select a Client =>",true);
        int clientId = ScanHelper.scanInt();

        boolean isShowCampaign = selectClient(clientId);

        if(isShowCampaign) {
            Utils.print("Please Select a Campaign =>", true);
            int campaignNo = ScanHelper.scanInt();
            campaignNo--;
            boolean isShowStaff = selectCampaign(campaignNo, clientId);

            if(isShowStaff) {
                Utils.print("Please Select a Staff =>", true);
                int staffNo = ScanHelper.scanInt();

                selectCreativeStaff(staffNo, campaignNo, clientId);
            }

        }


    }

    public boolean selectClient(int clientId) {
        return AssignStaffOnCampaign.getInstance().showClientCampaigns(clientId);
    }

    public boolean selectCampaign(int campaignNo, int clientId) {
        return AssignStaffOnCampaign.getInstance().showCampaignNotWorkStaff(campaignNo, clientId);
    }

    public void selectCreativeStaff(int staffNo, int campaignNo, int cliendId) {
        AssignStaffOnCampaign.getInstance().selectCreativeStaff(staffNo, campaignNo, cliendId);
    }
}
