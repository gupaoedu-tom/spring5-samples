package com.gupaoedu.vip.pattern.observer.events.core;


import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 监听器，它就是观察者
 * Created by Tom.
 */
public class EventLisenter {

    //JDK底层的Lisenter通常也是这样来设计的
    protected Map<String,Event> events = new HashMap<String,Event>();

    //事件名称和一个目标对象来触发事件
    public void addLisenter(String eventType,Object target){
        try {
            this.addLisenter(
                    eventType,
                    target,
                    target.getClass().getMethod("on" + toUpperFirstCase(eventType),Event.class));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addLisenter(String eventType,Object target,Method callback){
        //注册事件
        events.put(eventType, new Event(target, callback));
    }


    //触发，只要有动作就触发
    private void trigger(Event event) {
        event.setSource(this);
        event.setTime(System.currentTimeMillis());

        try {
            //发起回调
            if(event.getCallback() != null){
                //用反射调用它的回调函数
                event.getCallback().invoke(event.getTarget(),event);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //事件名称触发
    protected void trigger(String trigger){
        if(!this.events.containsKey(trigger)){return;}
        trigger(this.events.get(trigger).setTrigger(trigger));
    }

    //逻辑处理的私有方法，首字母大写
    private String toUpperFirstCase(String str){
        char[] chars = str.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }

}
