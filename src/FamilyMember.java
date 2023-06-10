/*
Name: Ali Zaid Hamidaddin
ID: 2137162
Section: F2
Assignment: 2
 */
import java.util.ArrayList;
import java.util.Date;

public class FamilyMember extends Member {

    private ArrayList<String> Family_members_names;

    public FamilyMember(String ID, String Name, char Gender, Date DateOfBirth, Date DateOfRegistration, String Address, String Phone, ArrayList<String> Family_members_names) {
        super(ID, Name, Gender, DateOfBirth, DateOfRegistration, Address, Phone);
        this.Family_members_names = Family_members_names;
    }

    public ArrayList<String> getFamily_members_names() {
        return Family_members_names;
    }

    public void setFamily_members_names(ArrayList<String> Family_members_names) {
        this.Family_members_names = Family_members_names;
        String strNames = this.Family_members_names.get(0);
        String[] names = strNames.split("/");
        this.Family_members_names.remove(0);
        for (int i = 0; i < names.length; i++) {
            this.Family_members_names.add(names[i]);
        }
    }

    @Override
    public String toString() {
        return "Command Add_Family_Member was successfully completed\n"
                + "FamilyMembers{ID=" + super.getID() + ", Name=" + super.getName()
                + ", Gender=" + super.getGender() + ", DateOfBirth=" + Member.DateTostring(super.getDateOfBirth())
                + ", DateOfRegestration=" + Member.DateTostring(super.getDateOfRegistration()) + ", Address=" + super.getAddress()
                + ", Phone=" + super.getPhone() + ", Family_members_names=" + Family_members_names.toString() + "}\n"
                + "----------------------------------------------------------------";
    }

}
