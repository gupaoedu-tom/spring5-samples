package com.gupaoedu.vip.pattern.adapter.poweradapter;

/**
 * Created by Tom on 2019/3/16.
 */
public class PowerAdapterTest {
    public static void main(String[] args) {
        DC5 dc5 = new PowerAdapter(new AC220());
        dc5.outoupDC5V();
    }
}
