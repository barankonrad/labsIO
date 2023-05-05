import java.util.*;

public class CityStatistic {

    private static final List<City> cities = DAO.getInstance().getCities();
    private static final Map<String, String> continentsToCountry = DAO.getInstance().getContinentsToCountry();

    public static void displayTopTenCities() {
        List<City> topResults = cities.stream()
            .sorted((left, right) -> Double.compare(right.population(), left.population()))
            .limit(10)
            .toList();

        int i = 1;
        for(City city : topResults) {
            System.out.printf("%-3d: %s\n", i++, city);
        }
    }

    public static void averageCityPopulation() {
        cities.stream()
            .mapToDouble(City::population)
            .average()
            .ifPresent(System.out::println);
    }

    public static void biggestCityForEachCountry() {
        Map<String, City> countryToCity = new HashMap<>();

        for(City city : cities) {
            if(countryToCity.containsKey(city.country())) {
                City currentCity = countryToCity.get(city.country());
                if(city.population() > currentCity.population()) {
                    countryToCity.put(city.country(), city);
                }
            }
            else {
                countryToCity.put(city.country(), city);
            }
        }

        List<City> result = new LinkedList<>(countryToCity.values());
        result.sort(Comparator.comparingDouble(City::population).reversed());

        int i = 1;
        for(City city : result) {
            System.out.printf("%-3d: %s\n", i++, city);
        }
    }

    public static void biggestCityForEachContinent() {
        Map<String, City> continentToCity = new HashMap<>();

        for(City city : cities) {
            String continent = continentsToCountry.get(city.iso3());
            if(continentToCity.containsKey(continent)) {
                City currentCity = continentToCity.get(continent);
                if(city.population() > currentCity.population()) {
                    continentToCity.put(city.country(), city);
                }
            }
            else {
                continentToCity.put(continent, city);
            }
        }

        List<Map.Entry<String, City>> result = new LinkedList<>(continentToCity.entrySet());
        result.sort((left, right) -> left.getKey().compareToIgnoreCase(right.getKey()));
        result.forEach(entry -> System.out.printf("%-10s - %s\n", entry.getKey(), entry.getValue()));
    }

    public static void averageCityPopulationForEachContinent() {
        Map<String, Double> averageMap = new HashMap<>();
        Map<String, Integer> counterMap = new HashMap<>();

        for(City city : cities) {
            String continent = continentsToCountry.get(city.iso3());
            counterMap.put(continent, counterMap.getOrDefault(continent, 0) + 1);
            averageMap.put(continent, averageMap.getOrDefault(continent, 0.0) + city.population());
        }
        for(var entry : averageMap.entrySet()) {
            double value = entry.getValue() / counterMap.get(entry.getKey());
            entry.setValue(value);
        }

        List<Map.Entry<String, Double>> result = new LinkedList<>(averageMap.entrySet());
        result.sort((left, right) -> left.getKey().compareToIgnoreCase(right.getKey()));
        result.forEach(entry -> System.out.printf("%-10s - %f\n", entry.getKey(), entry.getValue()));
    }
}