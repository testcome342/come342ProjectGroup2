package Agate.control;

import Agate.domain.Campaign;
import Agate.domain.Client;
import Agate.help.Utils;



public class AddNewCampaign {

    private static AddNewCampaign instance = new AddNewCampaign ();
    public static AddNewCampaign getInstance() {
        return instance;
    }

    private AddNewCampaign() {

    }
    public Campaign createNewCampaign() {
        return Campaign.createCampaign();

    }

    public void showClientCampaigns(int id) {
        Client client;

        for(int i=0; i<Client.getClients().size();i++) {
            if(id == Client.getClients().get(i).getId()) {
                client = Client.getClients().get(i);

                if(client.getCampaigns().size() == 0) {
                    Utils.print("This client don't have campaign(s)");
                } else {

                    for(int j = 0;j<client.getCampaigns().size();j++) {
                        int num = j + 1;
                        Utils.print(String.valueOf(num) + " " +client.getCampaigns().get(j).getTitle());
                    }

                }
            }
        }

    }
}