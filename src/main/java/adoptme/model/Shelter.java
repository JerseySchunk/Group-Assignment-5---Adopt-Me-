package adoptme.model;

import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;


/**
 * A generic shelter class that manages adoptable pets.
 *
 * @param <T> Any class that extends Pet
 */
public class Shelter<T extends Pet> {

    private final List<T> pets = new ArrayList<>();

    /**
     * Adds a pet to the shelter.
     *
     * @param pet the pet to add
     */
    public void addPet(T pet) {
        if (pet != null) {
            pets.add(pet);
        }
    }

    /**
     * Removes a pet from the shelter.
     *
     * @param pet the pet to remove
     */
    public void removePet(T pet) {
        pets.remove(pet);
    }

    /**
     * Returns a copy of the pet list.
     *
     * @return all pets in the shelter
     */
    public List<T> getAllPets() {
        return new ArrayList<>(pets);
    }

    /**
     * Marks a pet as adopted, if it hasn’t already been adopted.
     *
     * @param pet the pet to adopt
     * @return true if adoption succeeded, false if already adopted
     */
    public boolean adoptPet(T pet) {
        if (pet != null && !pet.isAdopted()) {
            pet.setAdopted(true);
            return true;
        }
        return false;
    }

    /**
     * Sorts pets using their natural order (by name).
     */
    public void sortByName() {
        Collections.sort(pets);
    }

    /**
     * Sorts pets using a provided comparator (e.g. by age or species).
     *
     * @param comparator a comparator for sorting
     */
    public void sortBy(Comparator<T> comparator) {
        pets.sort(comparator);
    }
}