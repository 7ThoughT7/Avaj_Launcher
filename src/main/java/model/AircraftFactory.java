package model;

import repository.Flyable;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        String HELICOPTER = "Helicopter";
        String JETPLANE = "JetPlane";
        String BALOON = "Baloon";
//        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        if (type.equals(HELICOPTER)) {
            return new Helicopter(name, new Coordinates(longitude, latitude, height));
        } else if (type.equals(JETPLANE)) {
            return new JetPlane(name, new Coordinates(longitude, latitude, height));
        } else if (type.equals(BALOON)) {
            return new Baloon(name, new Coordinates(longitude, latitude, height));
        }
        return null;
    }
}
