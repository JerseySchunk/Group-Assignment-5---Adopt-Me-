package adoptme.thirdparty;

/**
 * Simulated third-party ExoticAnimal class.
 * This matches the structure of exotic_animals
 * 
 * DO NOT MODIFY LOGICALLY after this point—treat it is a 3rd-party class.
 * 
 * @author joe button
 */
public class ExoticAnimal {
    private String uniqueId;
    private String animalName;
    private String category;
    private String subSpecies;
    private int yearsOld;

    public ExoticAnimal(String uniqueId, String animalName, String category, String subSpecies, int yearsOld) {
        this.uniqueId = uniqueId;
        this.animalName = animalName;
        this.category = category;
        this.subSpecies = subSpecies;
        this.yearsOld = yearsOld;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getCategory() {
        return category;
    }

    public String getSubSpecies() {
        return subSpecies;
    }

    public int getYearsOld() {
        return yearsOld;
    }
}
