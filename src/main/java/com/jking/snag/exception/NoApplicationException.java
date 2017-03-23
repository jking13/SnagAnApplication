package com.jking.snag.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author john.king
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such application")
public class NoApplicationException extends RuntimeException{

    public NoApplicationException() {
    }

    public NoApplicationException(String message) {
        super(message);
    }

    public NoApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoApplicationException(Throwable cause) {
        super(cause);
    }

    public NoApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
   

}
