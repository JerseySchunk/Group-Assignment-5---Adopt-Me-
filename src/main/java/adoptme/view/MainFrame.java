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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable petTable;
	private JButton adoptButton, removeButton, viewButton, addButton;
	
	public MainFrame() { 
		//Frame settings
		setTitle("Pet Adoption Website");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 100, 500, 400);
		setLayout(new BorderLayout());

		//Jersey Added this
		//Mainframe already extended JFrame, so I deleted unnecessary JFrame object
		//This will create pet table
		petTable = new JTable();
		add(new JScrollPane(petTable), BorderLayout.CENTER);
		
        JPanel buttonpanel = new JPanel();
		addButton = new JButton("Add Pet");
		adoptButton = new JButton("Adopt a Pet");
		removeButton = new JButton("Remove a Pet");
		viewButton = new JButton("View Pet");
		
		buttonpanel.add(addButton);
		buttonpanel.add(adoptButton);
		buttonpanel.add(removeButton);
		buttonpanel.add(viewButton);
		
		add(buttonpanel, BorderLayout.SOUTH);
		
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
