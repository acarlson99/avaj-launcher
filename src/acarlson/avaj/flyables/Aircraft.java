package acarlson.avaj.flyables;

public class Aircraft {
    static long idCounter = 1;
    long id;
    String name;
    Coordinates coordinates;
    boolean landed = false;

    Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }

    private long nextId() {
        return idCounter++;
    }
}
