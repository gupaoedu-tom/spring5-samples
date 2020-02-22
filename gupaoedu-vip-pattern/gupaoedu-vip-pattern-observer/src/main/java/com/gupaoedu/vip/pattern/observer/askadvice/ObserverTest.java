package com.gupaoedu.vip.pattern.observer.askadvice;

import org.springframework.web.context.ContextLoaderListener;

import java.util.Comparator;

/**
 * Created by Tom
 */
public class ObserverTest {
    public static void main(String[] args) {

        Community course = new Community("GPer生态圈");
        Teacher tom = new Teacher("Tom");
        Teacher mic = new Teacher("Mic");

        course.addObserver(tom);
        course.addObserver(mic);

        //业务逻辑代码
        Question question = new Question();
        question.setUserName("小明");
        question.setContent("观察者模式适用于哪些场景？");

        course.publishQuestion(course,question);

    }
}
