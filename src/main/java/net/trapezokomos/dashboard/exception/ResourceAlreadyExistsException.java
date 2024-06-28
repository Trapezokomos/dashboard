package net.trapezokomos.dashboard.exception;

import java.io.Serial;

public class ResourceAlreadyExistsException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceAlreadyExistsException() {
        super("Resource already exists");
    }
}
