public class Main {
    public static void main(String[] args) {
        var instance = DAO.getInstance();

        CityPresenter.displayCity("wars");
        CityStatistic.displayTopTenCities();
        CityStatistic.averageCityPopulation();
        CityStatistic.biggestCityForEachCountry();
        CityStatistic.biggestCityForEachContinent();
        CityStatistic.averageCityPopulationForEachContinent();
    }
}
