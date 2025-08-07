package br.com.carlosgabriel.exception;

public class PessoaException extends RuntimeException {
    private static final Long serialVersionUID = 1L;

    public PessoaException(String msg){
        super(msg);
    }
}
