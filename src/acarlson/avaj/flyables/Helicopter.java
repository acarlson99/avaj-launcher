package acarlson.avaj.flyables;

import acarlson.avaj.WeatherTower;
import acarlson.avaj.loggers.Logger;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    private String weatherMsg(String condition) {
        return condition;
    }

    public void updateConditions() {
        String condition = weatherTower.getWeather(coordinates);
        Logger.writer.println(this.toString() + ": " + weatherMsg(condition) + ".");
        int longitude = coordinates.getLongitude();
        int latitude = coordinates.getLatitude();
        int height = coordinates.getHeight();
        switch (condition) {
            case "RAIN":
                latitude += 5;
                break;
            case "FOG":
                latitude += 1;
                break;
            case "SUN":
                latitude += 10;
                height += 2;
                break;
            case "SNOW":
                height -= 7;
                break;
        }
        this.coordinates = new Coordinates(latitude, longitude, Math.min(Math.max(height, 0), 100));
        if (height <= 0) {
            Logger.writer.println(this + " landing at " + coordinates + ".");
            weatherTower.unregister(this);
        }
    }

    public boolean isLanded() {
        return landed;
    }

    public void registerTower(WeatherTower tower) {
        this.weatherTower = tower;
    }

    public String toString() {
        return "Helicopter#" + name + "(" + id + ")";
    }
}
