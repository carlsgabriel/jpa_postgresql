package br.com.carlosgabriel.exceptions;

public class TarefaException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public TarefaException(String msg) {
        super(msg);
    }
}
