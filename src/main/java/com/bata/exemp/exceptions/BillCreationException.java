package com.bata.exemp.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BillCreationException extends Exception{
    HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
    public BillCreationException(){
        super();
    }

    public BillCreationException(String message){
        super(message);
    }

    public BillCreationException(Throwable erro){
        super(erro);
    }

    public BillCreationException(String message, Throwable erro){
        super(message, erro);
    }

}
