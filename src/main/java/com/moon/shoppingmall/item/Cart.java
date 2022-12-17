package com.moon.shoppingmall.item;

import com.moon.shoppingmall.money.Money;
import com.moon.shoppingmall.customers.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 문지현
 * @version 1.0
 * @since 2022-11-22
 */

// cart의 역할을 screening 처럼 제일 정보를 많이 알고 있기 때문에 order를 여기서 생성하게 함
public class Cart {
    private Customer customer;
    private List<Item> itemList;

    private Money totalAmount = Money.ZERO;

    public Cart() {}

    public Cart(Customer customer) {
        this.customer = customer;
        this.itemList = new ArrayList<>();
    }


    // 장바구니에 있는 아이템의 총 가격 계산
    public Money calculateTotalCostOfItemsInCart() {

        for (Item item : this.itemList) {
            totalAmount = totalAmount.plus(item.getItemPrice());
        }
        return totalAmount;
    }


    // 장바구니에 아이템 넣기
    public void addItem(Item item){
        this.itemList.add(item);
    }

    // 장바구니의 소유자 정하기
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    // 장바구니 고객정보 가져오기
    public Customer getCustomer() {
        return customer;
    }

    public boolean isEligibleForFreeShipping() {
        return customer.isEligibleForFreeShipping();
    }

    // 장바구니에 있는 아이템 목록 출력
    public void printListOfItemsInCart() {
        System.out.print(customer.getName() + "의 장바구니 안에는 : ");
        for(Item item : this.itemList) {
            System.out.print(item.getItemName() + " ");
        }
        System.out.println("이 들어있습니다");
    }

    // 주문 생성
    public Order makeOrder() {
        return new Order(getCustomer(), calculateTotalCostOfItemsInCart());
    }
}
