package adoptme.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MainFrame extends JFrame {
	
	private JFrame frame;
	private JTable petTable;
	private JButton adoptButton,removeButton,viewButton,addButton;
	
	public MainFrame() { 
		//Frame settings
		frame = new JFrame("Pet Test");
		setTitle("Pet Adoption Website");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 100, 500, 400);
		setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		setContentPane(panel);
		
		//Table displaying pets
        petTable = new JTable();
        add(new JScrollPane(petTable), BorderLayout.CENTER);
		//Buttons
		
		addButton = new JButton("Add Pet");
		adoptButton = new JButton("Adopt a Pet");
		removeButton = new JButton("Remove a Pet");
		viewButton = new JButton("View Pet");
		
		panel.add(addButton);
		panel.add(adoptButton);
		panel.add(removeButton);
		panel.add(viewButton);
		
		frame.add(panel);
		
	}
		
		public void addActionListeneradoptButton(ActionListener listener) {
			adoptButton.addActionListener(listener);
		}
		public void addActionListeneraddButton(ActionListener listener) {
			addButton.addActionListener(listener);
		}
		public void addActionListenerremoveButton(ActionListener listener) {
			removeButton.addActionListener(listener);
		}
		public void addActionListenerviewButton(ActionListener listener) {
			viewButton.addActionListener(listener);
		}
		
			
}
