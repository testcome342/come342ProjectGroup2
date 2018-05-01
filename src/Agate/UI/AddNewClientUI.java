package Agate.UI;

import Agate.control.AddNewClient;
import Agate.domain.Campaign;
import Agate.domain.Client;
import Agate.help.Database;
import Agate.help.ScanHelper;
import Agate.help.Utils;

import java.util.List;

public class AddNewClientUI {



    private static AddNewClientUI instance;

    public static AddNewClientUI getInstance() {
        instance = new AddNewClientUI();
        return instance;
    }

    private AddNewClientUI() {
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
        String companyName, companyAddress, companyEmail, contactName, contactEmail;
        int companyNo;

        Utils.print("Company No= ", true);
        companyNo = ScanHelper.scanInt();

        Utils.print("Company Name= ", true);
        companyName = ScanHelper.scanString();

        Utils.print("Company Address= ", true);
        companyAddress = ScanHelper.scanString();

        Utils.print("Company Email= ", true);
        companyEmail = ScanHelper.scanString();

        Utils.print("Contact Name= ", true);
        contactName = ScanHelper.scanString();

        Utils.print("Contact Email= ", true);
        contactEmail = ScanHelper.scanString();

        Client newClient = new Client(companyNo, companyName, companyAddress, companyEmail, contactName, contactEmail);

        int id = createNewClient(newClient);

        if(id > 0) {
            Utils.print(" -> Succesfull!! New Client is added");

            Utils.print("Would you like to add a campaign ? (Yes/No)");

            while(true) {

                Utils.print("Answer=> ", true);
                String response = ScanHelper.scanString();

                if("YES".equals(response.toUpperCase())) {

                    for(int i=0; i< Database.clientList.size(); i++) {
                        if(id == Database.clientList.get(i).getId()) {
                            Database.clientList.get(i).addNewCampaign(createNewCampaign());
                        }
                    }
                    break;
                } else if("NO".equals(response.toUpperCase())){
                    break;
                } else {
                    Utils.print("Error! Try enter answer");
                }
            }

        } else {
            Utils.print(" -> Error!! New Client is not added");
        }

    }

    private int createNewClient(Client client) {

        int id = AddNewClient.getInstance().createNewClient(client);

        return id;
    }

    private Campaign createNewCampaign() {

        return AddNewClient.getInstance().createNewCampaign();
    }
}
