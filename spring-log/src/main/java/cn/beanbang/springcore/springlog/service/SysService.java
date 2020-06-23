package cn.beanbang.springcore.springlog.service;

import cn.beanbang.springcore.springlog.common.MyLog;
import org.springframework.stereotype.Component;

@Component
public class SysService {

    @MyLog(action = "获取当前时间戳")
    public Long getTimestamp(){
        Long timestamp = System.currentTimeMillis();
        System.out.println(timestamp);
        return timestamp;
    }
}
