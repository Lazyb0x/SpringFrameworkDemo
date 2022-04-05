package com.example.springevent.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

@Component
public class RuntimeApplicationContext implements ApplicationContextAware {

    private static ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (RuntimeApplicationContext.applicationContext == null) {
            RuntimeApplicationContext.applicationContext = applicationContext;
        }
    }

    public static ApplicationContext getContext() {
        return applicationContext;
    }

    public static void publishEvent(ApplicationEvent applicationEvent) {
        applicationContext.publishEvent(applicationEvent);
    }
}
