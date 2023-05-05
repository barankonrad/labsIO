public record City(String city, String city_ascii, double lat, double lng, String country, String iso2, String iso3,
                   String admin_name, String capital, long population, String id) {
    public City(String[] data) {
        this(data[0],
            data[1],
            (data[2].isEmpty() ? 0 : Double.parseDouble(data[2])),
            (data[3].isEmpty() ? 0 : Double.parseDouble(data[3])),
            data[4],
            data[5],
            data[6],
            data[7],
            data[8],
            (data[9].isEmpty() ? 0 : (long) Double.parseDouble(data[9])),
            data[10]);
    }
}
