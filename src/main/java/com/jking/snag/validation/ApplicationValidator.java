package com.jking.snag.validation;


import com.jking.snag.application.entity.Application;
import com.jking.snag.exception.ValidationException;
import com.jking.snag.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by john on 3/25/17.
 */
public class ApplicationValidator extends Validator<Application> {

    private final QuestionService questionService;

    @Autowired
    public ApplicationValidator(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public void validate(Application application) {
        validateString(application.getName(), "applicant name is required");
        application.getQuestions()
                .forEach(question -> {
                    validateString(question.getAnswer(), "submitted question is missing an answer");
                    validateString(question.getId(), "question id is required");
                });
        Boolean missingCorrectAnswer =
                questionService.getQuestions().stream().anyMatch(question ->
                        application.getQuestions().stream().noneMatch(applicationQuestion ->
                            applicationQuestion.getId().equals(question.getId())
                            && applicationQuestion.getAnswer().trim().equalsIgnoreCase(question.getAnswer())
                        )
                );
        if(missingCorrectAnswer){
            throw new ValidationException("application doesn't correctly answer all questions");
        }

    }
}
