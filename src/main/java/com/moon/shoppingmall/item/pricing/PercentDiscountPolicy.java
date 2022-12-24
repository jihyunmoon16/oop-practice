package com.moon.shoppingmall.item.pricing;

import com.moon.shoppingmall.item.Cart;
import com.moon.shoppingmall.item.DiscountCondition;
import com.moon.shoppingmall.item.DiscountPolicy;
import com.moon.shoppingmall.money.Money;

/**
 * @author 문지현
 * @version 1.0
 * @since 2022-12-09
 */
public class PercentDiscountPolicy extends DiscountPolicy {

    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Cart cart) { return cart.calculateTotalCostOfItemsInCart().times(percent);}
}
