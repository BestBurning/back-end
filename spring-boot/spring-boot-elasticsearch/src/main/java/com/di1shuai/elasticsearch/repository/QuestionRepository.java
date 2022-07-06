package com.di1shuai.elasticsearch.repository;

import com.di1shuai.elasticsearch.entity.Question;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Shea
 * @date: 2020/11/23
 * @description:
 */
@Repository
public interface QuestionRepository extends ElasticsearchRepository<Question, Long> {

    List<Question> findByQuestionLike(String keywords);

}
