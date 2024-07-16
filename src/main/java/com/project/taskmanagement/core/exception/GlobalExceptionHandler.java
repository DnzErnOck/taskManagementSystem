package com.project.taskmanagement.core.exception;

import com.project.taskmanagement.core.exception.type.AlreadyExistsExceptionType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<Object> handleAlreadyExistsException(AlreadyExistsException ex) {
        AlreadyExistsExceptionType exceptionType = ex.getAlreadyExistsExceptionType();
        return new ResponseEntity<>(exceptionType.getMessage(), HttpStatus.CONFLICT);
    }

    // Diğer exception handler'lar buraya eklenebilir.
}
