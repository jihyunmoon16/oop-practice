package com.moon.shoppingmall;

import com.moon.shoppingmall.customers.Customer;
import com.moon.shoppingmall.customers.MembershipLevel;
import com.moon.shoppingmall.item.Cart;
import com.moon.shoppingmall.item.Item;
import com.moon.shoppingmall.item.pricing.AmountDiscountPolicy;
import com.moon.shoppingmall.item.pricing.MembershipLevelCondition;
import com.moon.shoppingmall.item.pricing.PercentDiscountPolicy;
import com.moon.shoppingmall.item.pricing.TotalAmountCondition;
import com.moon.shoppingmall.money.Money;

/**
 * @author 문지현
 * @version 1.0
 * @since 2022-11-22
 */
public class ShoppingmallTestDriver {

    public static void main(String[] args) {
        Customer jane = new Customer(1, "제인", "서울 강남", MembershipLevel.SILVER);
        Customer lisa = new Customer(2, "리사", "강원 원주", MembershipLevel.VIP);
        Customer jenny = new Customer(3, "제니", "경기도 수원", MembershipLevel.GOLD);

        Item iphone = new Item(1, "아이폰", Money.wons(1000000));
        Item galaxy = new Item(2, "갤럭시", Money.wons(1000000));
        Item motorola = new Item(3, "추억의 모토로라", Money.wons(200000));

        // 장바구니 총 금액이 5만원 이상이면 3000원 할인
        AmountDiscountPolicy freeShipping = new AmountDiscountPolicy(Money.wons(3000), new TotalAmountCondition(Money.wons(50000)));

        // 회원등급이 골드 이상이면 10프로 할인
        PercentDiscountPolicy goldMemberDiscount = new PercentDiscountPolicy(0.10, new MembershipLevelCondition(MembershipLevel.GOLD));

        Cart janeCart = new Cart(jane, freeShipping);
        Cart lisaCart = new Cart(lisa, goldMemberDiscount);
        Cart jennyCart = new Cart(jenny, freeShipping);

        janeCart.addItem(iphone);
        lisaCart.addItem(galaxy);
        lisaCart.addItem(motorola);
        jennyCart.addItem(iphone);

        janeCart.printListOfItemsInCart();
        lisaCart.printListOfItemsInCart();
        jennyCart.printListOfItemsInCart();

        System.out.println(janeCart.calculateTotalCostOfItemsInCart());
        System.out.println(lisaCart.calculateTotalCostOfItemsInCart());
        System.out.println(jennyCart.calculateTotalCostOfItemsInCart());

        System.out.println(janeCart.calculateFinalCost());
        System.out.println(lisaCart.calculateFinalCost());
        System.out.println(jennyCart.calculateFinalCost());
    }
}
