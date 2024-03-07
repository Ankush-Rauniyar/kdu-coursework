package com.handsonspring.homeworkeleven.exceptions;


import com.handsonspring.homeworkeleven.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {ErrorWhileExecutingQuery.class})
    public ResponseEntity<ErrorDto> handleCustomException(ErrorWhileExecutingQuery ex){
        ErrorDto error = new ErrorDto(ex.getMessage() + "error while running query", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorDto> AllKindOfExceptions(Exception ex){
        ErrorDto error = new ErrorDto(ex.getMessage() + " [Parent Exception]", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}