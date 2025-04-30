package adoptme.model;

/**
 * Represents a dog in the adoption system.
 * Inherits common pet attributes from Pet.
 * 
 * @author joe button
 */
public class Dog extends Pet {

    /**
     * Constructs a new Dog with the given name and age.
     * 
     * @param name; the name of the dog
     * @param age; the age of the dog
     */
    public Dog(String name, int age) {
        super(name, "Dog", age);
    }
}