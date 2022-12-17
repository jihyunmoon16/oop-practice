package com.moon.shoppingmall.item;

import com.moon.shoppingmall.money.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 문지현
 * @version 1.0
 * @since 2022-12-09
 */
public abstract class DiscountPolicy {

    // 할인 조건을 리스트로 받는다.
    private List<DiscountCondition> conditions = new ArrayList<>();

    // 생성자
    public DiscountPolicy(DiscountCondition ... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    // 할인 금액을 계산해서 반환한다.
    public Money calculateDiscountAmount(Cart cart) {
        for(DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(cart)) {
                return getDiscountAmount(cart);
            }
        }
        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Cart cart);
}
