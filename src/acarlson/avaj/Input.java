package acarlson.avaj;

import acarlson.avaj.exceptions.NoSuchAircraftException;
import acarlson.avaj.flyables.AircraftFactory;
import acarlson.avaj.flyables.Flyable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
    private List<Flyable> flyables;
    private int iters;

    public Input(List<Flyable> flyables, int iters) {
        this.flyables = flyables;
        this.iters = iters;
    }

    public List<Flyable> getFlyables() {
        return flyables;
    }

    public int getIters() {
        return iters;
    }

    static Input parseInput(String in) throws FileNotFoundException {
//        Flyable f = AircraftFactory.newAircraft("Helicopter", "H1", 1, 1, 1);
//        System.out.println(f);
        File file = new File(in);
        Scanner scanner = new Scanner(file);
        int iters = 0;
        List<Flyable> fs = new ArrayList<>();
        try {
            if (!scanner.hasNext())
                return null;
            String iterLine = scanner.nextLine();
            iters = Integer.parseInt(iterLine);
            while (scanner.hasNext()) {
                String[] spl = scanner.nextLine().split(" ");
                if (spl.length != 5) {
                    System.out.println("Invalid number of fields. Skipping");
                    continue;
                }
                try {
                    fs.add(AircraftFactory.newAircraft(spl[0], spl[1], Integer.parseInt(spl[2]), Integer.parseInt(spl[3]), Integer.parseInt(spl[4])));
                } catch (NoSuchAircraftException | NumberFormatException e) {
                    System.out.println(e + ": skipping");
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Bad number.  Exiting");
            return null;
        }
        return new Input(fs, iters);
    }
}
