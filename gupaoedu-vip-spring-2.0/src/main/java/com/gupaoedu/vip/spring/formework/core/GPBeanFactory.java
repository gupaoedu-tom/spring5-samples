package com.gupaoedu.vip.spring.formework.core;

/**
 * 单例工厂的顶层设计
 * Created by Tom.
 */
public interface GPBeanFactory {
    /**
     * 根据beanName从IOC容器中获得一个实例Bean
     * @param beanName
     * @return
     */
    Object getBean(String beanName) throws Exception;

    Object getBean(Class<?> beanClass) throws Exception;
}
