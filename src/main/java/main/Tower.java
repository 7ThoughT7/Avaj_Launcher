package main;

import repository.Flyable;

import java.util.ArrayList;
import java.util.List;

import static main.CheckCoordinates.*;

public class Tower {

    private List<Flyable> flyable = new ArrayList<>();

    public void register(Flyable newFlyable) {
        if (!flyable.contains(newFlyable)) {
            flyable.add(newFlyable);
        }
        if (flyable.size() > 1) {
            deleteAircraftCrash(this);
        }

    }

    public void unregister(Flyable oldFlyable) {
        flyable.remove(oldFlyable);
        System.out.println(oldFlyable +  "lending");
        System.out.println("Tower says: " + oldFlyable + "unregistered from weather tower.");
    }

    public void unregisterCrash(Flyable oldFlyable) {
        flyable.remove(oldFlyable);
        System.out.println("Tower says: " + oldFlyable + " crashed!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("Tower says: " + oldFlyable + "unregistered from weather tower.");

    }

    protected void conditionChanged() {
        for (int i = 0; i < flyable.size(); i++) {
            Flyable fly = flyable.get(i);
            fly.updateConditions();
            if (!checkCoordinate(fly.getCoordinates())) {
                unregister(fly);
            }
        }
        deleteAircraftCrash(this);
    }

    public List<Flyable> getFlyable() {
        return flyable;
    }

}
