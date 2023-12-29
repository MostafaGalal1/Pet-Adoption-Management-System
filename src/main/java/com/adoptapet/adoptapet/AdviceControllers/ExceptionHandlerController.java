package com.adoptapet.adoptapet.AdviceControllers;

import com.adoptapet.adoptapet.Exceptions.DefaultException;
import com.adoptapet.adoptapet.Exceptions.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(DefaultException.class)
    public ResponseEntity<ErrorDetails> handleDefaultException(DefaultException e){
        return new ResponseEntity<>(e.getErrorDetails(), e.getErrorDetails().getStatus());
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorDetails> handleException(Exception e){
//        ErrorDetails errorDetails = ErrorDetails.builder()
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .message(e.getMessage())
//                .timestamp(new Date())
//                .build();
//        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
