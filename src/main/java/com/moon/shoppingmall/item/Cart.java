package com.moon.shoppingmall.item;

import com.moon.shoppingmall.customers.MembershipLevel;
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

    private DiscountPolicy discountPolicy;
    public Cart() {}

    public Cart(Customer customer, DiscountPolicy discountPolicy) {
        this.customer = customer;
        this.itemList = new ArrayList<>();
        this.discountPolicy = discountPolicy;
    }


    // 장바구니에 있는 아이템의 총 가격 계산
    public Money calculateTotalCostOfItemsInCart() {
        Money total = Money.ZERO;

        for (Item item : this.itemList) {
            total = total.plus(item.getItemPrice());
        }
        return total;
    }

    // 할인 적용 후 최종 가격 계산
    public Money calculateFinalCost() {
        Money total = calculateTotalCostOfItemsInCart();
        return total.minus(discountPolicy.calculateDiscountAmount(this));
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

//    public boolean isEligibleForFreeShipping() {
//        return customer.isEligibleForFreeShipping();
//    }

    // 장바구니에 있는 아이템 목록 출력
    public void printListOfItemsInCart() {
        System.out.print(customer.getName() + "의 장바구니 안에는 : ");
        for(Item item : this.itemList) {
            System.out.print(item.getItemName() + " ");
        }
        System.out.println("이 들어있습니다");
    }

    public boolean isMembershipLevelSatisfiedBy(MembershipLevel memLv) {
        return customer.isMembershipLevelSameOrHigher(memLv);
    }

    // 주문 생성
    // TODO 주문 시 가격은 할인 가격이 적용된 가격을 보여줘야함. 배송비가 추가되는지 아닌지 할인을 받는지 아닌지
    public Order makeOrder() {
        return new Order(getCustomer(), calculateFinalCost());
    }
}
