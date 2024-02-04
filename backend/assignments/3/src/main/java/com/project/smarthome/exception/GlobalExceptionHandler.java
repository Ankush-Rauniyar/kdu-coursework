package com.project.smarthome.exception;

import com.project.smarthome.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {ErrorWhileExecutingQuery.class})
    public ResponseEntity<ErrorDto> handleCustomException(ErrorWhileExecutingQuery ex){
        ErrorDto error = new ErrorDto(ex.getMessage() + "--error while running query", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(value = {AdminNotFoundException.class})
    public ResponseEntity<ErrorDto> adminNotFound(AdminNotFoundException ex){
        ErrorDto error = new ErrorDto(ex.getMessage() + "--error while running query", HttpStatus.UNAUTHORIZED.value());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<ErrorDto> userNotFoundHandler(UserNotFoundException ex){
        ErrorDto error = new ErrorDto(ex.getMessage() + "--error while running query", HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = {InvalidOwnerHouseException.class})
    public ResponseEntity<ErrorDto> invalidOwner(InvalidOwnerHouseException ex){
        ErrorDto error = new ErrorDto(ex.getMessage() + "--error while running query", HttpStatus.UNAUTHORIZED.value());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = {DeviceNotRegisteredException.class})
    public ResponseEntity<ErrorDto> deviceNotRegistered(DeviceNotRegisteredException ex){
        ErrorDto error = new ErrorDto(ex.getMessage() + "--error while running query", HttpStatus.OK.value());
        return new ResponseEntity<>(error, HttpStatus.OK);
    }

    @ExceptionHandler(value = {HouseNotFoundException.class})
    public ResponseEntity<ErrorDto> deviceNotRegistered(HouseNotFoundException ex){
        ErrorDto error = new ErrorDto(ex.getMessage() + "--error while running query", HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {DeviceCantBeRegisteredException.class})
    public ResponseEntity<ErrorDto> deviceNotRegistered(DeviceCantBeRegisteredException ex){
        ErrorDto error = new ErrorDto(ex.getMessage() + "--error while running query", HttpStatus.UNAUTHORIZED.value());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorDto> AllKindOfExceptions(Exception ex){
        ErrorDto error = new ErrorDto(ex.getMessage() + "Exception Unknown", HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}