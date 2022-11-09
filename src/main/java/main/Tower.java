package main;

import repository.Flyable;

import java.util.ArrayList;
import java.util.List;

/**
 * - башня хранит список летательных аппаратов
 * - печатает сообщения при регистрации и снятии с регистрации летательных аппаратов
 */

public class Tower {

    private final List<Flyable> flyable = new ArrayList<>();

    public void register(Flyable newFlyable) {
        if (!flyable.contains(newFlyable)) {
            flyable.add(newFlyable);
        }
    }

    public void print() {
        for (int i = 0; i < flyable.size(); i++) {
            System.out.println(flyable.get(i));
        }
    }

    public void unregister(Flyable oldFlyable) {
        flyable.remove(oldFlyable);
    }

    protected void conditionChanged() {
        for (int i = 0; i < flyable.size(); i++) {
            flyable.get(i).updateConditions();
        }
    }

}
