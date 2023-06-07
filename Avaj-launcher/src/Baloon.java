public class Baloon extends Aircraft implements Flyable{

    protected WeatherTower weatherTower;

    public Baloon(long p_id, String p_name, Coordinates p_coordinates) {  // если базовый класс определяет конструктор
        super(p_id, p_name, p_coordinates); //  то производный класс должен его вызвать
    }
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        int lg = coordinates.getLongitude();
        int lat = coordinates.getLatitute();
        int height = coordinates.getHeight();
        if (height <= 0) {
            return;
        }
        switch (weather) {
            case "RAIN":
                height -= 5;
                Simulator.printMessage(this + ": 'it's raining...' ");
                break;
            case "SUN":
                lg += 2;
                height += 4;
                Simulator.printMessage(this + ": It's perfect weather!");
                break;
            case "FOG":
                height -= 3;
                Simulator.printMessage(this + ": I can't see anything! ...");
                break;
            case "SNOW":
                height -= 15;
                Simulator.printMessage(this + ": 'Let it snow, let it snow, let it snow");
                break;
        }
        if (height <= 0) {
            Simulator.printMessage(this + ": Landing!");
            weatherTower.unregister(this);
            return;
        }
        this.coordinates = new Coordinates(lg, lat, height);
    }

    @Override
    public void registerTower(WeatherTower p_tower){
        weatherTower = p_tower;
    }

    @Override
    public String toString() {
        return ("Baloon " + name + " with id " + id) ;
    }
}
