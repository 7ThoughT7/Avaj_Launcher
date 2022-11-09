package main;

import model.*;
import repository.Flyable;

import java.util.ArrayList;
import java.util.List;


public class Main {
    private static WeatherTower weatherTower = new WeatherTower();
    private static Tower tower = new Tower();
    private static List<Flyable> flyableList = new ArrayList<>();

    public static void main(String[] args) {
        //создание летательных аппаратов
        Flyable flyable = AircraftFactory.newAircraft("Helicopter", "H1", 654, 33, 20);
        flyableList.add(flyable);
        Flyable flyable1 = AircraftFactory.newAircraft("Baloon", "B1", 2, 3, 20);
        flyableList.add(flyable1);
        Flyable flyable2 = AircraftFactory.newAircraft("JetPlane", "J1", 23, 44, 32);
        flyableList.add(flyable2);

        //проверка что созданные аппараты есть в списке + регистрация в башне
        for (int i = 0; i < flyableList.size(); i++) {
//            System.out.println(flyableList.get(i));
            flyableList.get(i).registerTower(weatherTower);
        }

            tower.print();

        int j = 0;
        while (j < 10) {
            weatherTower.changeWeather();
            j++;
        }

        for (int i = 0; i < flyableList.size(); i++) {
            tower.unregister(flyableList.get(i));
        }
    }
}
