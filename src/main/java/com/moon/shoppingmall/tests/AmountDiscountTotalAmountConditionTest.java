package com.moon.shoppingmall.tests;

import com.moon.shoppingmall.customers.Customer;
import com.moon.shoppingmall.customers.MembershipLevel;
import com.moon.shoppingmall.item.Cart;
import com.moon.shoppingmall.item.Item;
import com.moon.shoppingmall.item.pricing.AmountDiscountPolicy;
import com.moon.shoppingmall.item.pricing.TotalAmountCondition;
import com.moon.shoppingmall.money.Money;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

public class AmountDiscountTotalAmountConditionTest {

    private Customer c1;

    private Item i1;
    private Item i2;
    private Item i3;

    AmountDiscountPolicy discount10000won;

    private Cart cartC1;

    @Before
    public void setUp() {
        c1 = new Customer(1, "jane", "서울시 동작구", MembershipLevel.GOLD);

        i1 = new Item(1, "레드벨벳컵케익", Money.wons(5000));
        i2 = new Item(2, "레드벨벳라즈베리아이스크림케이크", Money.wons(50000));
        i3 = new Item(3, "더블쇼콜라아이스크림케이크", Money.wons(20000));

        discount10000won = new AmountDiscountPolicy(Money.wons(10000), new TotalAmountCondition(Money.wons(50000)));

        cartC1 = new Cart(c1, discount10000won);
    }

    @Test
    @DisplayName("총 금액이 미달일 경우 할인조건 테스트")
    public void testTotalAmountConditionBelow() {

        cartC1.addItem(i1);

        assertEquals(cartC1.calculateTotalCostOfItemsInCart(), Money.wons(5000));
        assertEquals(cartC1.calculateFinalCost(), Money.wons(5000));
    }

    @Test
    @DisplayName("총 금액이 만족할 경우 할인조건 테스트")
    public void testTotalAmountConditionAbove() {

        cartC1.addItem(i2);
        cartC1.addItem(i3);

        assertEquals(cartC1.calculateTotalCostOfItemsInCart(), Money.wons(70000));
        assertEquals(cartC1.calculateFinalCost(), Money.wons(60000));
    }

    @Test
    @DisplayName("총 금액이 동일할 경우 할인조건 테스트")
    public void testTotalAmountConditionExact() {
        cartC1.addItem(i2);

        assertEquals(cartC1.calculateTotalCostOfItemsInCart(), Money.wons(50000));
        assertEquals(cartC1.calculateFinalCost(), Money.wons(40000));
    }

}
