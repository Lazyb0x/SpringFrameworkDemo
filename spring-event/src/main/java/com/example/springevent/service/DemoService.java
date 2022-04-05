package com.example.springevent.service;

import com.example.springevent.config.RuntimeApplicationContext;
import com.example.springevent.event.DemoEvent;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    public void publishDemoEvent() {
        RuntimeApplicationContext.publishEvent(new DemoEvent(this, "每日委托"));
    }

}
