package Agate.UI;

import Agate.control.AddNewMemberStaff;
import Agate.domain.AdminStaff;
import Agate.domain.CreativeStaff;
import Agate.domain.StaffMember;
import Agate.help.ScanHelper;
import Agate.help.Utils;

import java.util.List;

public class AddNewMemberStaffUI {


    private static AddNewMemberStaffUI instance;

    public static AddNewMemberStaffUI getInstance() {
        instance = new AddNewMemberStaffUI();
        return instance;
    }

    private AddNewMemberStaffUI() {
        Utils.print("*** Staff list ***");
        List<StaffMember> staffMemberList = StaffMember.getStaffMembers();
        if(staffMemberList.size() != 0) {
            for(int i=0; i< staffMemberList.size(); i++) {
                Utils.print(String.valueOf(staffMemberList.get(i).getStaffNo()) + " " +staffMemberList.get(i).getStaffName());
            }

        } else {
            Utils.print("Not Found Any Staff at List..!");
        }
        startInterface();
    }

    public void startInterface() {
        Utils.printLine(40);
        Utils.print("Staff No: ", true);
        int staffNo = ScanHelper.scanInt();
        Utils.print("Staff Name: ", true);
        String staffName = ScanHelper.scanString();
        Utils.print("Staff Email: ", true);
        String staffEmail = ScanHelper.scanString();
        Utils.print("Staff Start Date: ", true);
        String staffStartDate = ScanHelper.scanString();

        Utils.printLine(40);
        Utils.print("1- CreativeStaff");
        Utils.print("2- AdminStaff");
        Utils.printLine(40);
        Utils.print("Please Select CreativeStaff or AdminStaff =>",true);
        int choice;
        choice = ScanHelper.scanInt();

        while(true) {
            if(choice == 1) {
                //CreativeStaff
                CreativeStaff creativeStaff = new CreativeStaff(staffNo, staffName, staffStartDate, staffEmail);

                createStaff(creativeStaff);
                Utils.print("Succesfully! Staff added in list.");
                break;
            } else if(choice == 2) {
                //AdminStaff
                AdminStaff adminStaff = new AdminStaff(staffNo, staffName, staffStartDate, staffEmail);

                createStaff(adminStaff);
                Utils.print("Succesfully! Staff added in list.");
                break;
            } else {
                Utils.print("Error!Try enter a number");
                Utils.print("Please Select CreativeStaff or AdminStaff =>",true);
                choice = ScanHelper.scanInt();
            }
        }

    }

    public void createStaff(StaffMember staffMember) {
        AddNewMemberStaff.getInstance().addStaff(staffMember);
    }
}