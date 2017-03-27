package com.jking.snag.validation;


import com.jking.snag.application.entity.Application;
import com.jking.snag.exception.ValidationException;
import com.jking.snag.question.QuestionService;
import com.jking.snag.question.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by john on 3/25/17.
 */
@Component
public class ApplicationValidator extends Validator<Application> {

    private final QuestionService questionService;

    @Autowired
    public ApplicationValidator(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Boolean validate(Application application) {
        validateString(application.getName(), "applicant name is required");
        application.getQuestions()
                .forEach(question -> {
                    validateString(question.getAnswer(), "submitted question is missing an answer");
                    validateString(question.getId(), "question id is required");
                });
        Boolean missingCorrectAnswer =
                questionService.getQuestions().stream().anyMatch(question -> {
                    Optional<Question> applicationQuestionOpt = application.getQuestions()
                            .stream()
                            .filter(applicationQuestion ->
                                    applicationQuestion.getId().equals(question.getId())
                                            && applicationQuestion.getAnswer().trim().equalsIgnoreCase(question.getAnswer())
                            ).findAny();
                    applicationQuestionOpt.ifPresent(applicationQuestion -> applicationQuestion.setQuestion(question.getQuestion()));
                    return !applicationQuestionOpt.isPresent();
                });
        return !missingCorrectAnswer;

    }
}
