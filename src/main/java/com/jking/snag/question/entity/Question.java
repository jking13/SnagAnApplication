package com.jking.snag.question.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * Created by john on 3/23/17.
 */
@Data
@Wither
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Document(indexName="question", type = "question")
public class Question {
    @Id
    String id;
    @Field(type = FieldType.String)
    String question;
    @Field(type = FieldType.String)
    String answer;
}
