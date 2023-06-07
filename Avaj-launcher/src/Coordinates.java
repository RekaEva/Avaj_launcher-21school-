public class Coordinates {
    private int longitude;
    private int latitute;
    private int height;

    public Coordinates(int p_longitude, int p_latitute, int p_height) {
        if (p_height > 100) {
            p_height = 100;
        }
        this.longitude = p_longitude;
        this.latitute = p_latitute;
        this.height = p_height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitute() {
        return latitute;
    }

    public int getHeight() {
        return height;
    }
}
