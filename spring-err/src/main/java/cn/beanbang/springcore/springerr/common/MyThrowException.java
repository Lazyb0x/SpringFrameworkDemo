package cn.beanbang.springcore.springerr.common;

public class MyThrowException {

    public static void throwErr(IMyException myException){
        throw new MyRunTimeException(myException);
    }

    public static void throwErr(Exception e){
        throw new MyRunTimeException(new IMyException() {
            @Override
            public int code() {
                return -1;
            }

            @Override
            public String msg() {
                return e.toString();
            }
        });
    }
}
