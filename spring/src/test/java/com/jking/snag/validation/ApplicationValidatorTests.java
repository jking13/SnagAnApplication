package com.jking.snag.validation;


import com.jking.snag.application.entity.Application;
import com.jking.snag.exception.ValidationException;
import com.jking.snag.question.QuestionService;
import com.jking.snag.question.entity.Question;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

/**
 * Created by john on 3/25/17.
 */
public class ApplicationValidatorTests {

    @InjectMocks
    ApplicationValidator validator;

    @Mock
    QuestionService questionService;

    @BeforeClass
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeMethod
    public void setMockValues() {
        reset(questionService);
        when(questionService.getQuestions()).thenReturn(storedQuestions());
    }

    @Test(expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = "applicant name is required")
    public void testNoName() {
        //given
        Application application = new Application();
        //when
        validator.validate(application);
        //then
        //throws validation exception
    }

    @Test(expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = "application doesn't correctly answer all questions")
    public void testNoQuestions() {
        //given
        Application application = new Application()
                .withName("name");
        //when
        validator.validate(application);
        //then
        //throws validation exception
    }

    @Test(expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = "question id is required")
    public void testQuestionWithNoId() {
        //given
        Application application = new Application()
                .withName("name")
                .withQuestions(Arrays.asList(new Question()
                        .withAnswer("answer1")));
        //when
        validator.validate(application);
        //then
        //throws validation exception
    }

    @Test(expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = "submitted question is missing an answer")
    public void testQuestionWithNoAnswer() {
        //given
        Application application = new Application()
                .withName("name")
                .withQuestions(Arrays.asList(new Question()
                        .withId("id1")));
        //when
        validator.validate(application);
        //then
        //throws validation exception
    }

    @Test(expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = "application doesn't correctly answer all questions")
    public void testMissingQuestion() {
        //given
        Application application = new Application()
                .withName("name")
                .withQuestions(Arrays.asList(new Question()
                        .withId("id1")
                        .withAnswer("answer1")));
        //when
        validator.validate(application);
        //then
        //throws validation exception
    }

    @Test(expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = "application doesn't correctly answer all questions")
    public void testWrongIds() {
        //given
        Application application = new Application()
                .withName("name")
                .withQuestions(Arrays.asList(new Question()
                                .withId("wrong")
                                .withAnswer("answer1"),
                        new Question()
                                .withId("wrong")
                                .withAnswer("answer2")));
        //when
        validator.validate(application);
        //then
        //throws validation exception
    }

    @Test(expectedExceptions = ValidationException.class,
            expectedExceptionsMessageRegExp = "application doesn't correctly answer all questions")
    public void testWrongAnswers() {
        //given
        Application application = new Application()
                .withName("name")
                .withQuestions(Arrays.asList(new Question()
                                .withId("id1")
                                .withAnswer("wrong"),
                        new Question()
                                .withId("id2")
                                .withAnswer("wrong")));
        //when
        validator.validate(application);
        //then
        //throws validation exception
    }

    @Test
    public void testValid() {
        //given
        Application application = new Application()
                .withName("name")
                .withQuestions(Arrays.asList(new Question()
                                .withId("id1")
                                .withAnswer("answer1"),
                        new Question()
                                .withId("id2")
                                .withAnswer("answer2")));
        //when
        validator.validate(application);
        //then
        //exception isn't thrown
    }

    private List<Question> storedQuestions() {
        return Arrays.asList(new Question()
                        .withId("id1")
                        .withQuestion("question1")
                        .withAnswer("answer1"),
                new Question()
                        .withId("id2")
                        .withQuestion("question2")
                        .withAnswer("answer2"));
    }
}
