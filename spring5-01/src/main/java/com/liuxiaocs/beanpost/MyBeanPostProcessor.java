package com.liuxiaocs.beanpost;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;


/**
 * postProcessBeforeInitialization
 * postProcessAfterInitialization
 * 这两个方法在接口中有默认实现
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // 将这个bean返回给Spring
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 只有是Category类型的时候才进行加工
        if(bean instanceof Category) {
            Category category = (Category) bean;
            // 重新设置值
            category.setName("xiaowb");
        }
        return bean;
    }
}
