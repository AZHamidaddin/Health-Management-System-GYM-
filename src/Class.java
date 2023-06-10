/*
Name: Ali Zaid Hamidaddin
ID: 2137162
Section: F2
Assignment: 2
 */
public class Class extends Service {

    private int capacity;
    private String Instructor;

    public Class(String ServiceID, String ServiceName, String Location, double Price, int capacity, String Instructor) {
        super(ServiceID, ServiceName, Location, Price);
        this.capacity = capacity;
        this.Instructor = Instructor;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getInstructor() {
        return Instructor;
    }

    public void setInstructor(String Instructor) {
        this.Instructor = Instructor;
    }

    @Override
    public String toString() {
        return "Command Add_Class was successfully completed\n"
                + "Class{ServiceID=" + super.getServiceID() + ", ServiceName=" + super.getServiceName()
                + ", Location=" + super.getLocation() + ", Price=" + super.getPrice()
                + ", capacity=" + capacity + ", Instructor=" + Instructor + "}\n"
                + "----------------------------------------------------------------";
    }

    @Override
    public int compareTo(Service o) {
        if (this.getPrice() > o.getPrice()) {
            return 1;
        } else if (this.getPrice() < o.getPrice()) {
            return -1;
        } else {
            return 0;
        }
//        double compareprice = ((Class)o).getPrice();
//        
//        return (int) (this.getPrice() - compareprice);

    }

}
