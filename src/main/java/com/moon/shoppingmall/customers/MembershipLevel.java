package com.moon.shoppingmall.customers;

import java.util.Comparator;

/**
 * @author 문지현
 * @version 1.0
 * @since 2022-12-08
 */
public enum MembershipLevel implements Comparator<MembershipLevel> {

       SILVER(1), GOLD(2), VIP(3);

       private final int value;

       MembershipLevel(int value) { this.value = value; }
       public int getValue() { return value; }

       @Override
       public int compare(MembershipLevel o1, MembershipLevel o2) {

              int member1Value = o1.getValue();
              int member2Value = o2.getValue();

              return Integer.compare(member1Value, member2Value);
       }
}
