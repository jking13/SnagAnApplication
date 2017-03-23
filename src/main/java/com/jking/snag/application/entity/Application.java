package com.jking.snag.application.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 3/23/17.
 */
@Data
@Document(indexName="foo")
public class Application {
    String id;
    String name;
    List<Question> questions = new ArrayList<>();
}
