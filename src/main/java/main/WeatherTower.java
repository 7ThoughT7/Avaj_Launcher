package main;

import model.Aircraft;

/**
 * - генерация погоды (4 типа)
 * - возвращает тип погоды
 * - enum для погоды - генерируем id погоды и вовращает имя из enum
 */

public class WeatherTower extends Tower {

    public String getWeather(Aircraft.Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather() {
        this.conditionChanged();
    }

}
