package acarlson.avaj;

import acarlson.avaj.WeatherProvider;
import acarlson.avaj.flyables.Coordinates;
import acarlson.avaj.flyables.Tower;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates c) {
        return WeatherProvider.getProvider().getCurrentWeather(c);
    }

    void changeWeather() {
        super.conditionsChanged();
    }
}
