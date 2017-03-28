package com.jking.snag.question;

import com.google.common.collect.Lists;
import com.jking.snag.exception.NoQuestionException;
import com.jking.snag.question.entity.Question;
import com.jking.snag.repository.elasticsearch.QuestionRepository;
import com.jking.snag.validation.QuestionValidator;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by john on 3/25/17.
 */
@Component
public class QuestionServiceBean implements QuestionService {

    private final QuestionRepository questionRepository;
    private final QuestionValidator validator;

    @Autowired
    public QuestionServiceBean(QuestionRepository questionRepository,
                               QuestionValidator validator) {
        this.questionRepository = questionRepository;
        this.validator = validator;
    }

    @Override
    public Question createQuestion(Question question) {
        if(validator.validate(question)){
            return questionRepository.save(question);
        }
        return question;
    }

    @Override
    public Question updateQuestion(Question question) {
        if(!questionRepository.exists(question.getId())){
            throw new NoQuestionException();
        }
        if(validator.validate(question)){
            return questionRepository.save(question);
        }
        return question;
    }

    @Override
    public Question getQuestion(String id) {
        Question q =  questionRepository.findOne(id);
        if(q == null){
            throw new NoQuestionException();
        }
        return q;
    }

    @Override
    public List<Question> getQuestions(List<String> ids) {
        return Lists.newArrayList(questionRepository.findAll(ids));
    }

    @Override
    public List<Question> getQuestions() {
        return Lists.newArrayList(questionRepository.findAll());
    }

    @Override
    public Page<Question> getQuestions(Pageable page, String query) {
        return StringUtils.isBlank(query)?
                questionRepository.findAll(page):
                questionRepository.query(query, page);
    }

    @Override
    public void deleteQuestion(String id) {
        questionRepository.delete(id);
    }
}
