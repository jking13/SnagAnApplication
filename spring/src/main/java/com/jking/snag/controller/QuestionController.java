package com.jking.snag.controller;

import com.jking.snag.controller.util.PageWrapper;
import com.jking.snag.controller.util.RestPage;
import com.jking.snag.question.entity.Question;
import com.jking.snag.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by john on 3/25/17.
 */
@Controller
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        return new ResponseEntity<>( questionService.createQuestion(question), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question) {
        return new ResponseEntity<>( questionService.updateQuestion(question), HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{questionId}")
    public ResponseEntity<Question> getQuestion(@PathVariable String questionId) {
        return new ResponseEntity<>( questionService.getQuestion(questionId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/list")
    public ResponseEntity<PageWrapper> getQuestions(@RequestBody RestPage page) {
        return new ResponseEntity<>( new PageWrapper(questionService.getQuestions(page.toPage())), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value  = "/{questionId}")
    public ResponseEntity deleteQuestion(@PathVariable String questionId) {
        questionService.deleteQuestion(questionId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
