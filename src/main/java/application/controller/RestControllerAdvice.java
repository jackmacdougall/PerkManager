package application.controller;

import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestControllerAdvice {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Error> handleNotFound(NotFoundException nfe) {
        Error error = new Error();
        return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
    }
}
