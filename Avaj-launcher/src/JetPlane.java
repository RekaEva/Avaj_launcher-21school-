public class JetPlane extends Aircraft implements Flyable{
    protected WeatherTower weatherTower;
    public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
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
                lat += 5;
                Simulator.printMessage(this + ": 'A little wet today...");
                break;
            case "SUN":
                lg += 10;
                height += 2;
                Simulator.printMessage(this + ": Good weather today!");
                break;
            case "FOG":
                lat += 1;
                Simulator.printMessage(this + ": Fogging");
                break;
            case "SNOW":
                height -= 7;
                Simulator.printMessage(this + ": White and cold");
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
//        System.out.println("JetPlane " + name + " with id " + id + " registered to weather tower.");
    }

    @Override
    public String toString() {
        return ("JetPlane" + name + " with id " + id ) ;
    }
}

