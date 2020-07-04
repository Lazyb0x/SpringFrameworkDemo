package cn.beanbang.springcore.springerr.service;

import cn.beanbang.springcore.springerr.bean.User;
import cn.beanbang.springcore.springerr.common.MyExceptionCode;
import cn.beanbang.springcore.springerr.common.MyThrowException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public boolean saveUser(User user){

        if (user.getName().indexOf('#')!=-1){
            MyThrowException.throwErr(MyExceptionCode.USER_NAME_EXCEPTION);
        }

        if (user.getAge()<0 || user.getAge()>100){
            MyThrowException.throwErr(MyExceptionCode.USER_AGE_SCOPE_EXCEPTION);
        }

        System.out.println("saveuser: " + user);

        return true;
    }

    public void updateUser(User user) {
        System.out.println("updateuser: " + user);
    }
}
