public class Helicopter extends Aircraft implements Flyable{

    protected WeatherTower weatherTower;
    public Helicopter (long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        int lg = coordinates.getLongitude();
        int lat = coordinates.getLatitute();
        int height = coordinates.getHeight();
        switch (weather) {
            case "RAIN":
                lg += 5;
                Simulator.printMessage(this + ": Rain again...");
                break;
            case "SUN":
                lg += 10;
                height += 2;
                Simulator.printMessage(this + ": Excellent visibility.");
                break;
            case "FOG":
                lg += 1;
                Simulator.printMessage(this + ": Where is everyone?");
                break;
            case "SNOW":
                height -= 12;
                Simulator.printMessage(this + ": My rotor is going to freeze!");
                break;
        }
        if (height <= 0) {
            Simulator.printMessage(this + ": Landing!");
            weatherTower.unregister(this);
            return;
        }
        this.coordinates = new Coordinates(lg, lat, height);

    }

    public void registerTower(WeatherTower p_tower){
        this.weatherTower = p_tower;
//        p_tower.register(this);
//        System.out.println("Helicopter " + name + " with id " + id + " registered to weather tower.");
    }
    @Override
    public String toString() {
        return ("Helicopter " + name + " with id " + id + " ") ;
    }
}
