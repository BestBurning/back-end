package com.di1shuai;

import com.di1shuai.mine.AbstractActionCallBack;
import com.di1shuai.mine.BaseResult;
import com.di1shuai.mine.Context;

/**
 * @author shea
 * @since 2022/11/1
 */
class StudentAction extends AbstractActionCallBack {

    @Override
    public void paramValidate(Context context) {
    }

    @Override
    public void bizValidate(Context context) {

    }

    @Override
    public void process(Context context) {

    }

    @Override
    public BaseResult assemble(Context context) {
        BaseResult<Object> objectBaseResult = new BaseResult<>();
        return objectBaseResult;
    }
}
