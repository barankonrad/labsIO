import au.com.bytecode.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class DAO {

    private static final DAO INSTANCE = new DAO();
    private static final String CITIES_FILE = "src/main/resources/worldcities.csv";
    private static final String CONTINENTS_FILE = "src/main/resources/continents.csv";
    private final List<City> cities = new LinkedList<>();
    private final Map<String, String> continentsToCountry = new HashMap<>();

    private DAO() {
        readFile(CITIES_FILE, data -> cities.add(new City(data)));
        readFile(CONTINENTS_FILE, data -> continentsToCountry.put(data[2], data[5]));
    }

    public static DAO getInstance() {
        return INSTANCE;
    }

    private void readFile(String path, Consumer<String[]> action) {
        try(CSVReader reader = new CSVReader(new BufferedReader(new FileReader(path)))) {
            reader.readNext(); // skip headers
            String[] data;
            while((data = reader.readNext()) != null) {
                action.accept(data);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public List<City> getCities() {
        return cities;
    }

    public Map<String, String> getContinentsToCountry() {
        return continentsToCountry;
    }
}
