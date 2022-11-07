package com.di1shuai.mine;


/**
 * @Description: 服务模板
 * @author: orangeCs
 * @create: 2020-08-22
 */
public class ServiceTemplateImpl implements ServiceTemplate{

    @Override
    public BaseResult invoke(Context context, AbstractActionCallBack action) {

            //参数校验
            paramValidate(context, action);
            //业务校验
            bizValidate(context, action);
            //事务执行前置扩展点
            beforeProcessCallBack(context, action);
            //事务执行
            processCallBack(context, action);
            //事务执行后置扩展点
            afterProcessCallBack(context, action);
            //数据装配
            return assemble(context, action);
        }

    private BaseResult assemble (Context context, AbstractActionCallBack action){
        System.out.println("assemble");
        return action.assemble(context);
    }

    private void afterProcessCallBack (Context context, AbstractActionCallBack action){
        System.out.println("afterProcessCallBack");
        action.afterProcess(context);
    }

    private void processCallBack (Context context, AbstractActionCallBack action){
        System.out.println("processCallBack");
        action.process(context);
    }

    private void beforeProcessCallBack (Context context, AbstractActionCallBack action){
        System.out.println("beforeProcessCallBack");
        action.beforeProcess(context);
    }

    private void bizValidate (Context context, AbstractActionCallBack action){
        System.out.println("bizValidate");
        action.bizValidate(context);
    }

    private void paramValidate (Context context, AbstractActionCallBack action){
        System.out.println("paramValidate");
        action.paramValidate(context);
    }
}
