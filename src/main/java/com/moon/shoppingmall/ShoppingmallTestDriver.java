package com.moon.shoppingmall;

/**
 * @author 문지현
 * @version 1.0
 * @since 2022-11-22
 */
public class ShoppingmallTestDriver {

    public static void main(String[] args) {
        Customer jane = new Customer(1, "제인", "서울 강남");
        Customer lisa = new Customer(2, "리사", "강원 원주");
        Customer jenny = new Customer(3, "제니", "경기도 수원");

        Item iphone = new Item(1, "아이폰", Money.wons(1000000));
        Item galaxy = new Item(2, "갤럭시", Money.wons(1000000));
        Item motorola = new Item(3, "추억의 모토로라", Money.wons(200000));

        Cart janeCart = new Cart(jane);
        Cart lisaCart = new Cart(lisa);
        Cart jennyCart = new Cart(jenny);

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
    }
}
