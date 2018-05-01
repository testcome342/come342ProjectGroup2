package Agate.control;

import Agate.domain.StaffMember;

public class AddNewMemberStaff {



    private static AddNewMemberStaff instance = new AddNewMemberStaff();

    public static AddNewMemberStaff getInstance() {

        return instance;
    }

    private AddNewMemberStaff() {

    }

    public void addStaff(StaffMember staffMember) {
        StaffMember.addStaff(staffMember);
    }

}
