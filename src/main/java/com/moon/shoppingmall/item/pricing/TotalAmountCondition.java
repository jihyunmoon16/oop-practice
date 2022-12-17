package com.moon.shoppingmall.item.pricing;

import com.moon.shoppingmall.item.Cart;
import com.moon.shoppingmall.item.DiscountCondition;
import com.moon.shoppingmall.money.Money;

/**
 * @author 문지현
 * @version 1.0
 * @since 2022-12-15
 */
public class TotalAmountCondition implements DiscountCondition {
    private Money amountForFreeShipping;

    public TotalAmountCondition(Money amountForFreeShipping) {
        this.amountForFreeShipping = amountForFreeShipping;
    }

    public boolean isSatisfiedBy(Cart cart) {
        return amountForFreeShipping.isGreaterThanOrEqual(cart.calculateTotalCostOfItemsInCart());
    }

}
