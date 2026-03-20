package com.vinicius.bffagendadortarefas.infrastructure.exception;

import javax.naming.AuthenticationException;

public class UnauthorizedException extends AuthenticationException {
    public UnauthorizedException(String message, Throwable throwable) {
        super(message);
    }

    public UnauthorizedException(String message) {
        super(message);
    }
}
