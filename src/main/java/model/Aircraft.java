package model;

/**
 * - хранит id и name летательного аппарата
 * - хранит сдвиги по координатным осям для каждого летательного аппарата в зависимости от погоды
 * - получает погоду от летательного аппарата (или от башни)
 * - меняет координаты летательных аппаратов в зависимости от полученной погоды
 */

public class Aircraft {

    public static class Coordinates {
        private static int longitude;
        private static int latitude;
        private static int height;

        public Coordinates(int longitude, int latitude, int height) {
            Coordinates.longitude = longitude;
            Coordinates.latitude = latitude;
            Coordinates.height = height;
            System.out.println(Coordinates.longitude + " " + Coordinates.latitude + " " + Coordinates.height);
        }

        public int getLongitude() {
            return longitude;
        }

        public int getLatitude() {
            return latitude;
        }

        public int getHeight() {
            return height;
        }
    }

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
