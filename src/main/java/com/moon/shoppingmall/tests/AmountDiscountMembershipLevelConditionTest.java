package com.moon.shoppingmall.tests;

import com.moon.shoppingmall.customers.Customer;
import com.moon.shoppingmall.customers.MembershipLevel;
import com.moon.shoppingmall.item.Cart;
import com.moon.shoppingmall.item.Item;
import com.moon.shoppingmall.item.pricing.AmountDiscountPolicy;
import com.moon.shoppingmall.item.pricing.MembershipLevelCondition;
import com.moon.shoppingmall.money.Money;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

public class AmountDiscountMembershipLevelConditionTest {
    private Customer c1;
    private Customer c2;
    private Customer c3;

    private Item i1;
    private Item i2;
    private Item i3;

    private Cart cartC1;
    private Cart cartC2;
    private Cart cartC3;

    AmountDiscountPolicy discount10000won;



    @Before
    public void setUp() {
        c1 = new Customer(1, "jane", "서울시 동작구", MembershipLevel.SILVER);
        c2 = new Customer(2, "kevin", "서울시 강남구", MembershipLevel.GOLD);
        c3 = new Customer(3, "jack", "경기도 성남시", MembershipLevel.VIP);

        i1 = new Item(1, "레드벨벳컵케익", Money.wons(5000));
        i2 = new Item(2, "레드벨벳라즈베리아이스크림케이크", Money.wons(50000));
        i3 = new Item(3, "더블쇼콜라아이스크림케이크", Money.wons(20000));

    }
    // TODO 장바구니 총 가격이 할인 금액 이하일 경우.... 처리 방법... ????
    @Test
    @DisplayName("골드레벨 이상 가격할인 테스트")
    public void testMembershipLevelAboveGold() {
        discount10000won = new AmountDiscountPolicy(Money.wons(10000), new MembershipLevelCondition(MembershipLevel.GOLD));

        cartC1 = new Cart(c1, discount10000won);
        cartC2 = new Cart(c2, discount10000won);
        cartC3 = new Cart(c3, discount10000won);

        cartC1.addItem(i2);
        cartC2.addItem(i2);
        cartC3.addItem(i2);

        assertEquals(cartC1.calculateTotalCostOfItemsInCart(), Money.wons(50000));
        assertEquals(cartC1.calculateFinalCost(), Money.wons(50000));
        assertEquals(cartC2.calculateTotalCostOfItemsInCart(), Money.wons(50000));
        assertEquals(cartC2.calculateFinalCost(), Money.wons(40000));
        assertEquals(cartC3.calculateTotalCostOfItemsInCart(), Money.wons(50000));
        assertEquals(cartC3.calculateFinalCost(), Money.wons(40000));
    }

    @Test
    @DisplayName("VIP레벨 이상 가격할인 테스트")
    public void testMembershipLevelAboveVIP() {
        discount10000won = new AmountDiscountPolicy(Money.wons(10000), new MembershipLevelCondition(MembershipLevel.VIP));

        cartC1 = new Cart(c1, discount10000won);
        cartC2 = new Cart(c2, discount10000won);
        cartC3 = new Cart(c3, discount10000won);

        cartC1.addItem(i2);
        cartC2.addItem(i2);
        cartC3.addItem(i2);

        assertEquals(cartC1.calculateTotalCostOfItemsInCart(), Money.wons(50000));
        assertEquals(cartC1.calculateFinalCost(), Money.wons(50000));
        assertEquals(cartC2.calculateTotalCostOfItemsInCart(), Money.wons(50000));
        assertEquals(cartC2.calculateFinalCost(), Money.wons(50000));
        assertEquals(cartC3.calculateTotalCostOfItemsInCart(), Money.wons(50000));
        assertEquals(cartC3.calculateFinalCost(), Money.wons(40000));
    }
}
