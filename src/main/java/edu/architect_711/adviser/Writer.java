package edu.architect_711.adviser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.util.Scanner;

public class Writer {
    private final static Scanner scanner = new Scanner(System.in);

    private final Path filePath;

    public Writer(Path filePath) {
        this.filePath = filePath;
    }

    public void write() {
        String word, translation, formattedInput;
        int bytesWritten = 0, pairsNumber = 0;

        System.out.println("Write '--EX' to the word field to gracefully exit");
        try (final BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filePath.toUri()), true))) {
            for (;;) {
                System.out.print("Word: ");
                word = scanner.nextLine();

                if (word.equals("--EX")) {
                    System.out.printf("Bytes written: %d, word pairs: %d\n", bytesWritten, pairsNumber);
                    break;
                }

                System.out.print("Translation: ");
                translation = scanner.nextLine();

                formattedInput = String.format("%s,%s\n", word, translation);
                bw.write(formattedInput);

                bytesWritten += formattedInput.getBytes().length;
                ++pairsNumber;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
