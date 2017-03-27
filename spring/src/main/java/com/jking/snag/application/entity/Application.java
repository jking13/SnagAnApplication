package com.jking.snag.application.entity;

import com.jking.snag.question.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 3/23/17.
 */
@Data
@Wither
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Document(indexName="application", type = "application")
public class Application {
    @Id
    String id;
    @Field(type = FieldType.String)
    String name;
    @Field(type = FieldType.Nested)
    List<Question> questions = new ArrayList<>();
}
