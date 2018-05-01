package Agate.control;

import Agate.domain.Campaign;
import Agate.domain.Client;

public class AddNewClient {



    private static AddNewClient instance = new AddNewClient();

    public static AddNewClient getInstance() {

        return instance;
    }

    private AddNewClient() {

    }

    public int createNewClient(Client client) {
        return Client.createClient(client);
    }

    public Campaign createNewCampaign() {

        return Campaign.createCampaign();
    }

}