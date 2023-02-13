package main;

import model.AircraftFactory;
import model.Simulation;
import repository.Flyable;

import java.util.ArrayList;
import java.util.List;

public class CreateFlyable {

    List<Flyable> flyableList = new ArrayList<>();

    public List<Flyable> createFlyable(List<Simulation> simulationList) {

        for (int i = 0; i < simulationList.size(); i++) {
            Flyable flyable = AircraftFactory.newAircraft(
                    simulationList.get(i).type(), simulationList.get(i).name(),
                    simulationList.get(i).longitude(), simulationList.get(i).latitude(),
                    simulationList.get(i).height()
            );
            flyableList.add(flyable);
        }

        return flyableList;
    }
}
