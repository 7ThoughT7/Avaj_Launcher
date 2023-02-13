package model;

import main.WeatherTower;
import repository.Flyable;

public class Baloon extends Aircraft implements Flyable {

    private static final String RAIN = ": Damn you rain! You messed up my baloon.";
    private static final String FOG = ": OOOO, fog!!!";
    private static final String SUN = ": Hooray, the sun!!!";
    private static final String SNOW = ": It's snowing. We're gonna crash.";
    private static final String LAND = ": landing.";

    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    @Override
    public void updateConditions() {
        String newWeather = this.weatherTower.getWeather(this.coordinates);
        if (newWeather.equals("RAIN")){
            System.out.println("Baloon#" + this.name + "(" + this.id + ")" + RAIN);
            this.coordinates = new Coordinates(
                    this.coordinates.getLongitude(),
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() + (-5));
        } else if (newWeather.equals("FOG")){
            System.out.println("Baloon#" + this.name + "(" + this.id + ")" + FOG);
            this.coordinates = new Coordinates(
                    this.coordinates.getLongitude(),
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() + (-3));
        } else if (newWeather.equals("SUN")){
            System.out.println("Baloon#" + this.name + "(" + this.id + ")" + SUN);
            this.coordinates = new Coordinates(
                    this.coordinates.getLongitude(),
                    this.coordinates.getLatitude() + 2,
                    this.coordinates.getHeight() + 4);
        } else if (newWeather.equals("SNOW")){
            System.out.println("Baloon#" + this.name + "(" + this.id + ")" + SNOW);
            this.coordinates = new Coordinates(
                    this.coordinates.getLongitude(),
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() + (-15));
        } else if (newWeather.equals("LAND")) {
            System.out.println("Baloon#" + this.name + "(" + this.id + ")" + LAND);
            weatherTower.unregister(this);
            System.out.println("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
        }
    }

    @Override
    public String toString() {
        return "Baloon#" + name + "(" + id + ") ";
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        System.out.println("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        this.weatherTower.register(this);
    }

}
