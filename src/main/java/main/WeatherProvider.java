package main;

import model.Aircraft;

public class WeatherProvider {
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
    private static WeatherProvider weatherProvided = new WeatherProvider();

    private WeatherProvider() {}

    public static WeatherProvider getProvider(){
        return WeatherProvider.weatherProvided;
    }

    public String getCurrentWeather(Aircraft.Coordinates coordinates) {
        int values = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();
        return weather[values % 4];
    }
}
