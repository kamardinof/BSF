package com.sfb.task.controllers;

import com.sfb.task.exceptions.AccountNotFound;
import com.sfb.task.exceptions.ApiException;
import com.sfb.task.exceptions.NotEnoughBalance;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ControllersAdvice {

    @ExceptionHandler(AccountNotFound.class)
    public ResponseEntity<Object> userExists(AccountNotFound exception){
        ApiException apiException = new ApiException(
                exception.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotEnoughBalance.class)
    public ResponseEntity<Object> userNotFound(NotEnoughBalance exception){
        ApiException apiException = new ApiException(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

}
