package com.moon.shoppingmall.item.pricing;

import com.moon.shoppingmall.customers.Customer;
import com.moon.shoppingmall.customers.MembershipLevel;
import com.moon.shoppingmall.item.Cart;
import com.moon.shoppingmall.item.DiscountCondition;

/**
 * @author 문지현
 * @version 1.0
 * @since 2022-12-15
 */
public class MembershipLevelCondition implements DiscountCondition {
    private MembershipLevel membershipLevel;

    public MembershipLevelCondition(MembershipLevel membershipLevel) { this.membershipLevel = membershipLevel;}

    @Override
    public boolean isSatisfiedBy(Cart cart) { return cart.isMembershipLevelSatisfiedBy(membershipLevel); }
}
