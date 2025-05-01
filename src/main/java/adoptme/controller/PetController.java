package adoptme.controller;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.FileNotFoundException;
import com.google.gson.Gson;
import adoptme.model.Shelter;
import adoptme.thirdparty.ExoticAnimal;
import adoptme.model.Pet;
import adoptme.view.MainFrame;
import adoptme.model.ExoticAnimalAdapter;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import adoptme.utils.PetComparators;
import java.util.Date;
import java.io.FileWriter;
import java.io.IOException;

public class PetController {
	private Shelter<Pet> shelter;
	private MainFrame view;
	
	//PetController constructor used to create a PetController object.
	//Shelter<pet> - object (data)
	//MainFrame - object (window)
	public PetController(Shelter<Pet> shelter, MainFrame view) {
		this.shelter = shelter;
		this.view = view;
		setupListeners();
		loadPets();
		updatePetList();
	}
	
	/*
	 * setupListeners()
	 * Will connect the GUI buttons to the controller logic.
	 */
	private void setupListeners() {
		view.addActionListeneraddButton(e -> addPet());
		view.addActionListenerremoveButton(e -> removePet());
		view.addActionListeneradoptButton(e -> adoptPet());
		view.addActionListenerviewButton(e -> viewPetDetails());
		view.addActionListenerSaveButton(e -> savePets());
		view.getSortComboBox().addActionListener(e -> sortPets());
	}
	
	
	
	
	/*
	 * viewPetDetails()
	 * Will display the details of the currently selected pet in a pop up.
	 * 
	 * If not pet is selected, a warning message is shown which prompts the
	 * user to select a pet. If a pet is selected, it will retrieve the pet's
	 * information from the selected row in the table and present it.
	 */
	private void viewPetDetails() {
		JTable table = view.getPetTable();
		int selectedRow = table.getSelectedRow();
		
		if(selectedRow == -1) {
			JOptionPane.showMessageDialog(view,  "Please select a pet to view details.", "No Pet Selected", JOptionPane.WARNING_MESSAGE);
		}
		
		//Gets data from selected row
		String name = table.getValueAt(selectedRow, 0).toString();
		String age = table.getValueAt(selectedRow, 1).toString();
		String species = table.getValueAt(selectedRow, 2).toString();
		String adopted = table.getValueAt(selectedRow, 3).toString();
		
		//Builds detail message
		String message = "Name: " + name + "\nAge: " + age + "\nSpecies: " + species + "\nAdopted: " + adopted;
		
		//Displays the information in a pop up
		JOptionPane.showMessageDialog(view, message, "Pet Details", JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	/*
	 * loadPets() will load pets from pets.json and exotic_animals.json
	 * into the Shelter using Gson. This will happen at the start of 
	 * the program.
	 */
	private void loadPets() {
	    Gson gson = new Gson();
	    
	    //Find and open pets.json file inside src/main/resources
	    //Reads the info into InputStream
	    //If the file is not found, stops and throws an error
	    try {
	        InputStream petsStream = getClass().getClassLoader().getResourceAsStream("pets.json");
	        if (petsStream == null) {
	            throw new FileNotFoundException("pets.json not found");
	        }
	        
	        //Wraps InputStream in a Reader so Gson can parse it
	        //Parses the entire JSON array into a real array of Pet objects
	        //Loops through each pet object loaded and adds the Pet's into the Shelter storage
	        Reader petsReader = new InputStreamReader(petsStream);
	        Pet[] pets = gson.fromJson(petsReader, Pet[].class);
	        for (Pet pet : pets) {
	            shelter.addPet(pet);
	        }
	        
	        // Tries to load 'exotic_animals.json' and if it doesn't exist, crashes the application
	        //and shows an error saying the file could not be found
	        InputStream exoticStream = getClass().getClassLoader().getResourceAsStream("exotic_animals.json");
	        if (exoticStream == null) {
	            throw new FileNotFoundException("exotic_animals.json not found");
	        }
	        
	        //converts the 'exotic_animals.json' file into 'ExoticAnimal' objects.
	        //Then wraps each of those into Pet-like objects using the adapter.
	        //Then adds them to the pet list (shelter)
	        Reader exoticReader = new InputStreamReader(exoticStream);
	        ExoticAnimal[] exotics = gson.fromJson(exoticReader, ExoticAnimal[].class);
	        for (ExoticAnimal exotic : exotics) {
	            ExoticAnimalAdapter adaptedExotic = new ExoticAnimalAdapter(exotic);
	            shelter.addPet(adaptedExotic);
	        }
	        
	        //Catches potential error and prints what happened. 
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
	//addPet() will handle adding a new pet. Will open dialog, get input, create
	//new pet, add it to shelter.
	private void addPet() {
		//Gets name from input. If not valid, returns
		String name = JOptionPane.showInputDialog(view, "Enter the new pet's name: ");
		if(name == null || name.isBlank()) {
			JOptionPane.showMessageDialog(view, "Name cannot be blank.", "Invalid input", JOptionPane.WARNING_MESSAGE);
			return;
		}
		//Gets species from input. If not valid, returns
		String species = JOptionPane.showInputDialog(view, "Enter the pet's species:");
		if(species == null || species.isBlank()) {
			JOptionPane.showMessageDialog(view, "Species cannot be blank.", "Invalid input", JOptionPane.ERROR_MESSAGE);
			return;
		}
		//Gets age from input. If not valid, returns
		String ageInput = JOptionPane.showInputDialog(view, "Enter the pet's age (integer values):");
		int age;
		try {
			age = Integer.parseInt(ageInput);
			if(age < 0) {
				throw new NumberFormatException();
			}
			}catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(view,  "Invalid age. Please enter age 0 or above", "Invalid input", JOptionPane.ERROR_MESSAGE);
				return;
			}
		//Creates pet with the input information.
		Pet newPet = new Pet(name, species, age) {};
		//Adds the pet to the shelter and refreshes the GUI.
		shelter.addPet(newPet);
		updatePetList();
		
	}
	
	/*
	 * removePet() will Remove the selected pet from the shelter when the remove
	 * button is clicked.
	 */
	private void removePet() {
		JTable table = view.getPetTable();
		int selectedRow = table.getSelectedRow();
		
		if(selectedRow == -1) {
			JOptionPane.showMessageDialog(view, "Select a pet to remove.", "No pet selected.", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		int confirm = JOptionPane.showConfirmDialog(view,  "Are you sure you want to remove the pet?", "Confirm Removal", JOptionPane.YES_NO_OPTION);
		//Checks if user clicked yes. If no, it exits the method and cancels the removal
		if(confirm != JOptionPane.YES_OPTION) {
			return;
		}
		//Gets pet to remove and removes it
		Pet petToRemove = shelter.getAllPets().get(selectedRow);
		shelter.removePet(petToRemove);
		updatePetList();
	}
	
	/*
	 * This is the method for the adoption process for the selected pet in the MainFrame (GUI)
	 * 
	 * If not pet is selected, will provide a warning. If the pet selected
	 * is adopted, it gives a warning and exits. Otherwise, updates the pet to adopted, shows a 
	 * confirmation message, and updates the pet list in the GUI.
	 */
	private void adoptPet() {
		JTable table = view.getPetTable();
		int selectedRow = table.getSelectedRow();
		
		//If user hasn't selected any pet this will return 
		if(selectedRow == -1) {
			JOptionPane.showMessageDialog(view, "Select a pet to adopt.", "No pet selected.", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		Pet selectedPet = shelter.getAllPets().get(selectedRow);
		
		//checks if pet is already adopted, if so exits
		if(selectedPet.isAdopted()) {
			JOptionPane.showMessageDialog(view,  "This pet has already been adopted.", "Already adopted.", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		//Marks selected pet as adopted, shows a confirmation message, and updates the PetList
		selectedPet.setAdopted(true);
		JOptionPane.showMessageDialog(view, "You have adopted "  + selectedPet.getName() + ".", "Pet was adopted!", JOptionPane.INFORMATION_MESSAGE);
		updatePetList();
	}
	
	/*
	 * Sorts the list based on the user's selection: Name, Age, Species, when they 
	 * change the box
	 */
	private void sortPets() {
		
		//Gets the selection from the combo box. 
		//Gets the list of pets in the shelter.
			String selected = (String) view.getSortComboBox().getSelectedItem();

			switch (selected) {
				case "Age":
					shelter.sortBy(new PetComparators.AgeComparator());
					break;

				case "Species":
					shelter.sortBy(new PetComparators.SpeciesComparator());
					break;

				case "Name":
				default:
					shelter.sortByName(); // uses natural order (by name)
					break;
			}

			updatePetList(); // refresh table
		}

	
	
	/*
	 * savePets() - Saves the current shelter state back into a JSON file, naming
	 * it with current date / time.
	 */
	private void savePets() {
		//Retrieves list of pets from Shelter object
		List<Pet> pets = shelter.getAllPets();
		
		//Creates Gson object to store converted List data
		Gson gson = new Gson();
		//Gets the current date and time and then appends the filename to include the date and time.
		String time = new java.text.SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String filename = time + "_pets.json";
		
		//Attempts to convert pets list into JSON and write the data into GSon file. 
		//Prints error if this fails. 
		try(FileWriter writer = new FileWriter(filename)){
			gson.toJson(pets, writer);
			JOptionPane.showMessageDialog(view, "Pets saved to " + filename, "Save complete!", JOptionPane.INFORMATION_MESSAGE);
		}catch(IOException e) {
			JOptionPane.showMessageDialog(view, "Saving failure: " + e.getMessage(), "Error saving", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	/*
	 * updatePetList() 
	 * Will update the pet table in the GUI to show the state of the shelter.
	 * Will retrieve all pets from the shelter, build a table model with columns
	 * for the Name, Age, Species, and if Adopted. And will set the model to the
	 * JTable in MainFrame. 
	 */
	private void updatePetList() {
		
		String[] columns = { "Name", "Age", "Species", "Adopted" };
		DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
		
		List<Pet> pets = shelter.getAllPets();
		for(int i = 0; i < pets.size(); i++) {
			Pet pet = pets.get(i);
			Object[] row = new Object[4];
			row[0] = pet.getName();
			row[1] = pet.getAge();
			row[2] = pet.getSpecies();
			if (pet.isAdopted()) {
			    row[3] = "Yes";
			} else {
			    row[3] = "No";
			}
			tableModel.addRow(row);
		}
		
		view.getPetTable().setModel(tableModel);
		
	}
}
