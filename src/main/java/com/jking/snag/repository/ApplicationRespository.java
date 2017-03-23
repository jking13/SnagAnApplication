package com.jking.snag.repository;

import com.jking.snag.application.entity.Application;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

/**
 * Created by john on 3/23/17.
 */
@Component
public interface ApplicationRespository extends PagingAndSortingRepository<Application, String> {
}
