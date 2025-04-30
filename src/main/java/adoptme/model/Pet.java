package adoptme.model;

/**
 * Abstract base class representing a pet in the adoption system.
 * 
 * This class defines the common attributes shared by all pets,
 * name, species, age, and adoption status. Subclasses represent specific pet types.
 * Implements Comparable to allow sorting by name.
 * 
 * Part of the Model in the MVC architecture.
 * 
 * @author Joe Button
 */
public abstract class Pet implements Comparable<Pet> {
    protected String name;
    protected String species;
    protected int age;
    protected boolean adopted;

    public Pet(String name, String species, int age) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is blank");
        }
        if (species == null || species.isBlank()) {
            throw new IllegalArgumentException("Species is blank");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }

        this.name = name;
        this.species = species;
        this.age = age;
        this.adopted = false;
    }

    @Override
    public int compareTo(Pet other) {
        return this.name.compareToIgnoreCase(other.name);
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAdopted() {
        return adopted;
    }

    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }
}
