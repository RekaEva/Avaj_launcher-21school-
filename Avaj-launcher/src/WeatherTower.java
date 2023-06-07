public class WeatherTower extends Tower{
    public String getWeather(Coordinates p_coordinates)// должен вызвать синглтон
    {
        String str = WeatherProvider.getCurrentWeather(p_coordinates);
        return str;
    }

    public void changeWeather(){
        this.contditionChanged();
    }
}
