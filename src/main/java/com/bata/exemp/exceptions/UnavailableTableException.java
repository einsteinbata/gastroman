package com.bata.exemp.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UnavailableTableException extends Exception{
    HttpStatus status = HttpStatus.BAD_REQUEST;

    private static final String MESSAGE = "The Table Is Not Available";
    private int table;
    public UnavailableTableException(){
        super(MESSAGE);
    }

    public UnavailableTableException(int table){
        super("Table " + table + " is not available");
        this.table = table;
    }
}
