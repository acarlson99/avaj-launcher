package acarlson.avaj.flyables;

import acarlson.avaj.WeatherTower;

public interface Flyable {
    void updateConditions();

    void registerTower(WeatherTower tower);

    boolean isLanded();
}
