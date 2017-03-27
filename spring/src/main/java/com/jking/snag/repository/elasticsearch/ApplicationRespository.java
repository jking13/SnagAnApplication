package com.jking.snag.repository.elasticsearch;

import com.jking.snag.application.entity.Application;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

/**
 * Created by john on 3/23/17.
 */
@Component
public interface ApplicationRespository extends PagingAndSortingRepository<Application, String> {

    @Query("{\"query\": {\"match\": {\"_all\": \"?0\"}}}")
    public Page<Application> query(String query, Pageable page);

}
