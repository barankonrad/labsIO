import java.util.List;

public class CityPresenter {
    private static final List<City> cities = DAO.getInstance().getCities();

    public static void displayCity(String name) {
        cities.stream()
                .filter(temp -> temp.city().toLowerCase().startsWith(name.toLowerCase())
                        || temp.city_ascii().toLowerCase().startsWith(name.toLowerCase()))
                .forEach(System.out::println);
    }
}
