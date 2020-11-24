package com.di1shuai.elasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author: Shea
 * @date: 2020/11/23
 * @description:
 */

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(indexName = "question")
public class Question {

    @Id
    private String id;

    @Field(type = FieldType.Text)
//            analyzer = "ik_max_word")
    private String question;

    @Field(type = FieldType.Text)
    private String answer;

}
