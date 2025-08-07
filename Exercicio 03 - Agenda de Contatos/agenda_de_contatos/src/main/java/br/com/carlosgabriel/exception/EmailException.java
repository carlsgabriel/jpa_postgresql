package br.com.carlosgabriel.exception;

public class EmailException extends RuntimeException {
    private static final Long serialVersionUID = 1L;

    public EmailException(String msg) {
        super(msg);
    }
}
