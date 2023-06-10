/*
Name: Ali Zaid Hamidaddin
ID: 2137162
Section: F2
Assignment: 2
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Registration {

    private String RegistrationID;
    private Member member;
    private ArrayList<Service> service;
    private double LoyalityDiscount;
    private double finaltotalPrice;

    public Registration(String RegistrationID, Member member, ArrayList<Service> service) {
        this.RegistrationID = RegistrationID;
        this.member = member;
        this.service = service;
    }

    @Override
    public String toString() {
        return "Registration";
    }

    public String getRegistrationID() {
        return RegistrationID;
    }

    public void setRegistrationID(String RegistrationID) {
        this.RegistrationID = RegistrationID;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public ArrayList<Service> getService() {
        return service;
    }

    public void setService(ArrayList<Service> service) {
        this.service = service;
    }

    public double getoriginalPrice() {
        double op = service.get(0).getPrice();
        //service.remove(0);
        return op;
    }

    public double LoyalityDiscount() throws ParseException {
        int registrationLength = member.getDateOfRegistration().compareTo(new SimpleDateFormat("dd/MM/yyyy").parse("8/11/2012"));
        if (registrationLength < 1) {
            return 0.1;
        } else {
            return 0;
        }
    }

    //checks which discount applies for member
    public double getDiscount() throws ParseException {
        double discount = 0;
        if (member instanceof SingleMember) {
            if (((SingleMember) member).getMembershipType().equalsIgnoreCase("VIP")) {
                return 0.5 + LoyalityDiscount();
            }
            else {
                return LoyalityDiscount();
            }

        } else {
            //the assignment pdf says more than three members but the output file implies 3 or more. I will comply with the pdf.
            if (((FamilyMember) member).getFamily_members_names().size() > 3) {
                discount = 0.05 + LoyalityDiscount();
            }
            else {
                return LoyalityDiscount();
            }
        }
        return discount;
    }

    public double getFinalPrice(Service s) throws ParseException {
        return getoriginalPrice() - (getoriginalPrice() * (LoyalityDiscount() + getDiscount()));
    }

    public double getTotalFinalPrice() throws ParseException {
        double final_price = 0;
        for (int i = 0; i < service.size(); i++) {
            final_price += getFinalPrice(service.get(i));
        }
        return final_price;
    }

    public int getNumberOfDiscountservice() throws ParseException {
        if (LoyalityDiscount() > 0 || getDiscount() > 0) {
            return service.size();
        }
        else {
            return 0;
        }

    }

    public double getSavingAmount() throws ParseException {
      //  double saved = 0;
        double total_original = 0;
        for (int i = 0; i < service.size(); i++) {
            total_original += getoriginalPrice();
        }
       // saved = total_original - getTotalFinalPrice();
        
        return total_original - getTotalFinalPrice();
    }
}
