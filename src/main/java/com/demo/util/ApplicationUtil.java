package com.demo.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by pingping on 三月/15/15.
 */
@Component
@Scope("singleton")
public class ApplicationUtil implements ApplicationContextAware {


    @Autowired
    private static ApplicationContext context;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }


    public static ApplicationContext getApplicationContext() {
        return context;
    }
    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }

    public static <T>T getBean(String beanName , Class<T>clazz) {
        return context.getBean(beanName , clazz);
    }
}
