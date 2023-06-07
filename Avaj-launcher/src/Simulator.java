import javax.security.auth.login.AccountLockedException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Simulator {

    final  static String fileName = "simulator.txt";
    public static void main(String[] args) {
        if (args.length != 1) {
            throw new WrongArgumentExeption();
        }
        closeFile();
        try(BufferedReader br = new BufferedReader(new FileReader(args[0])))
        {
            int count = Integer.parseInt(br.readLine());
            if (count <= 0)
                throw new WrongCountExeption();
            String line;
            String str[];
            int longitude,latitude, height;
            final WeatherTower weatherTower = new WeatherTower();           //final                                                     // Weather Tower
            while ((line = br.readLine()) != null) {
                str = line.split(" ");
                if (str.length != 5) {
                    throw new WrongParametersException();
                }
                longitude = Integer.parseInt(str[2]);
                latitude = Integer.parseInt(str[3]);
                height = Integer.parseInt(str[4]);
                Coordinates coordinates = new Coordinates(longitude, latitude, height);
                weatherTower.register(AircraftFactory.newAircraft(str[0], str[1], coordinates));    // изменения много какие   // Coordinates
//                AircraftFactory.instance.newAircraft(str[0], str[1], coordinates).registerTower(weatherTower);            //Aircraft Factory
//                line = br.readLine();
//                System.out.printf("ok");
            }
            for (int i = 0; i < count; i++) {
                weatherTower.changeWeather();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void printMessage(String msg){
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.append(msg);
            writer.append('\n');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void closeFile() {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.append("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

