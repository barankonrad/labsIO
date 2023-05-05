import com.fasterxml.jackson.databind.JsonNode;
import factories.ArtDecoFactory;
import factories.FurnitureFactory;
import factories.ModernFactory;
import factories.VictorianFactory;
import furnitures.Furniture;
import furnitures.chairs.Chair;
import furnitures.sofas.Sofa;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class SerializationTest {

    private static final FurnitureFactory modernFactory = new ModernFactory();
    private static final FurnitureFactory artDecoFactory = new ArtDecoFactory();
    private static final FurnitureFactory victorianFactory = new VictorianFactory();

    @Test
    public void shouldReturnTrueWhenSerializingObject() {
        // arrange
        Sofa originalSofa = modernFactory.createSofa();

        // act
        String sofaInJson = Serializer.serializeObject(originalSofa).toString();
        Furniture deserializedSofa = Deserializer.deserializeObject(sofaInJson);

        // assert
        Assert.assertEquals(deserializedSofa, originalSofa);
    }

    @Test
    public void shouldReturnTrueWhenSerializingList() {
        // arrange
        List<Furniture> originalList = new LinkedList<>();
        originalList.add(modernFactory.createChair());
        originalList.add(artDecoFactory.createCoffeeTable());
        originalList.add(victorianFactory.createSofa());
        originalList.add(modernFactory.createSofa());

        // act
        String listInJson = Serializer.serializeList(originalList).toString();
        var deserializedList = Deserializer.deserializeList(listInJson);

        // assert
        Assert.assertEquals(deserializedList, originalList);
    }

    @Test
    @SneakyThrows(IOException.class)
    public void shouldReturnTrueWhenReadingWrittenFile() {
        // arrange
        Chair originalChair = modernFactory.createChair();

        // act
        JsonNode chairInJson = Serializer.serializeObject(originalChair);
        JsonFileWriter.printToFile(chairInJson, JsonFileWriter.SINGLE_OBJECT_FILE);
        String readJson = Files.readString(Paths.get(JsonFileWriter.SINGLE_OBJECT_FILE));
        Furniture deserializedChair = Deserializer.deserializeObject(readJson);

        // assert
        Assert.assertEquals(deserializedChair, originalChair);
    }
}
