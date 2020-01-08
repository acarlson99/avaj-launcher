package acarlson.avaj.exceptions;

public class NoSuchAircraftException extends Exception {
    private String type;

    public NoSuchAircraftException(String type) {
        this.type = type;
    }

    public String toString() {
        return "No such aircraft '" + type + "'";
    }
}
