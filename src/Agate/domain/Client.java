package Agate.domain;

import java.util.ArrayList;
import java.util.List;

import Agate.help.Database;

public class Client {


    private int id;
    private String companyName;
    private String companyAddress;
    private String companyEmail;
    private String contactName;
    private String contactEmail;
    private List<Campaign> campaigns;


    public Client()
    {
        super();
    }

    public Client(int id, String companyName, String companyEmail, String companyAddress, String contactName, String contactEmail) {
        super();
        this.id = id;
        this.companyName=companyName;
        this.companyEmail=companyEmail;
        this.companyAddress=companyAddress;
        this.contactName=contactName;
        this.contactEmail=contactEmail;
        this.campaigns = new ArrayList<Campaign>();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getCompanyEmail() {
        return companyEmail;
    }
    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }
    public String getContactName() {
        return contactName;
    }
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    public String getContactEmail() {
        return contactEmail;
    }
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
    public String getCompanyAddress() {
        return companyAddress;
    }
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public static List<Client> getClients()
    {
        return Database.clientList;
    }

    public static int createClient(Client client) {
        Database.clientList.add(client);
        return client.getId();
    }

    public void addNewCampaign(Campaign campaign)
    {
        this.campaigns.add(campaign);
    }

    public List<Campaign> getCampaigns()
    {
        return campaigns;
    }

    public void setCampaigns(List<Campaign> campaigns)
    {
        this.campaigns=campaigns;
    }


}