package main;

import model.Coordinates;

public class WeatherProvider {
    private static final String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
    private static WeatherProvider weatherProvided = new WeatherProvider();

    private WeatherProvider() {}

    public static WeatherProvider getProvider(){
        return WeatherProvider.weatherProvided;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int values = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();
        return weather[Math.abs(values % 4)];
    }
}
