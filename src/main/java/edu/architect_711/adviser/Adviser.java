package edu.architect_711.adviser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Adviser {
    private final String[] args;

    public Adviser(final String[] args) {
        this.args = args;
    }

    public void start() throws IOException {
        if (args.length == 0)
            throw new IllegalArgumentException("-- kill yourself");

        final Action action = Action.valueOf(args[0].trim().toUpperCase());
        final boolean isFileExists = Files.exists(Path.of(args[1]));

        switch (action) {
            case READ -> {
                if (!isFileExists)
                    throw new IllegalArgumentException(
                            "-- kill yourself. Fucking stupid ass (you)! You asked me for reading from file, but I didn't find it.");
                new Reader(new File(Path.of(args[1]).toUri())).read();
            }
            case WRITE -> {
                final Path filePath = Path.of(args[1]);

                new Writer(!isFileExists ? Files.createFile(filePath) : filePath).write();
            }
        }
    }
}
