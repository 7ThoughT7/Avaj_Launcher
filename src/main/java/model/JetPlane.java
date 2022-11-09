package model;

import repository.Flyable;
import main.WeatherTower;

import java.util.Objects;

public class JetPlane extends Aircraft implements Flyable {

    private static final String RAIN = "It's raining. Better watch out for lightings.";
    private static final String FOG = "OOOO, fog!!!";
    private static final String SUN = "Hooray, the sun!!!";
    private static final String SNOW = "OMG! Winter is coming!";
    private static final String LAND = "landing.";

    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String newWeather = weatherTower.getWeather(this.coordinates);
        System.out.println(this.coordinates.getLongitude() + " " + this.coordinates.getLatitude() + " " + this.coordinates.getHeight());
        if (newWeather.equals("RAIN")){
            System.out.println("JetPlane#" + this.name + "(" + this.id + ")" + RAIN);
            this.coordinates = new Coordinates(
                    this.coordinates.getLongitude(),
                    this.coordinates.getLatitude() + 5,
                    this.coordinates.getHeight());
        } else if (newWeather.equals("FOG")){
            System.out.println("JetPlane#" + this.name + "(" + this.id + ")" + FOG);
            this.coordinates = new Coordinates(
                    this.coordinates.getLongitude(),
                    this.coordinates.getLatitude() + 1,
                    this.coordinates.getHeight());
        } else if (newWeather.equals("SUN")){
            System.out.println("JetPlane#" + this.name + "(" + this.id + ")" + SUN);
            this.coordinates = new Coordinates(
                    this.coordinates.getLongitude(),
                    this.coordinates.getLatitude() + 10,
                    this.coordinates.getHeight() + 2);
        } else if (newWeather.equals("SNOW")){
            System.out.println("JetPlane#" + this.name + "(" + this.id + ")" + SNOW);
            this.coordinates = new Coordinates(
                    this.coordinates.getLongitude(),
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() + (-7));
        } else if (newWeather.equals("LAND")) {
            System.out.println("JetPlane#" + this.name + "(" + this.id + ")" + LAND);
            weatherTower.unregister(this);
            System.out.println("test.Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
        }
    }

    @Override
    public String toString() {
        return "JetPlane{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println("test.Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}
