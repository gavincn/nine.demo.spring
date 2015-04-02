package com.demo.handler;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by pingping on 三月/12/15.
 */
@Component("UserSecurityHandler")
public class UserSecurityHandler implements UserHandler{

    /**
     * 验证用户&密码
     * @param name
     * @param passwd
     * @return
     * @throws Exception
     */
    public boolean isValid(final String name,final String passwd)throws Exception{
        return "liu".equals(name) && "liu".equals(passwd);
    }
}
