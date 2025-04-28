package adoptme.model;

public abstract class Pet {
    protected String name;
    protected String species;
    protected int age;
    protected boolean adopted;

    public Pet(String name, String species, int age) {
        this.name = name;
        this.species = species;
        this.age = age;
        this.adopted = false;
    }

    
}
