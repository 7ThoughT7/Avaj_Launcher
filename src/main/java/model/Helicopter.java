package model;

import main.WeatherTower;
import repository.Flyable;

public class Helicopter extends Aircraft implements Flyable {

    private static final String RAIN = ": Damn you rain! You messed up my baloon.";
    private static final String FOG = ": OOOO, fog!!!";
    private static final String SUN = ": This is hot.";
    private static final String SNOW = ": My rotor is going to freeze!";
    private static final String LAND = ": landing.";

    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public Coordinates getCoordinates() {
        return this.coordinates;
    }
    @Override
    public void updateConditions() {
        String newWeather = weatherTower.getWeather(coordinates);
        if (newWeather.equals("RAIN")){
            System.out.println("Helicopter#" + this.name + "(" + this.id + ")" + RAIN);
            this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 5,
                    coordinates.getLatitude(),
                    coordinates.getHeight());
        } else if (newWeather.equals("FOG")){
            System.out.println("Helicopter#" + this.name + "(" + this.id + ")" + FOG);
            this.coordinates = new Coordinates(
                    this.coordinates.getLongitude() + 1,
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight());
        } else if (newWeather.equals("SUN")){
            System.out.println("Helicopter#" + this.name + "(" + this.id + ")" + SUN);
            this.coordinates = new Coordinates(
                    this.coordinates.getLongitude() + 10,
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() + 2);
        } else if (newWeather.equals("SNOW")){
            System.out.println("Helicopter#" + this.name + "(" + this.id + ")" + SNOW);
            this.coordinates = new Coordinates(
                    this.coordinates.getLongitude(),
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() + (-12));
        } else if (newWeather.equals("LAND")) {
            System.out.println("Helicopter#" + this.name + "(" + this.id + ")" + LAND);
            weatherTower.unregister(this);
            System.out.println("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        System.out.println("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        this.weatherTower.register(this);
    }

    @Override
    public String toString() {
        return "Helicopter#" + name + "(" + id + ") ";
    }
}
