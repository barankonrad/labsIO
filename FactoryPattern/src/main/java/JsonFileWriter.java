import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;

public class JsonFileWriter {

    public static final File SINGLE_OBJECT_FILE = new File("src/main/resources/single_object.json");
    public static final File LIST_FILE = new File("src/main/resources/list.json");
    private static final ObjectWriter writer = new ObjectMapper().writerWithDefaultPrettyPrinter();

    public static void printToFile(JsonNode source, File file) {
        try {
            writer.writeValue(file, source);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
