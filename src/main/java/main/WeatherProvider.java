package main;

import model.Coordinates;

import java.util.Random;

public class WeatherProvider {
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
    private static WeatherProvider weatherProvided = new WeatherProvider();

    private WeatherProvider() {}

    public static WeatherProvider getProvider(){
        return WeatherProvider.weatherProvided;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        Random random = new Random();
        int values = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();
        return weather[random.nextInt(3)];
    }
}
