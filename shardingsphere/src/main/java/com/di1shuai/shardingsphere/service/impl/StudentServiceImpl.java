package com.di1shuai.shardingsphere.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.di1shuai.shardingsphere.dao.StudentDao;
import com.di1shuai.shardingsphere.domain.Student;
import com.di1shuai.shardingsphere.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * @author: Bruce
 * @date: 2020/2/20
 * @description:
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements StudentService {


}