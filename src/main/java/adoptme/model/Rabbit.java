package adoptme.model;

/**
 * Represents a rabbit in the adoption system.
 * Inherits common pet attributes from Pet.
 * 
 * @author joe button
 */
public class Rabbit extends Pet {

    /**
     * Constructs a new Rabbit with the given name and age.
     * 
     * @param name the name of the rabbit
     * @param age the age of the rabbit
     */
    public Rabbit(String name, int age) {
        super(name, "Rabbit", age);
    }
}