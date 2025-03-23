package edu.architect_711.adviser;

public enum Action {
    READ("read"),
    WRITE("write");

    private final String value;
    Action(String value) {
        this.value = value;
    }

    String getValue() {
        return value;
    }
}