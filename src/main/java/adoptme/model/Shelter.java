package adoptme.model;

import java.util.List;
import java.util.ArrayList;

public class Shelter<T extends Pet> {
	
	private List<T> pets;
	
	public Shelter() {
		pets = new ArrayList<>();
	}

	public void addPet(T pet) {
		pets.add(pet);
	}
	
}
