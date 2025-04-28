package adoptme.controller;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.FileNotFoundException;
import com.google.gson.Gson;
import adoptme.model.Shelter;
import adoptme.model.Pet;
import adoptme.view.MainFrame;

public class PetController {
	private Shelter<Pet> shelter;
	private MainFrame view;
	
	public PetController(Shelter<Pet> shelter, MainFrame view) {
		this.shelter = shelter;
		this.view = view;
		setupListeners();
		loadPets();
		updatePetList();
	}
	
	private void setupListeners() {
		
	}
	
	
	/*
	 * loadPets() will load pets from pets.json and exotic_animals.jason
	 * into the Shelter using Gson.This will happen at the start of 
	 * the program.
	 */
	private void loadPets() {
		Gson gson = new Gson();
		
		try {
			InputStream petsStream = getClass().getClassLoader().getResourceAsStream("pets.json");
			if(petsStream == null) {
				throw new FileNotFoundException("pets.json not found");
			}
			
			Reader petsReader = new InputStreamReader(petsStream);
			Pet[] pets = gson.fromJson(petsReader, Pet[].class);
			for(Pet pet : pets) {
				shelter.addPet(pet);
			}
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
	 * updatePetList() - Will refresh the displayed list / table of pets in the GUI
	 * after any change.
	 */
	private void updatePetList() {
		
	}
}
