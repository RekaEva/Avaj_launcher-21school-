public class WeatherProvider {
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
//    static WeatherProvider provider = new WeatherProvider();
    private WeatherProvider()
    {}
    public  static String getCurrentWeather(Coordinates p_coordinates)
    {
        int generator = p_coordinates.getHeight() + p_coordinates.getLatitute() + p_coordinates.getLongitude();
        return weather[generator % 4];
//        String str;
//        str = weather[(p_coordinates.getHeight() + p_coordinates.getLatitute() + p_coordinates.getLongitude()) % 4];
//        return str;
    }


}
