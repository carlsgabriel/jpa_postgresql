package br.com.carlosgabriel.exception;

public class TelefoneException extends RuntimeException {
    private static final Long serialVersionUID = 1L;

    public TelefoneException(String msg) {
        super(msg);
    }
}
