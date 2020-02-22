package com.gupaoedu.vip.pattern.strategy.pay.payport;

/**
 * Created by Tom.
 */
public class WechatPay extends Payment {

    public String getName() {
        return "微信支付";
    }

    protected double queryBalance(String uid) {
        return 256;
    }

}
