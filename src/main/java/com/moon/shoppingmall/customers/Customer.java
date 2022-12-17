package com.moon.shoppingmall.customers;

import static com.moon.shoppingmall.customers.MembershipLevel.*;

/**
 * @author 문지현
 * @version 1.0
 * @since 2022-11-22
 */
public class Customer {

    private Integer id;
    private String name;
    private String address;

    private MembershipLevel level;

    public Customer() {};

    public Customer(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    // getters
    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public MembershipLevel getLevel() { return level; }


    // 고객이름을 입력받은 이름으로 수정
    public void setName(String name) {
        this.name = name;
    }

    // 멤버쉽레벨 지정
    public void setMembershipLevel(MembershipLevel level) { this.level = level; }

    // 고객의 멤버쉽레벨 업그레이드
    public void upgrade() {
        if(level == SILVER) {
            setMembershipLevel(GOLD);
        } else if (level == GOLD) {
            setMembershipLevel(VIP);
        }
    }

    // 고객이 무료배송에 해당하면 true를 반환
    public boolean isEligibleForFreeShipping() {
        return level != SILVER;
    }
}
