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
    private Money amount;

    public TotalAmountCondition(Money amount) {
        this.amount = amount;
    }

    // 장바구니의 총 합이 입력금액이 보다 클경우 true 반환. 즉 입력금액이 장바구니 총 합보다 작아야함.
    // isLessThan 사용해야함
    public boolean isSatisfiedBy(Cart cart) {
        return amount.isLessThanOrEqual(cart.calculateTotalCostOfItemsInCart());
    }
}
