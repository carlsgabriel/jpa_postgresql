package br.com.carlosgabriel.exception;

public class ProdutoException extends RuntimeException {
    public static final Long serialVersionUID = 1L;

    public ProdutoException(String msg){
        super(msg);
    }
}
