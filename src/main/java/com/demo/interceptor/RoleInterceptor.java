package com.demo.interceptor;

import com.demo.exceptions.AuthorizationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by pingping on 三月/6/15.
 */
public class RoleInterceptor extends BaseInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
//        System.out.println("this is RoleInterceptor!");
//        System.out.println(o);//controller || method
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            System.out.println("throw authorization exception");
            throw new AuthorizationException();
        } else {
            return true;
        }
    }
}
