package com.moon.shoppingmall;

/**
 * @author 문지현
 * @version 1.0
 * @since 2022-11-22
 */
public class Customer {

    private Integer id;
    private String name;
    private String address;

    public Customer() {};

    public Customer(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

}
