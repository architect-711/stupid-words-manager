package edu.architect_711.adviser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Reader {
    private final File file;

    private final static Scanner scanner = new Scanner(System.in);
    private final static Integer PAGE_CAPACITY = 40;
    private final static Random random = new Random();

    public Reader(File file) {
        this.file = file;
    }

    public void read() {
        System.out.print("Page number : ");
        final int pageNumber = scanner.nextInt();

        if (pageNumber < 0)
            throw new IllegalArgumentException("-- kill yourself. Page number must be positive, douchebag.");

        try (final BufferedReader br = new BufferedReader(new FileReader(file))) {
            List<String> lines = br.lines().toList();

            int counter = 0;
            while (counter < pageNumber * PAGE_CAPACITY)
                ++counter;

            String[] expression;
            int timesLooped = 0, stem = counter;
            while (counter < lines.size()) {
                expression = lines.get(counter).split(",");
                System.out.print(expression[random.nextInt(2)]);

                if (timesLooped == 40 || counter + 1 >= lines.size())
                    counter = stem;

                ++timesLooped;
                counter++;

                scanner.nextLine();
            }

            System.out.println("There is no such page");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
