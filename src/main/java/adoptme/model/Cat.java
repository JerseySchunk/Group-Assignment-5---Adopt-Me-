package adoptme.model;

/**
 * Represents a cat in the adoption system.
 * Inherits common pet attributes from Pet.
 * 
 * @author joe button
 */
public class Cat extends Pet {

    /**
     * Constructs a new Cat with the given name and age.
     * 
     * @param name the name of the cat
     * @param age the age of the cat
     */
    public Cat(String name, int age) {
        super(name, "Cat", age);
    }
}