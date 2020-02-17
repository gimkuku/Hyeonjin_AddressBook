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

