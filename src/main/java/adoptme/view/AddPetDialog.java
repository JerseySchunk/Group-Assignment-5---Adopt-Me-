package adoptme.view;

import javax.swing.*;
import java.awt.*;

/**
 * For collecting information to add to a new pet
 * 
 * This will allow the user to input the pets information.
 * This dialog is used in the view layer and returns the entered data only if the user
 * confirms the input. 
 */

public class AddPetDialog extends JDialog {
	
    private static final long serialVersionUID = 1L;
    private JTextField nameField, ageField;
    private JComboBox<String> typeBox;
    private boolean confirmed = false;

    /**
     * Construct a new AddPetDialog with input fields and confirmation buttons.
     * @param parent The parent frame to center this dialog on
     */
    public AddPetDialog(JFrame parent) {
        super(parent, "Add Pet", true);
        setLayout(new BorderLayout());
        setSize(275, 180);
        setLocationRelativeTo(parent);

        // The text fields for entering pet information
        nameField = new JTextField(15);
        ageField = new JTextField(5);
        String[] petTypes = { "Dog", "Cat", "Rabbit" };
        typeBox = new JComboBox<>(petTypes);


        // This is the input panel. 
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Age:"));
        inputPanel.add(ageField);
        inputPanel.add(new JLabel("Type:"));
        inputPanel.add(typeBox);

        // Buttons
        JButton addButton = new JButton("Add");
        JButton cancelButton = new JButton("Cancel");

        addButton.addActionListener(e -> handleAdd());
        cancelButton.addActionListener(e -> handleCancel());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(cancelButton);

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private void handleAdd() {
        confirmed = true;
        setVisible(false);
    }

    private void handleCancel() {
        confirmed = false;
        setVisible(false);
    }


    public boolean isConfirmed() {
        return confirmed;
    }

    public String getPetName() {
        return nameField.getText();
    }

    public int getPetAge() throws NumberFormatException {
        return Integer.parseInt(ageField.getText());
    }

    public String getPetType() {
        return (String) typeBox.getSelectedItem();
    }
}
