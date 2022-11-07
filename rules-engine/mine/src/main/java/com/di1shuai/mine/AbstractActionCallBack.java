package com.di1shuai.mine;


/**
 * @Description: 流程引擎-抽象执行事件接口
 * @author: orangeCs
 * @create: 2020-08-22
 */
public abstract class AbstractActionCallBack<T extends BaseResult,C extends Context> implements ActionCallBack<T,C>{

    @Override
    public void beforeProcess(C context) {

    }

    @Override
    public void afterProcess(C context) {

    }
}
