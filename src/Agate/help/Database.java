package Agate.help;

import Agate.domain.*;
import Agate.domain.StaffMember;

import java.util.ArrayList;
import java.util.List;

public class Database {

    public static List<Client> clientList = new ArrayList<Client>();
    public static List<Agate.domain.StaffMember> staffMemberList = new ArrayList<StaffMember>();

    public static void init() {

        CreativeStaff ahmet = new CreativeStaff(2,"Ahmet Dursun", "20.05.2017", "ahmet@gmail.com");
        CreativeStaff mehmet = new CreativeStaff(3,"Mehmet Dursun", "20.05.2017", "ahmet@gmail.com");
        CreativeStaff sami = new CreativeStaff(4,"Sami Dursun", "20.05.2017", "ahmet@gmail.com");
        CreativeStaff ugur = new CreativeStaff(5,"Ugur Dursun", "20.05.2017", "ahmet@gmail.com");
        AdminStaff hamdi = new AdminStaff(6,"Hamdi Dursun", "20.05.2017", "ahmet@gmail.com");

        staffMemberList.add(ahmet);
        staffMemberList.add(mehmet);
        staffMemberList.add(sami);
        staffMemberList.add(ugur);
        staffMemberList.add(hamdi);




        Client eti = new Client(1,"ETI", "Mecidiyekoy/SISLI", "eti@eti.com.tr", "Ahmet Bey", "ahmet@eti.com.tr");
        Campaign eti_50inci_yil = new Campaign("ETI 50. YIL", "14.04.2018", "24.05.2018", 550000.0);
        eti_50inci_yil.assignStaff(ugur);
        eti.addNewCampaign(eti_50inci_yil);

        clientList.add(eti);

    }

}