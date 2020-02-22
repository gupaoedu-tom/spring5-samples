package com.gupaoedu.vip.pattern.observer.mouseevent;

import com.gupaoedu.vip.pattern.observer.core.EventLisenter;

/**
 * Created by Tom.
 */
public class Mouse extends EventLisenter {

    public void click(){
        System.out.println("调用单击方法");
        this.trigger("click");
    }

    public void doubleClick(){
        System.out.println("调用双击方法");
        this.trigger("doubleClick");
    }

    public void up(){
        System.out.println("调用弹起方法");
        this.trigger("up");
    }

    public void down(){
        System.out.println("调用按下方法");
        this.trigger("down");
    }

    public void move(){
        System.out.println("调用移动方法");
        this.trigger("move");
    }

    public void wheel(){
        System.out.println("调用滚动方法");
        this.trigger("wheel");
    }

    public void over(){
        System.out.println("调用悬停方法");
        this.trigger("over");
    }

    public void blur(){
        System.out.println("调用获焦方法");
        this.trigger("blur");
    }

    public void focus(){
        System.out.println("调用失焦方法");
        this.trigger("focus");
    }
}
