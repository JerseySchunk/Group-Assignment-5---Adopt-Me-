package adoptme.model;

import adoptme.thirdparty.ExoticAnimal;

/**
 * Adapter wraps an ExoticAnimal object and treat it like a standard Pet.
 * This allows ExoticAnimal instances to work with  with the rest of the system.
 */
public class ExoticAnimalAdapter extends Pet {

    private ExoticAnimal exotic;

    public ExoticAnimalAdapter(ExoticAnimal exotic) {
        super(
            exotic.getAnimalName(),
            exotic.getSubSpecies() + " (" + exotic.getCategory() + ")",
            exotic.getYearsOld()
        );
        this.exotic = exotic;
    }

    public String getUniqueId() {
        return exotic.getUniqueId();
    }

    public ExoticAnimal getWrappedExoticAnimal() {
        return exotic;
    }
}
