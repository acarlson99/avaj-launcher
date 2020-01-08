package acarlson.avaj;

import acarlson.avaj.flyables.Coordinates;

public class WeatherProvider {
    static private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
    static private WeatherProvider weatherProvider;

    private WeatherProvider() {}

    static public WeatherProvider getProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
//        return "SNOW";
        return weather[coordinates.hashCode() % weather.length];
    }
}
