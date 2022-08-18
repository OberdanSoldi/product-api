package com.github.oberdansoldi.productapi.exceptions;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Bad Request")
public class ServiceErrorException extends RuntimeException{
    public ServiceErrorException(String msg) {
        super(msg);
    }
}
