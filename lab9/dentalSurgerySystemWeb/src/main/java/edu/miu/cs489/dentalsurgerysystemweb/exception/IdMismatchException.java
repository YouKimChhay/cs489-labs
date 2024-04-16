package edu.miu.cs489.dentalsurgerysystemweb.exception;

public class IdMismatchException extends Exception {
    private String message;
    public IdMismatchException(String message) {
        super(message);
    }
}
