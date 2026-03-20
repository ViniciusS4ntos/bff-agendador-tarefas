package com.vinicius.bffagendadortarefas.infrastructure.exception;

public class InvalidCepException extends RuntimeException{
    public InvalidCepException(String message){super(message);}
    public InvalidCepException(String message, Throwable throwable){super(message,throwable);}
}
