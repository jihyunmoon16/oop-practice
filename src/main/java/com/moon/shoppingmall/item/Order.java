package com.moon.shoppingmall.item;

import com.moon.shoppingmall.customers.Customer;
import com.moon.shoppingmall.customers.MembershipLevel;
import com.moon.shoppingmall.money.Money;

/**
 * @author 문지현
 * @version 1.0
 * @since 2022-12-10
 */
public class Order {

    private Customer customer;

    private Money totalAmountOfItems;


    public Order(Customer customer, Money totalAmountOfItems) {
        this.customer = customer;
        this.totalAmountOfItems = totalAmountOfItems;
    }
}
