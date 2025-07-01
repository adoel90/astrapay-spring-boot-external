package com.astrapay.controller.advice;

import com.astrapay.exception.NoteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class ExampleAdvice {
    @ResponseStatus(HttpStatus.CONFLICT)  // 409
    @ExceptionHandler(Exception.class)
    public void handleConflict() {
        // Nothing to do
    }

    @ExceptionHandler(NoteException.class)
    public ResponseEntity<String> handleNoteNotFound(NoteException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}