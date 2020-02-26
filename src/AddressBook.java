/**
 * @author Hyeonjin Kim
 * @version "%I%, %G%"
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.*;

/**
Class AddressBook defines a list of AddressEntries as well as methods to
add new entries, as well as list all current entries
 */
public class AddressBook extends JFrame {

	/**
     * Has a HashMap of AddressEntries
     */
	static HashMap<String,AddressEntry>map = new HashMap<String,AddressEntry>();
	static Scanner scanner = new Scanner(System.in);
	
	   /**
     * @param filename  name of file for initial address book data
     */
	
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
	 /**
     * add entry to hash map
     * @param name adds entry to hashmap key
     * @param address adds entry to hashmap value
     */
	
	public static void addAddress(String name, AddressEntry address) {
		map.put(name, address);
	}
	
	 /**
     * add entry to hash map
     * @param name adds entry to hashmap key
     * @param address adds entry to hashmap value
     */
	public static void add() {
		
		 /**
	     * @param firstname    first name
	     * @param lastname    last name
	     * @param street   street name
	     * @param city    city name
	     * @param state   state name
	     * @param zip    zip code
	     * @param phone   phone number
	     * @param email    email address
	     */
		
		String firstName, lastName, street, city, state, phone, email;
		int zip;
		
		firstName = Menu.prompt_FirstName();
		lastName =Menu.prompt_LastName();
		street =Menu.prompt_Street();		
		city =Menu.prompt_City();	 
		state = Menu.prompt_State();	
		zip =Menu.prompt_Zip();
		phone =Menu.prompt_Phone();
		email =Menu.prompt_Email();
		 
		addAddress(firstName,new AddressEntry(firstName, lastName, street, city, state, phone, email, zip));
	}
	
	/**
	 * 
	 * @param lastname lastname
	 * @param name[] save the hash map keys and delete one by one using iteration
	 */
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

	/**
	 * 
	 * @param startof_lastName lastname
	 * @param list[] char list to compare the word
	 * @param flag to check the word 
	 */
	
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
	
	public void list() {
		int i=1;
			for (String mapkey : map.keySet()){
				System.out.println("#"+i++);
		        System.out.println(map.get(mapkey).toString());
		    }
	}
}

