package com.helper.testgenerator.controllers;

import com.helper.testgenerator.dao.ErrorResponseDAO;
import com.helper.testgenerator.exceptions.EnumNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GenericErrorController {

    @ExceptionHandler(EnumNotFoundException.class)
    public ResponseEntity<ErrorResponseDAO> handleEnumNotFoundException(EnumNotFoundException e) {
        return new ResponseEntity<>(
                ErrorResponseDAO.builder()
                        .message(e.getMessage())
                        .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .exceptionType(e.getClass().getSimpleName())
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
