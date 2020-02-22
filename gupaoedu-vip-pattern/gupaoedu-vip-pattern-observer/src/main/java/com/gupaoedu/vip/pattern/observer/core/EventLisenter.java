package com.gupaoedu.vip.pattern.observer.core;


import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tom.
 */
public class EventLisenter {

    protected Map<String,Event> events = new HashMap<String,Event>();

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


    private void trigger(Event event) {
        event.setSource(this);
        event.setTime(System.currentTimeMillis());

        try {
            event.getCallback().invoke(event.getTarget(),event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void trigger(String trigger){
        if(!this.events.containsKey(trigger)){return;}
        trigger(this.events.get(trigger).setTrigger(trigger));
    }

    private String toUpperFirstCase(String str){
        char[] chars = str.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }

}
