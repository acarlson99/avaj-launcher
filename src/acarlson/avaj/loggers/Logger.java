package acarlson.avaj.loggers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Logger {

    public static PrintWriter writer;

    static {
        try {
            writer = new PrintWriter(new File("simulation.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
