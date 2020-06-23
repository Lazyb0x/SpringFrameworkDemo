package cn.beanbang.springcore.service;

public class SysService {
    public Long getToken(){
        long time = System.currentTimeMillis();
        System.out.println("getToken: " + time);
        return time;
    }

    public void validate(){
        throw new NullPointerException("空指针异常。");
    }
}
