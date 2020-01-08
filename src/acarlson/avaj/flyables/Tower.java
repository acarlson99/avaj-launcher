package acarlson.avaj.flyables;

import acarlson.avaj.loggers.Logger;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    List<Flyable> observers = new ArrayList<>();

    public void register(Flyable f) {
        this.observers.add(f);
        Logger.writer.println("Tower says: " + f + " registered to weather tower.");
    }

    public void unregister(Flyable f) {
        this.observers.remove(f);
        Logger.writer.println("Tower says: " + f + " unregistered from weather tower.");
    }

    protected void conditionsChanged() {
        List<Flyable> newList = new ArrayList<>(observers);
        for (Flyable observer : newList) {
            observer.updateConditions();
        }
    }
}
