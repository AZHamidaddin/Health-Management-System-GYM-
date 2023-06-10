/*
Name: Ali Zaid Hamidaddin
ID: 2137162
Section: F2
Assignment: 2
 */
import java.util.Date;

public abstract class Member {

    private String ID;
    private String Name;
    private char Gender;
    private Date DateOfBirth;
    private Date DateOfRegistration;
    private String Address;
    private String Phone;

    public Member(String ID, String Name, char Gender, Date DateOfBirth, Date DateOfRegistration, String Address, String Phone) {
        this.ID = ID;
        this.Name = Name;
        this.Gender = Gender;
        this.DateOfBirth = DateOfBirth;
        DateTostring(DateOfBirth);
        this.DateOfRegistration = DateOfRegistration;
        this.Address = Address;
        this.Phone = Phone;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public char getGender() {
        return Gender;
    }

    public void setGender(char Gender) {
        this.Gender = Gender;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public Date getDateOfRegistration() {
        return DateOfRegistration;
    }

    public void setDateOfRegistration(Date DateOfRegistration) {
        this.DateOfRegistration = DateOfRegistration;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    @Override
    public String toString() {
        return "Member";
    }

    public static String DateTostring(Date date) {
        StringBuilder str = new StringBuilder(date.toString());
        str.delete(0, 4);
        str.delete(7, 20);
        String[] values = (str.toString()).split(" ");
        String Month = null;
        
        switch(values[0]){
            case "Jan": Month = "01";break;
            case "Feb":Month = "02";break;
            case "Mar":Month = "03";break;
            case "Apr":Month = "04";break;
            case "May":Month = "05";break;
            case "Jun":Month = "06";break;
            case "Jul":Month = "07";break;
            case "Aug":Month = "08";break;
            case "Sep":Month = "09";break;
            case "Oct": Month = "10";break;   
            case "Nov":Month = "11";break;
            case "Dec": Month = "12";break;   
        }
        
        
        return values[1]+"/"+Month+"/"+values[2];
    }

}
