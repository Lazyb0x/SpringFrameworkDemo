package com.example.springevent;

import com.example.springevent.service.DemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <a href="https://www.baeldung.com/spring-events">Spring Events</a>
 */
@SpringBootTest
class SpringEventApplicationTests {

    @Autowired
    DemoService demoService;

    @Test
    void contextLoads() {
    }

    @Test
    void event() {
        demoService.publishDemoEvent();
    }


}
