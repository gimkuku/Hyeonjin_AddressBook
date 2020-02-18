/**
 * @author Hyeonjin Kim
 * @version "%I%, %G%"
 */

import java.io.IOException;
import java.util.Scanner;

public class Menu {
	static Scanner scanner = new Scanner(System.in);
	public static void call_menu() {
		System.out.println("\n**********************************");
		System.out.println("a) Loading From File");
		System.out.println("b) Addition");
		System.out.println("c) Removal");
		System.out.println("d) Find");
		System.out.println("e) Listing");
		System.out.println("");
		System.out.println("f) Quit");
		System.out.println("**********************************");
	} 
	
	/**
	 * 
	 * @param select char which user select on Menu
	 * @throws IOException using scanner
	 */
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
			AddressBook.removeName(lastname);
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