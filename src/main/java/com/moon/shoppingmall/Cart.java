package com.moon.shoppingmall;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 문지현
 * @version 1.0
 * @since 2022-11-22
 */
public class Cart {
    private Customer customer;
    private List<Item> itemList;

    public Cart() {}

    public Cart(Customer customer) {
        this.customer = customer;
        this.itemList = new ArrayList<>();
    }


    // 장바구니에 있는 아이템의 총 가격 계산
    public Money calculateTotalCostOfItemsInCart() {

        Money total = Money.ZERO;
        for (Item item : this.itemList) {
            total = total.plus(item.getItemPrice());
        }
        return total;
    }


    // 장바구니에 아이템 넣기
    public void addItem(Item item){
        this.itemList.add(item);
    }

    // 장바구니의 소유자 정하기
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // 장바구니에 있는 아이템 목록 출력
    public void printListOfItemsInCart() {
        System.out.print(customer.getName() + "의 장바구니 안에는 : ");
        for(Item item : this.itemList) {
            System.out.print(item.getItemName() + " ");
        }
        System.out.println("이 들어있습니다");
    }
}
