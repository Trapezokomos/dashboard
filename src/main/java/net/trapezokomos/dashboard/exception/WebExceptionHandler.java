package net.trapezokomos.dashboard.exception;

import lombok.extern.slf4j.Slf4j;
import net.trapezokomos.dashboard.resources.ErrorInfo;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class WebExceptionHandler {

    @ExceptionHandler({ ResourceNotFoundException.class, BadRequestException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorInfo handleNotFound(Exception e) {
        log.warn(e.getMessage());
        return ErrorInfo.createErrorResponse(e.getMessage());
    }

    @ExceptionHandler({ResourceAlreadyExistsException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorInfo handleConflict(Exception e) {
        log.warn(e.getMessage());
        return ErrorInfo.createErrorResponse(e.getMessage());
    }
}
