import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;

public class JsonFileWriter {

    public static final String SINGLE_OBJECT_FILE = "src/main/resources/single_object.json";
    public static final String LIST_FILE = "src/main/resources/list.json";
    private static final ObjectWriter writer = new ObjectMapper().writerWithDefaultPrettyPrinter();

    public static void printToFile(JsonNode source, String location) {
        try {
            writer.writeValue(new File(location), source);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
