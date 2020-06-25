package cn.beanbang.springcore.springerr.common;

public class MyRunTimeException extends RuntimeException{

    public MyRunTimeException(IMyException myException) {
        super("错误代码：" + myException.code() + "，错误信息：" + myException.msg());
    }
}
