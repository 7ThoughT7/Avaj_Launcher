package main;

import repository.Flyable;
import java.util.List;

public class IterationFlyable {

    private List<Flyable> flyables;
    private int iteration;

    private static WeatherTower weatherTower = new WeatherTower();
    private static Tower tower = new Tower();

    public IterationFlyable(List<Flyable> flyables, int iteration) {
        this.flyables = flyables;
        this.iteration = iteration;
    }

    public void registerTower() {
        for (int i = 0; i < flyables.size(); i++) {
            flyables.get(i).registerTower(weatherTower);

        }
    }

    public void changeWeather() {
        int j = 0;
        if (weatherTower.getFlyable() != null) {
            while (j < iteration) {
                System.out.println("ITERABLE: " + (j + 1));
                weatherTower.changeWeather();
                System.out.println();
                j++;
            }
        }
    }

}
