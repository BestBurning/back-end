package com.di1shuai.mine;


/**
 * @Description: 流程引擎-执行事件接口
 * @author: orangeCs
 * @create: 2020-08-22
 */
public interface ActionCallBack<T extends BaseResult, C extends Context> {

    void paramValidate(C context);

    void bizValidate(C context);

    void beforeProcess(C context);

    void process(C context);

    void afterProcess(C context);

    T assemble(C context);
}
