package com.example.springevent.listener;

import com.example.springevent.event.DemoEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * 基于接口的事件监听
 */
@Component
public class DemoEventListener implements ApplicationListener<DemoEvent>, Ordered {

    @Override
    public void onApplicationEvent(DemoEvent event) {
        System.out.println("监听器 1 处理事件：" + event.getMessage());
    }

    @Override
    public int getOrder() {
        // 数字越小优先级越高
        return 999;
    }
}
