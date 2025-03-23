package edu.architect_711.adviser;

/*
* Task: write a program that will write only new english words to
* the .CSV file and ask these words randomly or with filters such
* pages (40 words) or by sections (each page contains 2 section by 20 words)
*
* The first argument <b>must</b> be the file to write location
* */

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new Adviser(args).start();
    }
}