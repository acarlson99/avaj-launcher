package acarlson.avaj;

import acarlson.avaj.flyables.Flyable;
import acarlson.avaj.loggers.Logger;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Bad number of args");
            System.exit(1);
        }
        WeatherTower tower = new WeatherTower();
        Input inp = null;
        try {
            inp = Input.parseInput(args[0]);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + args[0]);
            System.exit(1);
        }

        if (inp == null) {
            System.exit(1);
        }
        for (Flyable f : inp.getFlyables()) {
            f.registerTower(tower);
            tower.register(f);
        }

        for (int ii = 0; ii < inp.getIters(); ii++) {
            tower.changeWeather();
//            System.out.println(ii);
        }

        Logger.writer.flush();
    }
}
