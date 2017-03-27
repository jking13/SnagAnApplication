package com.jking.snag.validation;

import com.jking.snag.exception.ValidationException;
import org.apache.commons.lang.StringUtils;


/**
 * Created by john on 3/25/17.
 */
public abstract class Validator<T> {
    abstract Boolean validate(T t);

    void validateString(String str, String message){
        if(StringUtils.isEmpty(str))
            throw new ValidationException(message);
    }
}
