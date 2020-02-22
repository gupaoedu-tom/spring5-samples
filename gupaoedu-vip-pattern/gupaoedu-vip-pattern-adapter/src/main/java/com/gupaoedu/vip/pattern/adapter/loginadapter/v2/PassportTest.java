package com.gupaoedu.vip.pattern.adapter.loginadapter.v2;

import org.springframework.aop.framework.adapter.AdvisorAdapter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerAdapter;

/**
 * Created by Tom.
 */
public class PassportTest {

    public static void main(String[] args) {

        IPassportForThird passportForThird = new PassportForThirdAdapter();

        passportForThird.loginForQQ("");


    }

}
