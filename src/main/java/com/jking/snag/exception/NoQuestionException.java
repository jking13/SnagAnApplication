package com.jking.snag.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by john on 3/25/17.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such question")
public class NoQuestionException extends RuntimeException {
    public NoQuestionException() {
    }

    public NoQuestionException(String message) {
        super(message);
    }

    public NoQuestionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoQuestionException(Throwable cause) {
        super(cause);
    }
}
