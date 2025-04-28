package adoptme.controller;

import adoptme.model.Shelter;
import adoptme.model.Pet;
import adoptme.view.PetView;

public class PetController {
	private Shelter<Pet> shelter;
	private PetView view;
	
	public PetController(Shelter<Pet> shelter, PetView view) {
		this.shelter = shelter;
		this.view = view;
		setupListeners();
		loadPets();
		updatePetList();
	}
	
	private void setupListeners() {
		
	}
	
	private void loadPets() {
		
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
