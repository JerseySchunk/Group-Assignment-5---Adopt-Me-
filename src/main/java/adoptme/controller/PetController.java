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
	
	private void loadPets() {
		Gson gson = new Gson();
		
		try {
			InputStream petsStream = getClass().getClassLoader().getResourceAsStream("pets.json");
			if(petsStream == null) {
				throw new FileNotFoundException("pets.json not found");
			}
			}
		}
	}
	
	private void addPet() {
		
	}
	
	private void removePet() {
		
	}
	
	private void adoptPet() {
		
	}
	
	private void sortPets() {
		
	}
	
	private void savePets() {
		
	}
	
	private void updatePetList() {
		
	}
}
