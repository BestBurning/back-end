package com.diyishuai.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.di1shuai.mybatisplus.dao.StudentDao;
import com.di1shuai.mybatisplus.domain.Student;
import com.diyishuai.mybatisplus.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * @author: Bruce
 * @date: 2020/2/20
 * @description:
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao,Student> implements StudentService {


}
