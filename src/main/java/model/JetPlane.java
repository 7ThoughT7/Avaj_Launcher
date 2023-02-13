package model;

import main.WeatherTower;
import repository.Flyable;

public class JetPlane extends Aircraft implements Flyable {

    private static final String RAIN = ": It's raining. Better watch out for lightings.";
    private static final String FOG = ": OOOO, fog!!!";
    private static final String SUN = ": Hooray, the sun!!!";
    private static final String SNOW = ": OMG! Winter is coming!";
    private static final String LAND = ": landing.";

    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
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
            System.out.println("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
        }
    }

    @Override
    public String toString() {
        return "JetPlane#" + name + "(" + id + ") ";
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        System.out.println("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        this.weatherTower.register(this);
    }
}
