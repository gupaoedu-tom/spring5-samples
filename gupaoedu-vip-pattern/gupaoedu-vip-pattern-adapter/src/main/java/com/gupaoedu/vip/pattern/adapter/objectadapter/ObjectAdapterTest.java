package com.gupaoedu.vip.pattern.adapter.objectadapter;

/**
 * Created by Tom
 */
public class ObjectAdapterTest {
    public static void main(String[] args) {
        DC5 dc5 = new PowerAdapter(new AC220());
        dc5.outputDC5V();
    }
}
