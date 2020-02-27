import java.awt.*;
import java.awt.event.*;

public class Display extends Frame  implements ActionListener, TextListener {
	Button displayB = new Button("Display");
	Button newB = new Button("New");
	Button removeB = new Button("Remove");
	TextField f = new TextField(10);
	AddressBook ab = new AddressBook();
	AddressEntry entry = new AddressEntry(null, null, null, null, null, null, null, 0);

	String s = null;
	
Display(){
	this.setSize(300,300);
	this.setLayout(new FlowLayout());
		this.add(displayB);displayB.addActionListener(this);
		this.add(newB);newB.addActionListener(this);
		this.add(removeB);removeB.addActionListener(this);
		this.add(f); f.addTextListener(this);
		this.setVisible(true);
	}

public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if (e.getActionCommand() == "displayB") {
		System.out.println("displayB");
	ab.list();

	}
	else if (e.getActionCommand() == "newB") {
		System.out.println("newB");
	ab.add();	
	}
	else if (e.getActionCommand() == "removeB") {
		System.out.println("removeB");
	s = f.getText();
	ab.removeName(s);
	}
}

@Override
public void textValueChanged(TextEvent e) {
	// TODO Auto-generated method stub
	
}

}
