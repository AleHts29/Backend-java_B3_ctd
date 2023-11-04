package com.example.c41.exception;

public class BadRequestException extends Exception {
    public BadRequestException(String mensaje){
        super(mensaje);
    }
}
