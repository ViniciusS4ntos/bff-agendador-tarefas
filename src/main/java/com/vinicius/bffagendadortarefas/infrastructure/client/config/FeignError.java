package com.vinicius.bffagendadortarefas.infrastructure.client.config;

import com.vinicius.bffagendadortarefas.infrastructure.exception.BusinessException;
import com.vinicius.bffagendadortarefas.infrastructure.exception.ConflictException;
import com.vinicius.bffagendadortarefas.infrastructure.exception.ResourceNotFoundException;
import com.vinicius.bffagendadortarefas.infrastructure.exception.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignError implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        switch (response.status()){
            case 409:
                return new ConflictException("Erro atributo  ja existente ");
            case 403:
                return new ResourceNotFoundException("Erro atributo nao encontrado ");
            case 401:
                return new UnauthorizedException("Erro usuario nao autorizado ");
            default:
                return new BusinessException("Erro de servidor ");
        }
    }
}
