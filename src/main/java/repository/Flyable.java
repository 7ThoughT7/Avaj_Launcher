package repository;

import main.WeatherTower;
import model.Coordinates;

public interface Flyable {

    Coordinates getCoordinates();
    void updateConditions();
    void registerTower(WeatherTower weatherTower);

}
