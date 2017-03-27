package com.jking.snag.repository.elasticsearch;

import com.jking.snag.question.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

/**
 * Created by john on 3/25/17.
 */
@Component
public interface QuestionRepository extends PagingAndSortingRepository<Question, String> {

    @Query("{\"query\": {\"match\": {\"_all\": \"?0\"}}}")
    public Page<Question> query(String query, Pageable page);
}
