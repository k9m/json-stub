package org.k9m.poa.api.exception;

import org.k9m.poa.config.exception.ApplicationException;
import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApplicationException {
    public ResourceNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
