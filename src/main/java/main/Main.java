package main;

import model.*;
import repository.Flyable;

import java.util.ArrayList;
import java.util.List;


public class Main {
    private static List<Flyable> flyableList = new ArrayList<>();

    public static void main(String[] args) {
        ParseFile parseFile = new ParseFile();
        parseFile.isEmptyFile(args[0]);
        parseFile.wrongNumberAndTypeParameters(args[0]);

        String[] res = parseFile.readFile(args[0]);


        parseFile.checkFirstLineToFile(res[0]);
        List<Simulation> simulationList =  parseFile.splitFileToMass(res);

        CreateFlyable createFlyable = new CreateFlyable();
        flyableList = createFlyable.createFlyable(simulationList);

        int iteration = Integer.parseInt(res[0]);
        IterationFlyable iterationFlyable = new IterationFlyable(flyableList, iteration);
        iterationFlyable.registerTower();
        iterationFlyable.changeWeather();
    }
}
