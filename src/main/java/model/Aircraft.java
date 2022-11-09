package model;

/**
 * - хранит id и name летательного аппарата
 * - хранит сдвиги по координатным осям для каждого летательного аппарата в зависимости от погоды
 * - получает погоду от летательного аппарата (или от башни)
 * - меняет координаты летательных аппаратов в зависимости от полученной погоды
 */

public class Aircraft {

    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = this.nextId();
    }

    private long nextId() {
        return idCounter++;
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", idCounter=" + idCounter +
                '}';
    }

}
