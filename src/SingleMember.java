/*
Name: Ali Zaid Hamidaddin
ID: 2137162
Section: F2
Assignment: 2
 */
import java.util.Date;

public class SingleMember extends Member {

    private String MembershipType;

    public SingleMember(String ID, String Name, char Gender, Date DateOfBirth, Date DateOfRegistration, String Address, String Phone, String MembershipType) {
        super(ID, Name, Gender, DateOfBirth, DateOfRegistration, Address, Phone);
        this.MembershipType = MembershipType;
    }

    public String getMembershipType() {
        return MembershipType;
    }

    public void setMembershipType(String MembershipType) {
        this.MembershipType = MembershipType;
    }

    @Override
    public String toString() {
//      as the output file keeps changing i've added both cases, With Command Add Single Members, and without
        return "Command Add_Single_Member was successfully completed\n"
                + "SingleMembers info {ID=" + super.getID() + ", Name=" + super.getName()
                + ", Gender=" + super.getGender() + ", DateOfBirth=" + Member.DateTostring(super.getDateOfBirth())
                + ", DateOfRegestration=" + Member.DateTostring(super.getDateOfRegistration()) + ", Address=" + super.getAddress()
                + ", Phone=" + super.getPhone() + ", MembershipType=" + MembershipType + "}\n"
                + "----------------------------------------------------------------";
//        return 
//                 "SingleMembers info {ID=" + super.getID() + ", Name=" + super.getName()
//                + ", Gender=" + super.getGender() + ", DateOfBirth=" + Member.DateTostring(super.getDateOfBirth())
//                + ", DateOfRegestration=" + Member.DateTostring(super.getDateOfRegistration()) + ", Address=" + super.getAddress()
//                + ", Phone=" + super.getPhone() + ", MembershipType=" + MembershipType + "}\n"
//                + "----------------------------------------------------------------";
    }

}
