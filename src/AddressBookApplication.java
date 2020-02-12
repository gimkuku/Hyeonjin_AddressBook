import java.io.*;
import java.util.*;

public class AddressBookApplication {
	
	/*
	void initAddressbookExcercise(AddressBook ab) {
	}
	AddressBookApplication(){
		initAddressbookExcercise(ab)
	}*/

	public static void main(String args[]) throws IOException {
       //simply invokes static methods of the Menu class    	
    	AddressBook ab = new AddressBook();
		ab.init("file.txt");
		ab.list();
        //***YOU NOW FINISH CODE TO CALL ALL the rest of the static methods of the Menu class 

    }
}
//=========================================================================
//Following should be in a file called Menu.java

/* Menu class currently only has static methods to prompt to standard output information about a Contact like name,etc
 */


class AddressEntry {
    
    private String firstName, lastName, street, city, state, phone, email ;
    private int zip;
    
    public AddressEntry(String firstName,String lastName,String street,String city, String state, String phone,String email, int zip) {
        setFirstName(firstName);
        setLastName(lastName);
        setCity(city);
        setState(state);
        setStreet(street);
        setPhone(phone);
        setZip(zip);
        setEmail(email);
    }
    
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getZip() {
        return zip;
    }
    public void setZip(int zip) {
        this.zip = zip;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}



class AddressBook  {

	HashMap<String,AddressEntry>map = new HashMap<String,AddressEntry>();

    public void init(String filename) throws IOException {
   
			FileReader fr = null;
			BufferedReader br = null;	
			File file = new File(filename);
				String a = null;
				if(file.canRead()){
		            fr = new FileReader(file);
		            br = new BufferedReader(fr);
		            String strTmp;
		            int i =0;
		            while((strTmp = br.readLine()) != null)
		            { 
		            	AddressEntry a1 = new AddressEntry(null,null,null,null, null,null,null,0);
		               a = strTmp;
		               a1.setFirstName(strTmp);
		               strTmp = br.readLine();
		               a1.setLastName(strTmp);
		               strTmp = br.readLine();
		               a1.setStreet(strTmp);
		               strTmp = br.readLine();
		               a1.setState(strTmp);
		               strTmp = br.readLine();
		               a1.setCity(strTmp);
		               strTmp = br.readLine();
		               a1.setZip(Integer.parseInt(strTmp));
		               strTmp = br.readLine();
		               a1.setEmail(strTmp);
		               strTmp = br.readLine();
		               a1.setPhone(strTmp);
		               map.put(a, new AddressEntry(a1.getFirstName(),a1.getLastName(),a1.getState(),a1.getCity(),a1.getState(),a1.getPhone(),a1.getEmail(),a1.getZip()));
			}
		} 
            fr.close();
            br.close();
		}

    public void list() {
    	String result = null;
    	Set<String> keylist = map.keySet();
    	Iterator<String> itr = keylist.iterator();
    	int i =0;
        while(itr.hasNext()) {
        	String key = itr.next();
            AddressEntry a = map.get(key); 
        	System.out.println("#"+ (i+1));
            Menu.prompt_FirstName();
            System.out.println( a.getFirstName());
            Menu.prompt_LastName();
            System.out.println(   a.getLastName() );
            Menu.prompt_City();
            System.out.println(  a.getCity() );
            Menu.prompt_Street();
            System.out.println(  a.getStreet() );   
            Menu.prompt_State();
            System.out.println(  a.getState() );
            Menu.prompt_Phone();
            System.out.println(  a.getPhone() );
            Menu.prompt_Zip();
            System.out.println(  a.getZip() );
            i++;
        }
    }

	
}

class Menu {
   /*
    * prompt_FirstName  generates a standard output prompt for the First Name to be entered 
   */
    public static void prompt_FirstName() {
        System.out.print("First Name:");
    }
    public static void prompt_LastName() {
    	System.out.print("Last Name:");
    }
    public static void prompt_Street() {
    	System.out.print("Street:");
    }
    public static void prompt_City() {
    	System.out.print("City:");
    }
    public static void prompt_State() {
    	System.out.print("State:");
    }
    public static void prompt_Zip() {
    	System.out.print("Zip:");
    }
    public static void prompt_Phone() {
    	System.out.print("Phone:");
    }
    public static void prompt_Email() {
    	System.out.print("Email: ");
    }
}