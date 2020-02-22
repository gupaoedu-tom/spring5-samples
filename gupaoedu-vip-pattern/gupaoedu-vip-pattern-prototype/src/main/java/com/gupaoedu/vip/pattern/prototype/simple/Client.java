package com.gupaoedu.vip.pattern.prototype.simple;

/**
 * Created by Tom.
 */
public class Client {

    public Prototype startClone(Prototype concretePrototype){
        return (Prototype)concretePrototype.clone();
    }

}
