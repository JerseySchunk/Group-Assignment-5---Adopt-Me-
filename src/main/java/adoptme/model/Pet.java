package adoptme.model;

/**
 *base class representing a pet
 */

public abstract class Pet implements Comparable <Pet>{
    protected String name;
    protected String species;
    protected int age;
    protected boolean adopted;

    public Pet(String name, String species, int age) {
    	
    	if (name == null || name.isBlank()) {
    		throw new IllegalArgumentException("name is blank");
    	}
    	if (species == null || species.isBlank())	{
    		throw new IllegalArgumentException("Species is blank");
    	}
    	if (age < 0) {
    		throw new IllegalArgumentException("age can not be negitive");
    	}
    	
        this.name = name;
        this.species = species;
        this.age = age;
        this.adopted = false;
        
        
    }

    
}
