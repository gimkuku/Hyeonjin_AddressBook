import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBook  {

	static HashMap<String,AddressEntry>map = new HashMap<String,AddressEntry>();
	static Scanner scanner = new Scanner(System.in);
	
	public static void init(String filename) throws IOException {
		String firstName, lastName, street, city, state, phone, email;
		int zip;
		FileReader fr = null;
		BufferedReader br = null;	
		File file = new File(filename);
		if(file.canRead()){
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String strTmp;
			int i =0;
			while((strTmp = br.readLine()) != null)
			{ 
				firstName = strTmp;
				lastName = br.readLine();
				street = br.readLine();
				city = br.readLine();	             
				state = br.readLine();
				zip = Integer.parseInt(br.readLine());
				phone = br.readLine();
				email = br.readLine();

				addAddress(firstName,new AddressEntry(firstName, lastName, street, city, state, phone, email, zip));
				i++;
			}
			System.out.printf("Read in %d new Addresses, successfully loaded, currently %d Addresses\n\n",i,i);
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
	public static void removeName(String lastname) {
		int i =0;
		String[] name = new String[100]; 
		for (String mapkey : map.keySet()){
			if(map.get(mapkey).getLastName().equals(lastname)) {
				name[i] = mapkey;
				i++;
			}
	    }
		for(int j =0; j< i ; j++) {
			map.remove(name[j]);
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
		System.out.println("\nThe following "+ i +" entries were found in the address book for a last name starting with \" "+ startof_lastName+"\"");
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

