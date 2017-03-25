package com.jking.snag.controller;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

/**
 * Created by john on 3/25/17.
 */
@Data
public class PageWrapper{
    Page page;

    //The AggregatedPageImpl returned from the elasticsearch repo can blow up when serialized due to
    //getFacets() throwing an npe when the page is empty
    public PageWrapper(Page page) {
        this.page = new PageImpl(page.getContent(),
                new PageRequest(page.getNumber(), page.getSize()),
                page.getTotalElements());
    }
}