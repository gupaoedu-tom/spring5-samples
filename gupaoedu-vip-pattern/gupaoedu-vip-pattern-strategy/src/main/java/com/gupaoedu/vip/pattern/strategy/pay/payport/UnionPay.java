package com.gupaoedu.vip.pattern.strategy.pay.payport;

/**
 * Created by Tom.
 */
public class UnionPay extends Payment {

    public String getName() {
        return "银联支付";
    }

    protected double queryBalance(String uid) {
        return 120;
    }

}
