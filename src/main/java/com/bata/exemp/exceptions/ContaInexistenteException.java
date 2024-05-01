package com.bata.exemp.exceptions;

public class ContaInexistenteException extends RuntimeException{

    public ContaInexistenteException(){
        super();
    }

    public ContaInexistenteException(String message){
        super(message);
    }

    public ContaInexistenteException(Throwable causa){
        super(causa);
    }

    public ContaInexistenteException(String message, Throwable causa){
        super(message, causa);
    }

}
