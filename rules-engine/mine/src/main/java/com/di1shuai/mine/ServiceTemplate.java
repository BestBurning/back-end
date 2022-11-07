package com.di1shuai.mine;


/**
 * @Description:
 * @author: orangeCs
 * @create: 2020-08-22
 */
public interface ServiceTemplate<T extends BaseResult,C extends Context> {

    /**
     * @param context
     * @param action
     * @return
     */
    T invoke(C context, AbstractActionCallBack<T, C> action);
}
