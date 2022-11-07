package com.di1shuai;


import com.di1shuai.mine.*;

/**
 * @Description: 测试服务模板流程引擎调用
 * @author: orangeCs
 * @create: 2020-08-22
 * <pre>
 *     查询学生为某某某的人
 *     paramValidate 学生id不能为空 且大于0
 *     bizValidate 学生姓名不能带“cute”
 *     process 查询db 得到结果
 * </pre>
 */
public class ServiceTemplateInvoke {
    public static void main(String[] args) {
        //构造上下文
        Context context = new Context();
        context.put(10);

        StudentAction studentAction = new StudentAction();

        ServiceTemplate serviceTemplate = new ServiceTemplateImpl();
        final BaseResult invoke = serviceTemplate.invoke(context, studentAction);
        System.out.println(invoke.getData());
    }
}
