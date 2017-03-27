package com.jking.snag.controller.util;

import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * Created by john on 3/25/17.
 */
//jackson needs a default constructor
@Data
public class QueryRequest {
    int page;
    int size;
    String query;

    public Pageable toPage(){
        return new PageRequest(page, size);
    }
}
