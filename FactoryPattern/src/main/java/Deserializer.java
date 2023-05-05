import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import furnitures.Furniture;

import java.io.IOException;
import java.util.List;

public class Deserializer {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<Furniture> deserializeList(String jsonString) {
        try {
            return objectMapper.readValue(jsonString, new TypeReference<>() {});
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Furniture deserializeObject(String jsonString) {
        try {
            return objectMapper.readValue(jsonString, Furniture.class);
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
