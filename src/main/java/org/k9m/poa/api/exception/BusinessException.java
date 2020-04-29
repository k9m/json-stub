package org.k9m.poa.api.exception;

import org.k9m.poa.config.exception.ApplicationException;
import org.springframework.http.HttpStatus;

public class BusinessException extends ApplicationException {
    public BusinessException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
