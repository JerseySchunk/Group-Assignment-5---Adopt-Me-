package adoptme.utils;

import com.google.gson.*;
import adoptme.model.*;

import java.lang.reflect.Type;


/*
 * A deserializer for the {@link Pet} class used by Gson.
 * 
 * Because {@code Pet} is an abstract class, Gson cannot instantiate it directly.
 * Therefore, a deserializer reads the type field from JSON data nd determines
 * which concrete subclass of {@code Pet} to instantiate. Example: Dog, Cat, Rabbit
 * 
 */
public class PetDeserializer implements JsonDeserializer<Pet> {
	
	/*
	 * Deserializes a {@code JsonElement} into a concrete subclass of {@code Pet},
	 * based on the type field in the JSON object.
	 * 
	 * @param json      the JSON element representing the pet
	 * @param typeOfT   The actual type
	 * @param context   The context to delegate deserialization of known subclasses
	 * @return          {@code Dog}, {@code Cat}, or {@code Rabbit} instance, depending on the type
	 * 
	 */
    @Override
    public Pet deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject obj = json.getAsJsonObject();

        if (!obj.has("type")) {
            throw new JsonParseException("Missing 'type' field in pet JSON.");
        }

        String type = obj.get("type").getAsString();

        switch (type) {
        
            case "Dog":
                return context.deserialize(obj, Dog.class);
                
            case "Cat":
                return context.deserialize(obj, Cat.class);
                
            case "Rabbit":
                return context.deserialize(obj, Rabbit.class);
                
            default:
                throw new JsonParseException("Unknown pet type: " + type);
        }
    }
}
