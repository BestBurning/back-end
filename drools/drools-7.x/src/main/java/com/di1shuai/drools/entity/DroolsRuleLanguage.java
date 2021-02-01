package com.di1shuai.drools.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author Shea
 * @date 2021-02-01
 * @description
 */
@Data
@Accessors(chain = true)
public class DroolsRuleLanguage {

    /**
     * contains | not contains语法结构
     *
     * Object(Field[Collection/Array] contains value)
     *
     * Object(Field[Collection/Array] not contains value)
     */
    private List<Integer> numList;

    /**
     * memberOf | not memberOf语法结构
     *
     * Object(field memberOf value[Collection/Array])
     *
     * Object(field not memberOf value[Collection/Array])
     */
    private int num;

    private String value;

    /**
     * matches | not matches语法结构
     *
     * Object(field matches "正则表达式")
     *
     * Object(field not matches "正则表达式")
     */
    private String matchStr;

    private boolean insertYes;

    private boolean updateYes;

    private boolean retractYes;

    private boolean enabledYes;

    private boolean noloopYes;

    private boolean activationGroupYes;

    private boolean agendaGroupYes;
}
