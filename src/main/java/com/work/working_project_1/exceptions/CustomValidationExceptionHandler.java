package com.work.working_project_1.exceptions;

import com.work.working_project_1.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.hibernate.exception.ConstraintViolationException;

@RestControllerAdvice
public class CustomValidationExceptionHandler
{
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity toResponseValid(CustomValidationException ex)
    {
        ErrorMessage errorMessage = new
                ErrorMessage(400,ex.getLocalizedMessage(),"Check fields");
        return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity toResponseMethod(CustomValidationException ex)
    {
        ErrorMessage errorMessage = new
                ErrorMessage(400,ex.getLocalizedMessage(),"Check fields");
        return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.BAD_REQUEST);
    }
}
