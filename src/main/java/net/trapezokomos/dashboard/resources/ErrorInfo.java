package net.trapezokomos.dashboard.resources;

public record ErrorInfo(ErrorMeta meta) {

    public static ErrorInfo createErrorResponse(String error) {
        return new ErrorInfo(new ErrorMeta(error));
    }
}