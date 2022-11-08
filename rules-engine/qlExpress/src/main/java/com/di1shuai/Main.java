package com.di1shuai;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;

public class Main {
    public static void main(String[] args) throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        context.put("a", 1);
        context.put("b", 2);
        context.put("c", 3);
        //下面五个参数意义分别是 表达式，上下文，errorList，是否缓存，是否输出日志
        Object result = runner.execute("a+b+c", context, null, true, false);
        System.out.println("a+b+c=" + result);
    }
}
