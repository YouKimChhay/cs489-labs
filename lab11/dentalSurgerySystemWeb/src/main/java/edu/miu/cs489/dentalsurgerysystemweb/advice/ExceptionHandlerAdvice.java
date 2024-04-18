package edu.miu.cs489.dentalsurgerysystemweb.advice;

import edu.miu.cs489.dentalsurgerysystemweb.dto.ErrorResponse;
import edu.miu.cs489.dentalsurgerysystemweb.exception.IdMismatchException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ErrorResponse handleEntityNotFoundException(EntityNotFoundException exception) {
        return new ErrorResponse(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IdMismatchException.class)
    public ErrorResponse handleIdMismatchException(IdMismatchException exception) {
        return new ErrorResponse(exception.getMessage());
    }
}
