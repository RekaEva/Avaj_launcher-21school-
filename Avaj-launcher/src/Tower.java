
import java.util.ArrayList;
import java.util.List;

public class Tower {
    private final List<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable) {
        observers.add(flyable);
        if (this instanceof WeatherTower) {
            flyable.registerTower((WeatherTower) this);
        }
        Simulator.printMessage(flyable.toString() + " registered to weather tower.");

    }

    public void unregister(Flyable p_flyable){
        observers.remove(p_flyable);
        Simulator.printMessage("Tower says: " + p_flyable.toString() + " unregistered from weather tower.");
    }

    protected void contditionChanged() // бегает по массиву ЛА
    {

        for (Flyable f : new ArrayList<>(observers)) {
            f.updateConditions();
        }
//        List<Flyable> obs = new ArrayList<>(observers);
//        for (Flyable observee : observers) {
//            observee.updateConditions(); // rоксяк? Ла согут себя отрегестрировать
//            // создавать новый массив
//        }
    }
}
