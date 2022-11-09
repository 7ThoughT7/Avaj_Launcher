package main;

import model.Aircraft;
import model.Coordinates;

/**
 * - генерация погоды (4 типа)
 * - возвращает тип погоды
 * - enum для погоды - генерируем id погоды и вовращает имя из enum
 */

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather() {
        this.conditionChanged();
    }

}
