package adoptme.utils;

import adoptme.model.Pet;
import java.util.Comparator;


/*
 * public class PetComparators
 * Provides reusable logic sort Pet objects according to age species and name.
 * It uses 'Comparator<T>' interface to define custom sorting
 */
public class PetComparators {
	
	public static class AgeComparator implements Comparator<Pet>{
		@Override
		public int compare(Pet p1, Pet p2) {
			return Integer.compare(p1.getAge(), p2.getAge());
		}
	}
	
	public static class SpeciesComparator implements Comparator<Pet>{
		@Override
		public int compare(Pet p1, Pet p2) {
			return p1.getSpecies().compareToIgnoreCase(p2.getSpecies());
		}
	}
	
	public static class NameComparator implements Comparator<Pet>{
		@Override
		public int compare(Pet p1, Pet p2) {
			return p1.getName().compareToIgnoreCase(p2.getName());
		}
	}

}
