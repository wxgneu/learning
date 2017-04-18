package com.netease.java;

/**
 * 委托单类型
 * Created by Feng Changhong on 2016/12/14 21:25.
 */
public enum OrderType {
    MARKET_OPEN(1), // 市价建仓
    MARKET_CLOSE(2), // 市价平仓
    LIMIT_OPEN(3), // 指价建仓
    STOP_PROFIT(4), // 止盈
    STOP_LOSS(5), // 止损
    EXPLOSION(6);//爆仓强平

    private int code;

    public int getCode() {
        return code;
    }

    OrderType(int code) {
        this.code = code;
    }

    public static OrderType codeOf(int code) {
        for (OrderType orderType : OrderType.values()) {
            if (orderType.code == code) {
                return orderType;
            }
        }
        throw new IllegalArgumentException("委托单类型的code不正确：" + code);
    }
}
