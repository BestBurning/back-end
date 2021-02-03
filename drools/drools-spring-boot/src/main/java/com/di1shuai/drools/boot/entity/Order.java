package com.di1shuai.drools.boot.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Shea
 * @date 2021-01-30
 * @description 订单规则满减模型
 * 1 不满100 原价
 * 2 满100 不满200   -20
 * 3 满200 不满400   -50
 * 4 满400          -120
 */
@Data
@Accessors(chain = true)
public class Order {

    /**
     * 原始价格
     */
    private double originalPrice;

    /**
     * 真实价格
     */
    private double realPrice;
}
