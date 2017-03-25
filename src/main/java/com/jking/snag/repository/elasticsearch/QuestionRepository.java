package com.jking.snag.repository.elasticsearch;

import com.jking.snag.question.entity.Question;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

/**
 * Created by john on 3/25/17.
 */
@Component
public interface QuestionRepository extends PagingAndSortingRepository<Question, String> {
}
