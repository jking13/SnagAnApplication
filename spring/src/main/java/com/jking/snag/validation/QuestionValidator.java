package com.jking.snag.validation;

import com.jking.snag.question.entity.Question;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Created by john on 3/25/17.
 */
@Component
public class QuestionValidator extends Validator<Question>{
    @Override
    public Boolean validate(Question question) {
        validateString(question.getQuestion(), "question is required");
        validateString(question.getAnswer(), "answer is required");
        return true;
    }
}
