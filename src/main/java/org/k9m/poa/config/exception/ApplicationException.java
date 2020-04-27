package org.k9m.poa.config.exception;

import lombok.Getter;
import org.k9m.poa.api.model.ErrorObjectDTO;
import org.springframework.http.HttpStatus;

public class ApplicationException extends RuntimeException {

    @Getter
    private HttpStatus statusCode;

    public ApplicationException(final HttpStatus statusCode, final String message){
        super(message);
        this.statusCode = statusCode;
    }

    public ErrorObjectDTO toError(){
        return new ErrorObjectDTO()
                .statusCode(statusCode.value())
                .message(getMessage());
    }

}
