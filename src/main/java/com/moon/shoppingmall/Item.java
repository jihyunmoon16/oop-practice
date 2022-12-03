package com.moon.shoppingmall;

/**
 * @author 문지현
 * @version 1.0
 * @since 2022-11-22
 */
public class Item {
    private long itemId;
    private String itemName;
    private Money price;

    public Item(long itemId, String itemName, Money price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
    }

    public Money getItemPrice() {
        return this.price;
    }

    public String getItemName() {
        return this.itemName;
    }
}
