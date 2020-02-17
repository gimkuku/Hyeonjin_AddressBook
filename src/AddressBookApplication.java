import java.io.*;
import java.util.*;

public class AddressBookApplication {
	public static void main(String args[]) throws IOException {	
		Scanner scanner = new Scanner(System.in);
		
		AddressBook ab = new AddressBook();
		char select = 'q';
		while(select != 'f') {
		Menu.call_menu();
		select  = scanner.next().toCharArray()[0];
		if (select == 'f') break;
		Menu.menu(select);
		}
	}
}


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
	
	public String toString() {
		
		return firstName +"\n"+ lastName+"\n"+ street+"\n"+ city+"\n"+ state+"\n"+ phone+"\n"+ email +"\n"+ String.valueOf(zip)+"\n"+"\n";
		
	}
}



class AddressBook  {

	static HashMap<String,AddressEntry>map = new HashMap<String,AddressEntry>();
	static Scanner scanner = new Scanner(System.in);
	
	public static void init(String filename) throws IOException {
		String firstName, lastName, street, city, state, phone, email;
		int zip;
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
				firstName = strTmp;
				lastName = br.readLine();
				a = firstName;
				street = br.readLine();
				city = br.readLine();	             
				state = br.readLine();
				zip = Integer.parseInt(br.readLine());
				phone = br.readLine();
				email = br.readLine();

				addAddress(a,new AddressEntry(firstName, lastName, street, city, state, phone, email, zip));
				i++;
			}
			System.out.printf("Read in %d new Addresses, successfully loaded, currently %d Addresses",i,i);
		} 
		
		fr.close();
		br.close();
	}

	public static void addAddress(String name, AddressEntry address) {
		map.put(name, address);
	}
	public static void add() {
		String firstName, lastName, street, city, state, phone, email;
		int zip;
		
		Menu.prompt_FirstName();
		firstName = scanner.nextLine();
		Menu.prompt_LastName();
		lastName = scanner.nextLine();
		Menu.prompt_Street();
		street = scanner.nextLine();
		Menu.prompt_City();
		city = scanner.nextLine();
		Menu.prompt_State();
		state = scanner.nextLine();
		Menu.prompt_Zip();
		zip = Integer.parseInt(scanner.nextLine());
		Menu.prompt_Phone();
		phone = scanner.nextLine();
		Menu.prompt_Email();
		email = scanner.nextLine();
		addAddress(firstName,new AddressEntry(firstName, lastName, street, city, state, phone, email, zip));
	}
	public static void remove(String lastname) {
		for (String mapkey : map.keySet()){
			if(map.get(mapkey).getLastName() == lastname) {
				map.remove(mapkey);
			}
	    }
	} 

	public static void find(String startof_lastName) {
		int i =0;
		boolean flag = true;
		String[] list = new String[100];
		for (String mapkey : map.keySet()){
			for(int j =0; j<startof_lastName.length();j++) {
				if (map.get(mapkey).getLastName().charAt(j) != startof_lastName.charAt(j))
					flag = false;
			}
			if(flag == true) {
				list[i] = mapkey;
				i++;}
	    }
		System.out.println("The following "+ i +" entries were found in the address book for a last name starting with \" "+ startof_lastName+"\"");
		if(i != 0) {
		for(int j =0; j < i;j++) {
			System.out.println("#"+(j+1));
			System.out.println(map.get(list[j]).toString());
		}}
	} 
	
	public static void list() {
		int i=1;
			for (String mapkey : map.keySet()){
				System.out.println("#"+i++);
		        System.out.println(map.get(mapkey).toString());
		    }
	}
}



class Menu {
	static Scanner scanner = new Scanner(System.in);
	public static void call_menu() {
		System.out.println("**********************************");
		System.out.println("a) Loading From File");
		System.out.println("b) Addition");
		System.out.println("c) Removal");
		System.out.println("d) Find");
		System.out.println("e) Listing");
		System.out.println("");
		System.out.println("f) Quit");
		System.out.println("**********************************");
	} 
	public static void menu(char select) throws IOException {
		switch(select) {
		case 'a': 
			System.out.println("Enter in Filename\n");
			String filename = scanner.next();
			AddressBook.init(filename);			
			break;
			
		case 'b':
			AddressBook.add();
			break;
		
		case 'c':
			System.out.println("Enter in Last Name of contact to remove: \n");
			String lastname = scanner.next();
			AddressBook.remove(lastname);
			break;
			
		case 'd':
			System.out.println("Enter in all or the begining of the Last Name of the contact you wish to find: \n");
			String startof_lastName = scanner.next();
			AddressBook.find(startof_lastName);
			break;
			
		case 'e':
			AddressBook.list();
			break;
		case 'f':break;	
			}
			
		
	}
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