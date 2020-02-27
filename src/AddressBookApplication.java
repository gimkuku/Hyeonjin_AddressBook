import java.io.*;
import java.util.*;
import java.awt.*;
/**
 * @author HyeonJin Kim
 * @version "%I%, %G%"
 */
public class AddressBookApplication {
	/**
     * @param args  array of command line String arguments
     */
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {	
		Scanner scanner = new Scanner(System.in);
		/**
	     * @param ab    name of address book to initialize
	     * @param select	name of char which people choose in menu
	     */
		AddressBook ab = new AddressBook();
		Display p = new Display();
		char select = 'q';
		while(select != 'f') {
		Menu.call_menu();
		select  = scanner.next().toCharArray()[0];
		if (select == 'f') break;
		Menu.menu(select);
		}
	}
}

