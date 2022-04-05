package com.example.springevent.listener;

import com.example.springevent.event.DemoEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * 基于注解的事件监听
 */
@Component
public class AnnotationEventListener {

    @EventListener
    @Order(998)
    // @Async // 加上异步注解使它能够异步执行
    public void handleDemoEvent(DemoEvent event) {
        System.out.println("监听器 2 处理事件：" + event.getMessage());
    }

    // 事务绑定的监听器
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void transactionalEvent(DemoEvent event) {
        System.out.println("监听器 3 处理事件：" + event.getMessage());
    }


    // Spring 有一些内置的事件
    @EventListener
    public void afterStart(ApplicationStartedEvent event) {
        System.out.println("程序启动完成。");
    }

}
