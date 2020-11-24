package com.di1shuai.elasticsearch.controller;

import com.di1shuai.elasticsearch.entity.Question;
import com.di1shuai.elasticsearch.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Shea
 * @date: 2020/11/23
 * @description:
 */
@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionRepository questionRepository;

    @GetMapping("search/{keywords}")
    public List<Question> search(@PathVariable(name = "keywords") String keywords){
        return  questionRepository.findByQuestionLike(keywords);
    }

}
