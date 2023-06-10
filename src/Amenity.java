/*
Name: Ali Zaid Hamidaddin
ID: 2137162
Section: F2
Assignment: 2
 */
public class Amenity extends Service {

    private String Amenity_type;
    private String Restriction;

    public Amenity(String ServiceID, String ServiceName, String Amenity_type,
            String Location, String Restriction, double Price) {
        super(ServiceID, ServiceName, Location, Price);
        this.Amenity_type = Amenity_type;
        this.Restriction = Restriction;
    }

    public String getAmenity_type() {
        return Amenity_type;
    }

    public void setAmenity_type(String Amenity_type) {
        this.Amenity_type = Amenity_type;
    }

    public String getRestriction() {
        return Restriction;
    }

    public void setRestriction(String Restriction) {
        this.Restriction = Restriction;
    }

    @Override
    public String toString() {
        return "Command Add_Amenity was successfully completed\n"
                + "Amenity{ServiceID=" + super.getServiceID() + ", ServiceName=" + super.getServiceName()
                + ", Location=" + super.getLocation() + ", Price=" + super.getPrice()
                + ", Amenity_type=" + Amenity_type + ", Restriction=" + Restriction + "}\n"
                + "----------------------------------------------------------------";
    }

    @Override
    public int compareTo(Service o) {
//        return o.getServiceName().compareTo(this.getServiceName());
        return this.getServiceName().compareTo(o.getServiceName());
    }

}
