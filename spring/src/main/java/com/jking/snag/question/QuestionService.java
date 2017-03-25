package com.jking.snag.question;

import com.jking.snag.question.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by john on 3/25/17.
 */
public interface QuestionService {
    public Question createQuestion(Question question);
    public Question updateQuestion(Question question);
    public Question getQuestion(String id);
    public List<Question> getQuestions(List<String> ids);
    public List<Question> getQuestions();
    public Page<Question> getQuestions(Pageable page);
    public void deleteQuestion(String id);
}
