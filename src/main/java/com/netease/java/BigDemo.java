package com.netease.java;

import java.math.BigDecimal;

public class BigDemo {
    public static void main(String[] args) {
        Integer integer=new Integer(10);
        BigDecimal quantity=new BigDecimal(integer);
        BigDecimal commodityFactor=new BigDecimal("0.100");
        BigDecimal deliveryCommodityFactor=new BigDecimal("1.00");
        BigDecimal weight=quantity.multiply(commodityFactor);
        BigDecimal zore=new BigDecimal("0.0000");
        BigDecimal remainder=weight.remainder(deliveryCommodityFactor).setScale(4, BigDecimal.ROUND_HALF_UP);
        System.out.println(weight);
        System.out.println(remainder);
        System.out.println(remainder.equals(zore));
       // System.out.println(commodityFactor.multiply(integer));
    }
}
