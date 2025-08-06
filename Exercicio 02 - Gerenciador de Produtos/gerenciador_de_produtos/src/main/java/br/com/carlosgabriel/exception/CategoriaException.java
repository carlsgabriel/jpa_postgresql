package br.com.carlosgabriel.exception;

public class CategoriaException extends RuntimeException {
    public static final Long serialVersionUID = 1L;

    public CategoriaException(String msg){
        super(msg);
    }
}
