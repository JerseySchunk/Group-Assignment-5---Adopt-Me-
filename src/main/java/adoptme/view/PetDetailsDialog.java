package adoptme.view;

import javax.swing.*;

/**
 * A dialog window that displays details about a selected pet
 * This dialog will show the pet's name, age, species, and adoptions status
 */

public class PetDetailsDialog extends JDialog {
   
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a PetDetailsDialog with the specified pet information.
	 * 
	 * @param parent  The parent frame to attach this dialog to
	 * @param name    The pet's name
	 * @param age     The pets age
	 * @param species The pets species
	 * @param adopted The pets adoption status
	 */
	public PetDetailsDialog(JFrame parent, String name, String age, String species, String adopted) {
		
        super(parent, "Pet Details", true);
        setSize(300, 150);
        setLocationRelativeTo(parent);

        JTextArea info = new JTextArea("Name: " + name + "\nAge: " + age + "\nSpecies: " + species + "\nAdopted: " + adopted);
        
        info.setEditable(false);

        add(info);
    }
}
