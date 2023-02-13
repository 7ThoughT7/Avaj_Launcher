package main;

import model.Coordinates;
import repository.Flyable;

import java.util.ArrayList;
import java.util.List;


public class CheckCoordinates {


    public CheckCoordinates() {
    }

    public static boolean checkCoordinate (Coordinates coordinates) {

        int height = coordinates.getHeight();
        if (height <= 0) {
            return false;
        } else if (height > 100) {
            coordinates.setHeight(100);
            return true;
        }
        return true;
    }

    public static List<Flyable> checkAircraftCrash(List<Flyable> flyableList) {
        List<Flyable> flyDelete = new ArrayList<>();
        for (int i = 0; i < flyableList.size(); i++) {
            Coordinates flyFirst = flyableList.get(i).getCoordinates();
            for (int j = (i + 1); j < flyableList.size(); j++) {
                Coordinates flySecond = flyableList.get(j).getCoordinates();
                if (flyFirst.getLongitude() == flySecond.getLongitude() &&
                        flyFirst.getLatitude() == flySecond.getLatitude() &&
                        flyFirst.getHeight() == flySecond.getHeight() &&
                        !flyableList.get(i).equals(flyableList.get(j))) {
                    flyDelete.add(flyableList.get(i));
                    flyDelete.add(flyableList.get(j));
                }
            }
        }
        return flyDelete;
    }

    public static void deleteAircraftCrash(Tower tower) {
        List<Flyable> flyDelete = checkAircraftCrash(tower.getFlyable());
        if (flyDelete != null) {
            for (int j = 0; j < flyDelete.size(); j++) {
                if (tower.getFlyable().contains(flyDelete.get(j))) {
                    tower.unregisterCrash(flyDelete.get(j));
                }
            }
        }
    }
}
