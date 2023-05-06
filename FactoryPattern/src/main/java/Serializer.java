import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import furnitures.Furniture;

import java.util.List;

public class Serializer {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static ArrayNode serializeList(List<Furniture> furnitureCollection) {
        ArrayNode jsonArray = objectMapper.createArrayNode();
        furnitureCollection.stream()
                .map(objectMapper::valueToTree)
                .forEach(jsonObject -> jsonArray.add((JsonNode) jsonObject));

        return jsonArray;
    }

    public static JsonNode serializeObject(Furniture furniture) {
        return objectMapper.valueToTree(furniture);
    }
}