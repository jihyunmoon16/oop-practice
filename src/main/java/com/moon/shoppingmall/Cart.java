package com.moon.shoppingmall;

import java.util.List;

/**
 * @author 문지현
 * @version 1.0
 * @since 2022-11-22
 */
public class Cart {
    private Customer customer;
    private List<Item> itemList;

    public Cart(Customer customer, List<Item> itemList) {
        this.customer = customer;
        this.itemList = itemList;
    }


    // 장바구니에 있는 아이템의 총 가격 계산
    public Money calculateTotalCostOfItemsInCart() {

        Money total = Money.ZERO;
        for (Item item : this.itemList ) {
            total = total.plus(item.getItemPrice());
        }
        return total;
    }


    public void addItem(Item item){

        this.itemList.add(item);
    }


}
