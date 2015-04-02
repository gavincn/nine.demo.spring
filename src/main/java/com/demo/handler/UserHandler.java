package com.demo.handler;

/**
 * Created by pingping on 三月/15/15.
 */
public interface UserHandler {
    boolean isValid(String name, String pwd) throws Exception;
}
