package Agate.domain;

import Agate.help.ScanHelper;
import Agate.help.Utils;

import java.util.ArrayList;
import java.util.List;

public class Campaign {

    private String title;
    private double estimatedCost;
    private String finishDate;
    private String startDate;
    private List<StaffMember> staffMemberList;

    public  Campaign() {}
    //Default Constructor

    public static Campaign createCampaign() {

        String title, finishDate, startDate;
        Double estimatedCost;

        Utils.print("Campaign Title= ", true);
        title = ScanHelper.scanString();

        Utils.print("Campaign Start Date= ", true);
        startDate = ScanHelper.scanString();

        Utils.print("Campaign Finish Date= ", true);
        finishDate = ScanHelper.scanString();

        Utils.print("Campaign Estimated Cost= ", true);
        estimatedCost = ScanHelper.scanDouble();

        Campaign campaign = new Campaign(title, startDate, finishDate, estimatedCost);

        return campaign;

    }

    public Campaign(String title, String startDate, String finishDate, double estimatedCost) {
        super();
        this.title = title;
        this.estimatedCost = estimatedCost;
        this.finishDate = finishDate;
        this.startDate = startDate;
        this.staffMemberList = new ArrayList<StaffMember>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(double estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public List<StaffMember> getCreativeStaffList() {
        return staffMemberList;
    }

    public void setCreativeStaffList(List<StaffMember> staffMemberList) {
        this.staffMemberList = staffMemberList;
    }

    public void assignStaff(StaffMember staffMember) {
        this.staffMemberList.add(staffMember);
    }

}