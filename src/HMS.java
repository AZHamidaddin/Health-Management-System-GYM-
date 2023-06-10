/*
Name: Ali Zaid Hamidaddin
ID: 2137162
Section: F2
Assignment: 2
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;

public class HMS {

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        //Please use calibri font in the output file for proper formatting

        //create file and scanner objects
        File input = new File("input.txt");
        Scanner read_input = new Scanner(input);

        //check if file exists
        if (!input.exists()) {
            System.exit(0);
        }

        //output file and PrintWriter
        File output = new File("output.txt");
        PrintWriter out = new PrintWriter(output);

        //create arraylists for member and service classes and registration
        ArrayList<Member> members = new ArrayList();
        ArrayList<Service> services = new ArrayList();
        ArrayList<Registration> register = new ArrayList();

        //unique ID
        Integer singleID = new Integer(1000);
        Integer familyID = new Integer(2000);
        Integer classID = new Integer(5000);
        Integer amenityID = new Integer(6000);
        Integer code = new Integer(1);

        out.println("--------------- Welcome to Gym Mangment System ---------------");

        //loop for reading the input file
        while (read_input.hasNext()) {
            String command = read_input.next();

            //check if command is quit else continue
            if (command.equals("Quit")) {
                break;
            }

            //check which command is invoked
            switch (command) {
                
                //create object of single member and save to arraylist
                case "Add_Single_Member":
                    singleID++;
                    Member s = new SingleMember(singleID.toString(),
                            read_input.next(), read_input.next().charAt(0),
                            new SimpleDateFormat("dd/MM/yyyy").parse(read_input.next()),
                            new SimpleDateFormat("dd/MM/yyyy").parse(read_input.next()),
                            read_input.next(), read_input.next(), read_input.next());
                    members.add(s);

                    out.println(s.toString());
                    break;

                //create object of family member and save it to arraylist
                case "Add_Family_Member":
                    familyID++;
                    ArrayList<String> family_members = new ArrayList();
                    Member f = new FamilyMember(familyID.toString(), read_input.next(),
                            read_input.next().charAt(0),
                            new SimpleDateFormat("dd/MM/yyyy").parse(read_input.next()),
                            new SimpleDateFormat("dd/MM/yyyy").parse(read_input.next()),
                            read_input.next(), read_input.next(), family_members);
                    family_members.add(read_input.next());
                    ((FamilyMember) f).setFamily_members_names(family_members);
                    members.add(f);
                    out.println(f.toString());
                    break;

                //create object of class and save to arraylist
                case "Add_Class":
                    classID++;
                    Service c = new Class(classID.toString(), read_input.next(),
                            read_input.next(), read_input.nextDouble(), read_input.nextInt(),
                             read_input.next());
                    services.add(c);
                    out.println(c.toString());
                    break;

                //create object of amenity and save it to arraylist
                case "Add_Amenity":
                    amenityID++;
                    Service a = new Amenity(amenityID.toString(), read_input.next(),
                            read_input.next(), read_input.next(), read_input.next(),
                            read_input.nextDouble());
                    services.add(a);
                    out.println(a.toString());
                    break;
                
                //all comands are straight-forward except for "Register"    
                case "Register":
                    //first i need to declare/initalize a few vars that i will need
                    ArrayList<Service> service = new ArrayList();
                    String ID = read_input.next();
                    
                   // ArrayList<String> compare = new ArrayList();
                    Member S = null;
                    Member F = null;
                    Registration r = null;
                    //check the given ID with member's ID to know what type of member they are and if they exist
                    if (ID.matches("1...")) {
                        for (int i = 0; i < members.size(); i++) {
                            if (((members.get(i)).getID()).equals(ID)) {
                                S = members.get(i);
                               // for (int j = 0; j < compare.size(); j++) {
                                //    if (ID.matches(compare.get(j))) {
                                      //  code++;

                                 //   }
                            //    }
                               // compare.add(ID);
                            }

                        }
                        r = new Registration(ID + "0" + code.toString(), S, service);
                    } else if (ID.matches("2...")) {
                        for (int i = 0; i < members.size(); i++) {
                            if (((members.get(i)).getID()).equals(ID)) {
                                F = members.get(i);
                             //   for (int j = 0; j < compare.size(); j++) {
                               //     if (ID.matches(compare.get(j))) {
                               //         code++;

                                //    }
                              //  }
                             //   compare.add(ID);
                            }

                        }
                        r = new Registration(ID + "0" + code.toString(), F, service);
                    }
                    if (!(r.getMember() == null)) {
                        code++;
                    }
                    //read the classes/amenities
                    String next = read_input.next();

                    //loop to read registered classes
                    while (!next.equals("submit")) {
                        if ((next.equals("In")) || (next.equals("And"))) {
                            String ser = read_input.next();
                            if (r.getMember() == null) {
                                break;
                            }
                            //if member is male
                            if (r.getMember().getGender() == 'M') {

                                for (int i = 0; i < services.size(); i++) {
                                    if (ser.equalsIgnoreCase(services.get(i).getServiceName())
                                            && services.get(i).getLocation().equalsIgnoreCase("Male-branch")) {

                                        if (services.get(i) instanceof Amenity) {
                                            Service test = new Amenity(services.get(i).getServiceID(), services.get(i).getServiceName(),
                                                    (((Amenity) services.get(i)).getAmenity_type()), services.get(i).getLocation(),
                                                    (((Amenity) services.get(i)).getRestriction()), services.get(i).getPrice());
                                            service.add(test);
                                            ser = "";
                                            break;
                                        } else {
                                            Service test2 = new Class(services.get(i).getServiceID(), services.get(i).getServiceName(),
                                                    services.get(i).getLocation(), services.get(i).getPrice(),
                                                    (((Class) services.get(i)).getCapacity()), (((Class) services.get(i)).getInstructor()));
                                            service.add(test2);
                                            ser = "";
                                            break;
                                        }
                                    }

                                }
                                // if service is not founf in branch check all branches
                                if (!(ser.equals(""))) {
                                    for (int i = 0; i < services.size(); i++) {
                                        if (ser.equalsIgnoreCase(services.get(i).getServiceName())) {

                                            if (services.get(i) instanceof Amenity) {
                                                Service test = new Amenity(services.get(i).getServiceID(), services.get(i).getServiceName(),
                                                        (((Amenity) services.get(i)).getAmenity_type()), null,
                                                        (((Amenity) services.get(i)).getRestriction()), services.get(i).getPrice());
                                                service.add(test);
                                                break;
                                            } else {
                                                Service test2 = new Class(services.get(i).getServiceID(), services.get(i).getServiceName(),
                                                        null, services.get(i).getPrice(),
                                                        (((Class) services.get(i)).getCapacity()), (((Class) services.get(i)).getInstructor()));
                                                service.add(test2);
                                                break;
                                            }
                                        }

                                    }
                                }
                                
                            } 
                            //member is female, same steps as male
                            else {
                                for (int i = 0; i < services.size(); i++) {
                                    if (ser.equalsIgnoreCase(services.get(i).getServiceName())
                                            && services.get(i).getLocation().equalsIgnoreCase("Female-branch")) {

                                        if (services.get(i) instanceof Amenity) {
                                            Service test = new Amenity(services.get(i).getServiceID(), services.get(i).getServiceName(),
                                                    (((Amenity) services.get(i)).getAmenity_type()), services.get(i).getLocation(),
                                                    (((Amenity) services.get(i)).getRestriction()), services.get(i).getPrice());
                                            service.add(test);
                                            ser = "";
                                            break;
                                        } else {
                                            Service test2 = new Class(services.get(i).getServiceID(), services.get(i).getServiceName(),
                                                    services.get(i).getLocation(), services.get(i).getPrice(),
                                                    (((Class) services.get(i)).getCapacity()), (((Class) services.get(i)).getInstructor()));
                                            service.add(test2);
                                            ser = "";
                                            break;
                                        }
                                    }
                                }

                                if (!(ser.equals(""))) {
                                    for (int i = 0; i < services.size(); i++) {
                                        if (ser.equalsIgnoreCase(services.get(i).getServiceName())) {

                                            if (services.get(i) instanceof Amenity) {
                                                Service test = new Amenity(services.get(i).getServiceID(), services.get(i).getServiceName(),
                                                        (((Amenity) services.get(i)).getAmenity_type()), null,
                                                        (((Amenity) services.get(i)).getRestriction()), services.get(i).getPrice());
                                                service.add(test);
                                                break;
                                            } else {
                                                Service test2 = new Class(services.get(i).getServiceID(), services.get(i).getServiceName(),
                                                        null, services.get(i).getPrice(),
                                                        (((Class) services.get(i)).getCapacity()), (((Class) services.get(i)).getInstructor()));
                                                service.add(test2);
                                                break;
                                            }
                                        }

                                    }
                                }

                            }
                        }
                        next = read_input.next();
                    }
                    //add all the objects info to an arraylist
                    r.setService(service);
                    register.add(r);
                    //invoke method to print receipts
                    PrintReceipt(r, out);
                    break;

                //command to print out all the classes into a menu ordered by price
                case "Print_Sort_Classes":
                    ArrayList<Class> classList = new ArrayList();
                    for (int i = 0; i < services.size(); i++) {
                        if (services.get(i) instanceof Class) {
                            classList.add((Class) services.get(i));
                        }
                    }
                    //invoke sort method using overridden compareTo method, check classes "Class" and "Amenity" to check implementation
                    Collections.sort(classList);
                    out.println("--------------------------------------------------- Classes Sorted By Price ----------------------------------------------------");
                    out.println("Class name\t\tLocation\t\t\tInstructor\t\tPrice");
                    out.println("----------------------------------------------------------------------------------------------------------------------------------------");
                    for (int i = 0; i < classList.size(); i++) {
                        //these selection statements are for formatting
                        if (classList.get(i).getServiceName().length() > 7 && classList.get(i).getInstructor().length() > 18) {
                            out.println(classList.get(i).getServiceName() + "\t\t" + classList.get(i).getLocation() + "\t\t" + classList.get(i).getInstructor() + "\t" + classList.get(i).getPrice());
                        } else if (classList.get(i).getServiceName().length() > 7) {
                            out.println(classList.get(i).getServiceName() + "\t\t" + classList.get(i).getLocation() + "\t\t" + classList.get(i).getInstructor() + "\t\t" + classList.get(i).getPrice());
                        } else if (classList.get(i).getInstructor().length() > 18) {
                            out.println(classList.get(i).getServiceName() + "\t\t\t" + classList.get(i).getLocation() + "\t\t" + classList.get(i).getInstructor() + "\t" + classList.get(i).getPrice());
                        } else if (classList.get(i).getInstructor().contains("Mohamed") && classList.get(i).getInstructor().length() >= 15) {
                            out.println(classList.get(i).getServiceName() + "\t\t\t" + classList.get(i).getLocation() + "\t\t" + classList.get(i).getInstructor() + "\t" + classList.get(i).getPrice());
                        } else {
                            out.println(classList.get(i).getServiceName() + "\t\t\t" + classList.get(i).getLocation() + "\t\t" + classList.get(i).getInstructor() + "\t\t" + classList.get(i).getPrice());
                        }
                    }
                    out.println("----------------------------------------------------------------------------------------------------------------------------------------\n");
                    break;

                //command to print out all the amenities into a menu ordered by name
                case "Print_Sort_Amenities":
                    ArrayList<Amenity> amenityList = new ArrayList();
                    for (int i = 0; i < services.size(); i++) {
                        if (services.get(i) instanceof Amenity) {
                            amenityList.add((Amenity) services.get(i));
                        }
                    }
                    //invoke sort method using overridden compareTo method, check classes "Class" and "Amenity" to check implementation
                    Collections.sort(amenityList);
                    out.println("------------------------------------------------ Amenities Sorted By Name -------------------------------------------------");
                    out.println("Amenity name\t\tLocation\t\t\tRestriction\t\tPrice");
                    out.println("----------------------------------------------------------------------------------------------------------------------------------------");
                    for (int i = 0; i < amenityList.size(); i++) {
                        //these selection statements are for formatting
                        if (amenityList.get(i).getServiceName().length() > 8 && amenityList.get(i).getRestriction().length() > 12) {
                            out.println(amenityList.get(i).getServiceName() + "\t\t" + amenityList.get(i).getLocation() + "\t\t" + amenityList.get(i).getRestriction() + "\t\t" + amenityList.get(i).getPrice());
                        } else if (amenityList.get(i).getServiceName().length() > 8) {
                            out.println(amenityList.get(i).getServiceName() + "\t\t" + amenityList.get(i).getLocation() + "\t\t" + amenityList.get(i).getRestriction() + "\t\t\t" + amenityList.get(i).getPrice());
                        } else if (amenityList.get(i).getRestriction().length() > 12) {
                            out.println(amenityList.get(i).getServiceName() + "\t\t\t" + amenityList.get(i).getLocation() + "\t\t" + amenityList.get(i).getRestriction() + "\t\t" + amenityList.get(i).getPrice());
                        } else {
                            out.println(amenityList.get(i).getServiceName() + "\t\t\t" + amenityList.get(i).getLocation() + "\t\t" + amenityList.get(i).getRestriction() + "\t\t\t" + amenityList.get(i).getPrice());
                        }
                    }
                    out.println("----------------------------------------------------------------------------------------------------------------------------------------\n");
                    break;

            }

        }
        out.println("Thank you for using Gym Management System, Good Bye!");
        out.flush();
        out.close();
        //end of the main method

    }
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------    

    public static void PrintReceipt(Registration reg, PrintWriter fWrite) throws ParseException {
        //check if member exists
        if (reg.getMember() == null) {
            fWrite.println("The member does not exist in the system\n\n");
        } else {
            //get age and check retrictions
            int age = reg.getMember().getDateOfBirth().compareTo(new SimpleDateFormat("dd/MM/yyyy").parse("1/11/2004"));
            if (age > 0) {
                for (int i = 0; i < reg.getService().size(); i++) {
                    if (reg.getService().get(i) instanceof Amenity) {

                        if (((Amenity) reg.getService().get(i)).getRestriction().equalsIgnoreCase("above-18")) {
                            fWrite.println("The requested service " + reg.getService().get(i).getServiceName()
                                    + " is not allowed for members below 18 years");
                            reg.getService().remove(i);
                        }

                    }
                }
            }
            //check if single members can use the service
            for (int i = 0; i < reg.getService().size(); i++) {
                if ((reg.getMember() instanceof SingleMember) && (reg.getService().get(i) instanceof Amenity)) {
                    if (((Amenity) reg.getService().get(i)).getRestriction().equalsIgnoreCase("have-children")) {

                        fWrite.println("The requested service " + reg.getService().get(i).getServiceName() + " is not allowed for Single members");
                        reg.getService().remove(i);
                    }
                }
            }

            //check service availability in member's location
            for (int i = 0; i < reg.getService().size(); i++) {
                if (reg.getService().get(i).getLocation() == null) {
                    fWrite.println("The requested service " + reg.getService().get(i).getServiceName() + " cannot be found in the member location");
                    reg.getService().remove(i);
                }
            }
            
            //check if any services are still available, else exit method
            if (reg.getService().isEmpty()) {
                fWrite.println("The registration request was not successfully completed");
            } 
            
            //print out receipt
            else {
                fWrite.println("------------------------------------- Invoice Details ---------------------------------------");
                fWrite.println("Registration Reference Number:" + reg.getRegistrationID());
                fWrite.println("Member ID:" + reg.getMember().getID() + "\nMember name:" + reg.getMember().getName());

                fWrite.println("--------------------------------------------------------------------------------------------------");

                fWrite.println("Service\t\tOriginal_Price\tDiscount\t\tFinal_price");
                //create vars to save values
                double discount = 0;
                double Final_Price = 0;
                double total_Final_Price = 0;
                double original_total_price = 0;
                for (int i = 0; i < reg.getService().size(); i++) {
                    discount = (reg.getDiscount()) * 100;
                    Final_Price = reg.getService().get(i).getPrice() - (reg.getService().get(i).getPrice() * (discount / 100));
                    total_Final_Price += Final_Price;
                    original_total_price += reg.getService().get(i).getPrice();
                    if (reg.getService().get(i).getServiceName().length() > 7) {
                        fWrite.println(reg.getService().get(i).getServiceName() + "\t" + reg.getService().get(i).getPrice()
                                + "0\t\t" + discount + "%\t\t" + Final_Price + "0");
                    } else {
                        fWrite.println(reg.getService().get(i).getServiceName() + "\t\t" + reg.getService().get(i).getPrice()
                                + "0\t\t" + discount + "%\t\t" + Final_Price + "0");
                    }
                }
                fWrite.println("--------------------------------------------------------------------------------------------------");

                //check how many items are discounted, if the price is zero it is not counted
                int dis_counter = reg.getNumberOfDiscountservice();
                for (int i = 0; i < reg.getService().size(); i++) {
                    if (reg.getService().get(i).getPrice() == 0 && dis_counter > 0) {
                        dis_counter -= 1;
                    }
                }

                fWrite.println("Number of discounted items: " + dis_counter);
                fWrite.println("- Original Total Price: " + original_total_price + "0");
                fWrite.println("- Final Price: " + total_Final_Price + "0");
                fWrite.println("- Saving Amount: " + (original_total_price - total_Final_Price) + "0");

                fWrite.println("--------------------------------------------------------------------------------------------------\n\n");
            }

        }
        //end of the printReceipt method
    }

}
