package Agate.UI;

import Agate.control.AddNewCampaign;
import Agate.domain.Campaign;
import Agate.domain.Client;
import Agate.help.Database;
import Agate.help.ScanHelper;
import Agate.help.Utils;

import java.util.List;

public class AddNewCampaignUI {



    private static AddNewCampaignUI instance;

    public static AddNewCampaignUI getInstance() {
        instance = new AddNewCampaignUI();
        return instance;
    }
    private AddNewCampaignUI() {
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
        int id = ScanHelper.scanInt();
        selectClient(id);
        Campaign campaign = createNewCampaign();

        for(int i=0; i < Database.clientList.size();i++) {
            if(id == Database.clientList.get(i).getId()) {
                Database.clientList.get(i).addNewCampaign(campaign);
                Utils.print("Successfuly! This campaign added in client.");
            }
        }


    }

    public void selectClient(int id) {

        AddNewCampaign.getInstance().showClientCampaigns(id);
    }

    public Campaign createNewCampaign() {
        return AddNewCampaign.getInstance().createNewCampaign();
    }

}
