package com.joaomasumoto.workshopmongo.resources.exception;


import com.joaomasumoto.workshopmongo.services.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Not found", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);

    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<StandardError> invalidParameter(
            IllegalArgumentException e,
            HttpServletRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;

        StandardError error = new StandardError(
                System.currentTimeMillis(),
                status.value(),
                "Invalid parameter",
                e.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(error);
    }

}
