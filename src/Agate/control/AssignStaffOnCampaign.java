package Agate.control;

import Agate.domain.Campaign;
import Agate.domain.Client;
import Agate.domain.StaffMember;
import Agate.help.Utils;

import java.util.ArrayList;
import java.util.List;


public class AssignStaffOnCampaign {



    private static AssignStaffOnCampaign instance = new AssignStaffOnCampaign();

    public static AssignStaffOnCampaign getInstance() {

        return instance;
    }

    private AssignStaffOnCampaign() {

    }

    public boolean showClientCampaigns(int id) {
        Client client;

        for(int i=0; i<Client.getClients().size();i++) {
            if(id == Client.getClients().get(i).getId()) {
                client = Client.getClients().get(i);

                if(client.getCampaigns().size() == 0) {
                    Utils.print("This client don't have campaign(s)");
                    return false;
                } else {

                    for(int j = 0;j<client.getCampaigns().size();j++) {
                        int num = j + 1;
                        Utils.print(String.valueOf(num) + ") " +client.getCampaigns().get(j).getTitle());
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public boolean showCampaignNotWorkStaff(int campaignNo, int clientId) {
        Client client;
        Campaign campaign;

        for(int i=0; i<Client.getClients().size();i++) {
            if(clientId == Client.getClients().get(i).getId()) {
                client = Client.getClients().get(i);
                campaign = client.getCampaigns().get(campaignNo);

                List<StaffMember> staffMemberList = new ArrayList<StaffMember>(StaffMember.getStaffMembers());

                staffMemberList.removeAll(campaign.getCreativeStaffList());

                if(staffMemberList.size() == 0) {
                    Utils.print("This client don't have campaign(s)");
                    return false;
                } else {

                    for(int j=0; j < staffMemberList.size();j++) {
                        Utils.print(String.valueOf(staffMemberList.get(j).getStaffNo())+ " - " +staffMemberList.get(j).getStaffName());
                    }

                    return true;
                }

            }
        }
        return false;
    }

    public void selectCreativeStaff(int staffNo, int campaignNo, int clientId) {
        Client client;
        Campaign campaign;

        for(int i=0;i<Client.getClients().size();i++) {
            if(clientId == Client.getClients().get(i).getId()) {
                client = Client.getClients().get(i);
                campaign = client.getCampaigns().get(campaignNo);

                for(int j=0;j<StaffMember.getStaffMembers().size();j++) {
                    if(staffNo == StaffMember.getStaffMembers().get(j).getStaffNo()) {
                        campaign.assignStaff(StaffMember.getStaffMembers().get(j));
                    }
                }

            }
        }
    }
}
