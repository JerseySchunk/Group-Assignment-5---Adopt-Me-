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
	
	private void setupListeners() {
		
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
	 * updatePetList() - Will refresh the displayed list / table of pets in the GUI
	 * after any change.
	 */
	private void updatePetList() {
		
	}
}
