package com.moon.shoppingmall.item;

/**
 * @author 문지현
 * @version 1.0
 * @since 2022-12-09
 */
public interface DiscountCondition {

    boolean isSatisfiedBy(Cart cart);
}
