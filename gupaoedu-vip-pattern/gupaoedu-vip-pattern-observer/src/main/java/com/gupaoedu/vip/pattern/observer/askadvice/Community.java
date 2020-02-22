package com.gupaoedu.vip.pattern.observer.askadvice;

import java.util.Observable;

/**
 * Created by Tom
 */
public class Community extends Observable{
    private String name;

    public Community(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void publishQuestion(Community community, Question question){
        System.out.println(question.getUserName()+"在“" + community.name + "”上提交了一个问题。");
        setChanged();
        notifyObservers(question);
    }

}
