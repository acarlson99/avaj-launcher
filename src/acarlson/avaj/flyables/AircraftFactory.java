package acarlson.avaj.flyables;

import acarlson.avaj.exceptions.NoSuchAircraftException;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws NoSuchAircraftException {
        switch (type) {
            case "Helicopter":
                return new Helicopter(name, new Coordinates(longitude, latitude, height));
            case "Baloon":
                return new Baloon(name, new Coordinates(longitude, latitude, height));
            case "JetPlane":
                return new JetPlane(name, new Coordinates(longitude, latitude, height));
        }
        throw new NoSuchAircraftException(type);
//        return new Helicopter("BAD", new Coordinates(0,0,0));
    }
}
