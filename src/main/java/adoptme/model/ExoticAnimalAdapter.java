package adoptme.model;

import adoptme.thirdparty.ExoticAnimal;

public class ExoticAnimalAdapter extends Pet {
    private ExoticAnimal exoticAnimal;

    public ExoticAnimalAdapter(ExoticAnimal exoticAnimal) {
        super(exoticAnimal.getAnimalName(), exoticAnimal.getCategory(), exoticAnimal.getYearsOld());
        this.exoticAnimal = exoticAnimal;
    }

}

