package acarlson.avaj.flyables;

import java.util.Objects;

public class Coordinates {

    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int lat, int height) {
        this.longitude = longitude;
        this.latitude = lat;
        this.height = height;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    public int getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return longitude == that.longitude &&
                latitude == that.latitude &&
                height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(longitude, latitude, height);
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                ", height=" + height +
                '}';
    }
}
