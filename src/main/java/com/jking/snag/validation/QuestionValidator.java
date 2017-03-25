package com.jking.snag.validation;

import com.jking.snag.question.entity.Question;
import org.apache.commons.lang.StringUtils;

/**
 * Created by john on 3/25/17.
 */
public class QuestionValidator extends Validator<Question>{
    @Override
    public void validate(Question question) {
        validateString(question.getQuestion(), "question is required");
        validateString(question.getAnswer(), "answer is required");
    }
}
