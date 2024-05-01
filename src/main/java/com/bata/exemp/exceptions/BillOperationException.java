package com.bata.exemp.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BillOperationException extends Exception{
    HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

    public BillOperationException(){
        super();
    }

    public BillOperationException(String message){
        super(message);
    }

    public BillOperationException(Throwable erro){
        super(erro);
    }

    public BillOperationException(String message, Throwable erro){
        super(message, erro);
    }

}
