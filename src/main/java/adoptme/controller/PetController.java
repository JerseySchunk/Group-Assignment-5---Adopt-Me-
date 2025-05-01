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
		
		
	}
	
	/*
	 * removePet() will Remove the selected pet from the shelter when the remove
	 * button is clicked.
	 */
	private void removePet() {
		
	}
	
	/*
	 * Marks the selected pet as adopted. Blocks if already adopted - which means
	 * show an error.
	 */
	private void adoptPet() {
		
	}
	
	/*
	 * Sorts the list based on the user's selection: Name, Age, Species, when they 
	 * change the box
	 */
	private void sortPets() {
		
	}
	
	
	/*
	 * savePets() - Saves the current shelter state back into a JSON file, naming
	 * it with current date / time.
	 */
	private void savePets() {
		
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
			row[3] = pet.isAdopted() ? "Yes" : "No";
			tableModel.addRow(row);
		}
		
		view.getPetTable().setModel(tableModel);
		
	}
}
