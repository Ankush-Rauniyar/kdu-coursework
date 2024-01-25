package com.handson.springhandsonthree.exceptions;

import com.handson.springhandsonthree.dto.ErrorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(value = VehicleNotFoundException.class)
    public ResponseEntity<ErrorDto> handleException(VehicleNotFoundException vehicleNotFoundException){
        logger.error(vehicleNotFoundException.getMsg());
        ErrorDto errorDto = new ErrorDto(vehicleNotFoundException.getMsg(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorDto,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = BadOperationRequestException.class)
    public ResponseEntity<ErrorDto> handleBadRequestException(BadOperationRequestException badRequestException){
        logger.error("Bad request on operation : {}",badRequestException.getOperation());
        String msg = "There was error while doing " + badRequestException.getOperation();
        ErrorDto errorDto = new ErrorDto(msg,HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorDto,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorDto> handleGenericException(Exception e){
        logger.error("Runtime Exception encountered :{}",e.getMessage());
        ErrorDto errorDto = new ErrorDto("Unknown Runtime Exception",HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorDto,HttpStatus.BAD_REQUEST);
    }
}
