package net.trapezokomos.dashboard.exception;

public class GenericException extends Exception {
    public GenericException() {
        super("Resource already exists");
    }
}
