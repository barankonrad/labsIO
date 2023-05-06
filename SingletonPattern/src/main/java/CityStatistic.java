import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

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
        Map<String, City> countryToCity = cities.stream()
                .collect(Collectors.toMap(City::country, Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparingLong(City::population))));
        List<City> result = new LinkedList<>(countryToCity.values());
        result.sort(Comparator.comparingDouble(City::population).reversed());

        int i = 1;
        for(City city : result) {
            System.out.printf("%-3d: %s\n", i++, city);
        }
    }

    public static void biggestCityForEachContinent() {
        Map<String, City> continentToCity = cities.stream()
                .collect(Collectors.toMap(city -> continentsToCountry.get(city.iso3()), Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparingLong(City::population))));

        List<Map.Entry<String, City>> result = new LinkedList<>(continentToCity.entrySet());
        result.sort((left, right) -> left.getKey().compareToIgnoreCase(right.getKey()));
        result.forEach(entry -> System.out.printf("%-10s - %s\n", entry.getKey(), entry.getValue()));
    }

    public static void averageCityPopulationForEachContinent() {
        Map<String, Double> averageMap = cities.stream()
                .collect(Collectors.groupingBy(city -> continentsToCountry.get(city.iso3()),
                        Collectors.averagingDouble(City::population)));

        List<Map.Entry<String, Double>> result = new LinkedList<>(averageMap.entrySet());
        result.sort((left, right) -> left.getKey().compareToIgnoreCase(right.getKey()));
        result.forEach(entry -> System.out.printf("%-10s - %f\n", entry.getKey(), entry.getValue()));
    }
}