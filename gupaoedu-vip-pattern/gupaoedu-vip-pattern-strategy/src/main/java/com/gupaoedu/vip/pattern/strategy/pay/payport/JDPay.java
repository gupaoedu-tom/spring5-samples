package com.gupaoedu.vip.pattern.strategy.pay.payport;


/**
 * Created by Tom.
 */
public class JDPay extends Payment {

    public String getName() {
        return "京东白条";
    }

    protected double queryBalance(String uid) {
        return 500;
    }
}
